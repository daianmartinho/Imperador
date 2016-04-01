package dao.controle;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import anotacao.RecuperaConjunto;
import anotacao.RecuperaLista;
import anotacao.RecuperaObjeto;
import anotacao.RecuperaUltimoOuPrimeiro;
import dao.impl.JPADaoGenerico;
import excecao.InfraestruturaException;

public class InterceptadorDeDAO implements MethodInterceptor 
{
	/* Parametros:
	 * 
	 * objeto - "this", o objeto "enhanced", isto ï¿½, o proxy.
	 * 
	 * metodo - o  mï¿½todo   interceptado,  isto  ï¿½,  um   mï¿½todo  da 
	 *          interface ProdutoDAO, LanceDAO, etc. 
	 * 
	 * args - um  array  de args; tipos  primitivos sï¿½o empacotados.
	 *        Contï¿½m   os   argumentos  que  o  mï¿½todo  interceptado 
	 *        recebeu.
	 * 
	 * metodoProxy - utilizado para executar um mï¿½todo super. Veja o
	 *               comentï¿½rio abaixo.
	 * 
	 * MethodProxy  -  Classes  geradas pela  classe Enhancer passam 
	 * este objeto para o objeto MethodInterceptor registrado quando
	 * um mï¿½todo  interceptado ï¿½  executado.  Ele pode ser utilizado
	 * para  invocar o  mï¿½todo  original,  ou  chamar o mesmo mï¿½todo
	 * sobre um objeto diferente do mesmo tipo.
	 * 
	 */
	
	public Object intercept (Object objeto, 
    		                 Method metodo, 
    		                 Object[] args,    
                             MethodProxy metodoDoProxy) 
    	throws Throwable 
    {
		// O sï¿½mbolo ? representa um tipo desconhecido.
        JPADaoGenerico<?,?> daoGenerico = (JPADaoGenerico<?,?>)objeto;

        if(metodo.isAnnotationPresent(RecuperaLista.class))
		{	// O mï¿½todo buscaLista() retorna um List
        	return daoGenerico.buscaLista(metodo, args);
        }
        else if(metodo.isAnnotationPresent(RecuperaConjunto.class))
        {	// O mï¿½todo buscaConjunto() retorna um Set
        	return daoGenerico.buscaConjunto(metodo, args);
        }
        else if(metodo.isAnnotationPresent(RecuperaUltimoOuPrimeiro.class))
        {	// O mï¿½todo buscaUltimoOuPrimeiro() retorna um Objeto (Entidade)
        	return daoGenerico.buscaUltimoOuPrimeiro(metodo, args);
        }
        else if(metodo.isAnnotationPresent(RecuperaObjeto.class))
        {	// O mï¿½todo busca() retorna um Objeto (Entidade)
        	return daoGenerico.busca(metodo, args);
        }               
        else 
        {  	throw new InfraestruturaException("Um método não final deixou de ser anotado");
        	// return metodoDoProxy.invokeSuper(objeto, args);
        }
    }

}
