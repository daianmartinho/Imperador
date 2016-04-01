package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.AniversarianteDAO;
import excecao.ObjetoNaoEncontradoException;
import excecao.AniversarianteNaoEncontradoException;
import java.util.HashMap;
import java.util.HashSet;
import modelo.Aniversariante;

public class AniversarianteAppService
{	
	private AniversarianteDAO aniversarianteDAO = null;

	@Autowired
	public void setAniversarianteDAO(AniversarianteDAO aniversarianteDAO)
	{	this.aniversarianteDAO = aniversarianteDAO;
	}
	
        @Transactional
	public long inclui(Aniversariante umAniversariante) 
	{	return aniversarianteDAO.inclui(umAniversariante).getId();
	}

	@Transactional
	public void altera(Aniversariante umAniversariante)
		throws AniversarianteNaoEncontradoException
	{	try
		{	aniversarianteDAO.getPorIdComLock(umAniversariante.getId());
			aniversarianteDAO.altera(umAniversariante);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AniversarianteNaoEncontradoException("Aniversariante não encontrado");
		}
	}

	@Transactional
	public void exclui(Aniversariante umAniversariante) 
		throws AniversarianteNaoEncontradoException
	{	try
		{	Aniversariante aniversariante = aniversarianteDAO.recuperaUmAniversarianteEFestas(umAniversariante.getId());

//			if(produto.getLances().size() > 0)
//			{	throw new ProdutoNaoEncontradoException("Este produto possui lances e n?o pode ser removido");
//			}

			aniversarianteDAO.exclui(aniversariante);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AniversarianteNaoEncontradoException("Aniversariante não encontrado");
		}
	}

	public Aniversariante recuperaUmAniversariante(long numero) 
		throws AniversarianteNaoEncontradoException
	{	try
		{	return aniversarianteDAO.getPorId(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AniversarianteNaoEncontradoException("Aniversariante não encontrado");
		}
	}

	public Aniversariante recuperaUmAniversarianteEFestas(long numero) 
		throws AniversarianteNaoEncontradoException
	{	try
		{	return aniversarianteDAO.recuperaUmAniversarianteEFestas(numero);
		} 
		catch(ObjetoNaoEncontradoException e)
		{	throw new AniversarianteNaoEncontradoException("Aniversariante não encontrado");
		}
	}

	public List<Aniversariante> recuperaAniversariantesEFestas()
	{	return aniversarianteDAO.recuperaListaDeAniversariantesEFestas();
	}
        
        public List<Aniversariante> recuperaAniversariantes(int deslocamento, int linhasPorPagina, String nome ) 
	{	
		List<Aniversariante> aniversariantes = aniversarianteDAO.recuperaAniversariantes(deslocamento, linhasPorPagina, nome + "%");

		return aniversariantes;
	}
        
        public List<Aniversariante> recuperaAniversariantes(String nome ) 
	{			
		return recuperaAniversariantes(-1,-1,nome);
	}
        
        public int recuperaQtdDeRegistros(String nome) 
	{	
            int qtd = aniversarianteDAO.recuperaQtdDeRegistros(nome + "%");
            return qtd;
	}
        
        
}