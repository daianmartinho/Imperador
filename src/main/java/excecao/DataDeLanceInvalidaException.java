package excecao;

import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class DataDeLanceInvalidaException extends AplicacaoException
{	
	private final static long serialVersionUID = 1;

	public DataDeLanceInvalidaException(String msg)
	{	super(msg);
	}
}	