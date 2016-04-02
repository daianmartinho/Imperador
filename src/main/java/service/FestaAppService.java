package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.FestaDAO;
import dao.AniversarianteDAO;
import excecao.FestaNaoEncontradaException;
import excecao.ObjetoNaoEncontradoException;
import excecao.AniversarianteNaoEncontradoException;
import modelo.Festa;

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
	public long inclui(Festa umaFesta) throws AniversarianteNaoEncontradoException 
	{
		// A  implementa��o do  m�todo  getPorIdComLock(umProduto.getId()) 
		// impede que dois  lances  sejam  cadastrados em  paralelo, i. �, 
		// os lances  devem ser  cadastrados  obedecendo a uma fila.  Isto
		// impede que o valor do segundo lance seja  inferior  ao valor do
		// primeiro.
		
		Festa festa = festaDAO.inclui(umaFesta);

		return festa.getId();
	}	
        @Transactional
	public void altera(Festa umaFesta)
		throws AniversarianteNaoEncontradoException
	{	try
		{	festaDAO.getPorIdComLock(umaFesta.getId());
			festaDAO.altera(umaFesta);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AniversarianteNaoEncontradoException("Festa n�o encontrada");
		}
	}
        
	@Transactional
	public void exclui(Festa umaFesta) 
		throws FestaNaoEncontradaException 
	{	try
		{	umaFesta = festaDAO.getPorId(umaFesta.getId());
			festaDAO.exclui(umaFesta);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new FestaNaoEncontradaException("Festa não encontrada.");
		}
	}

	public Festa recuperaUmaFesta(long numero) 
		throws FestaNaoEncontradaException
	{	try
		{	return festaDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new FestaNaoEncontradaException("Festa não encontrada.");
		}
	}
        
        public Festa recuperaFestaEAniversariante(long numero) 
		throws FestaNaoEncontradaException
	{	try
		{	return festaDAO.recuperaFestaEAniversariante(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new FestaNaoEncontradaException("Festa não encontrada.");
		}
	}

	public List<Festa> recuperaFestas(int deslocamento, int linhasPorPagina)
	{	
            
            return festaDAO.recuperaListaDeFestas(deslocamento,linhasPorPagina);
	}
         
        public int recuperaQtdDeFestasDoAniversariante(long aniversarianteID) 
	{	
            int qtd = festaDAO.recuperaQtdDeRegistrosDoAniversariante(aniversarianteID);
            return qtd;
	}
        public int recuperaQtdDeFestas() 
	{	
            int qtd = festaDAO.recuperaQtdDeRegistros();
            return qtd;
	}
}