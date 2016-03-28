package dao;

import java.util.List;
import modelo.Festa;
import modelo.Aniversariante;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import anotacao.RecuperaUltimoOuPrimeiro;
import excecao.ObjetoNaoEncontradoException;

public interface FestaDAO extends DaoGenerico<Festa, Long>
{	
	@RecuperaLista
	List<Festa> recuperaListaDeFestas(int des, int lin);
	
	@RecuperaUltimoOuPrimeiro
	Festa recuperaUltimaFesta(Aniversariante aniversariante)
		throws ObjetoNaoEncontradoException; 
        
        @RecuperaLista
        List<Festa> recuperaFestasDoAniversariante(int des,int lin,long aniversarianteID);
        
       
        @RecuperaObjeto
        int recuperaQtdDeRegistrosDoAniversariante(long nome);
        
        @RecuperaObjeto
        int recuperaQtdDeRegistros();
}
