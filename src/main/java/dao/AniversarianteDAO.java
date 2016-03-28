package dao;

import java.util.List;
import java.util.Set;

import modelo.Aniversariante;
import anotacao.RecuperaConjunto;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import excecao.ObjetoNaoEncontradoException;



public interface AniversarianteDAO extends DaoGenerico<Aniversariante, Long>
{   
	/* ****** Métodos Genéricos ******* */

	@RecuperaObjeto
	Aniversariante recuperaUmAniversarianteEFestas(long numero) 
		throws ObjetoNaoEncontradoException;

//	@RecuperaLista
//	List<Aniversariante> recuperaListaDeAniversariantes();
	
	@RecuperaLista
	List<Aniversariante> recuperaListaDeAniversariantesEFestas();

        @RecuperaLista
        List<Aniversariante> recuperaAniversariantes(int des, int lin,String nome);
        
        @RecuperaLista
        List<Aniversariante> recuperaAniversariantes(String nome);
        
        @RecuperaObjeto
        int recuperaQtdDeRegistros(String nome);
	        
	/* ****** M�todos n�o Gen�ricos ******* */

	// Um m�todo definido aqui, que n�o seja anotado, dever� ser
	// implementado como final em ProdutoDAOImpl.
}
