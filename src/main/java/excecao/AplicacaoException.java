package excecao;

import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class AplicacaoException extends Exception
{	
	private final static long serialVersionUID = 1;

	public AplicacaoException(String msg)
	{	super(msg);
	}
}	