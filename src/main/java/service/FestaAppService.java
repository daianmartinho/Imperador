package service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.FestaDAO;
import dao.AniversarianteDAO;
import excecao.DataDeLanceInvalidaException;
import excecao.LanceNaoEncontradoException;
import excecao.ObjetoNaoEncontradoException;
import excecao.ProdutoNaoEncontradoException;
import excecao.ValorDeLanceInvalidoException;
import modelo.Festa;
import modelo.Aniversariante;
import util.Util;

public class FestaAppService
{	
	private AniversarianteDAO aniversarianteDAO = null;
	private FestaDAO festaDAO = null;
	
	public void setAniversarianteDAO(AniversarianteDAO aniversarianteDAO)
	{	this.aniversarianteDAO = aniversarianteDAO;
	}

	public void setFestaDAO(FestaDAO festaDAO)
	{	this.festaDAO = festaDAO;
	}

	@Transactional
	public long inclui(Festa umaFesta) throws ProdutoNaoEncontradoException, ValorDeLanceInvalidoException, DataDeLanceInvalidaException 
	{
		// A  implementa��o do  m�todo  getPorIdComLock(umProduto.getId()) 
		// impede que dois  lances  sejam  cadastrados em  paralelo, i. �, 
		// os lances  devem ser  cadastrados  obedecendo a uma fila.  Isto
		// impede que o valor do segundo lance seja  inferior  ao valor do
		// primeiro.
	
		Aniversariante umAniversariante = umaFesta.getAniversariante();
		
		try
		{	umAniversariante = aniversarianteDAO.getPorIdComLock(umAniversariante.getId());
		}
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Aniversariatne não encontrado");
		}

		Festa ultimaFesta; 
		try
		{	ultimaFesta = festaDAO.recuperaUltimaFesta(umAniversariante);
		}
		catch(ObjetoNaoEncontradoException e)
		{	ultimaFesta = null;	
		}
	
		
		Calendar   dataInicioUltimaFesta;
                
		
		if (ultimaFesta == null)
		{	
                    dataInicioUltimaFesta = umAniversariante.getDataCadastro();			
		}
		else
		{	
                    dataInicioUltimaFesta  = ultimaFesta.getDataInicio();
		}
		
			
		if(umaFesta.getDataInicio().before(dataInicioUltimaFesta))
		{	
			throw new DataDeLanceInvalidaException("A data da festa não pode ser anterior a " 
					+ Util.calendarToStr(dataInicioUltimaFesta));
		}
	
		GregorianCalendar hoje = new GregorianCalendar();
		
//		if(umaFesta.getDataInicio().after(hoje))
//		{	
//			throw new DataDeLanceInvalidaException("A data de emiss�o do lance n�o pode ser posterior � data de hoje: " 
//					+ Util.calendarToStr(hoje));
//		}
	
		Festa festa = festaDAO.inclui(umaFesta);

		return festa.getId();
	}	
        @Transactional
	public void altera(Festa umaFesta)
		throws ProdutoNaoEncontradoException
	{	try
		{	festaDAO.getPorIdComLock(umaFesta.getId());
			festaDAO.altera(umaFesta);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new ProdutoNaoEncontradoException("Festa n�o encontrada");
		}
	}
        
	@Transactional
	public void exclui(Festa umaFesta) 
		throws LanceNaoEncontradoException 
	{	try
		{	umaFesta = festaDAO.getPorId(umaFesta.getId());
			festaDAO.exclui(umaFesta);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new LanceNaoEncontradoException("Festa não encontrada.");
		}
	}

	public Festa recuperaUmaFesta(long numero) 
		throws LanceNaoEncontradoException
	{	try
		{	return festaDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new LanceNaoEncontradoException("Festa não encontrada.");
		}
	}

//	public List<Festa> recuperaFestas()
//	{	return festaDAO.recuperaListaDeFestas();
//	}
       public List<Festa> recuperaFestasDoAniversariante(long aniversarianteID) 
	{	
		List<Festa> festas = festaDAO.recuperaFestasDoAniversariante(aniversarianteID);
		return festas;
	}        
        
        
        public int recuperaQtdDeFestasDoAniversariante(long aniversarianteID) 
	{	
            int qtd = festaDAO.recuperaQtdDeRegistros(aniversarianteID);
            return qtd;
	}
}