package excecao;

import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class FestaNaoEncontradaException extends AplicacaoException
{	
	private final static long serialVersionUID = 1;

	public FestaNaoEncontradaException(String msg)
	{	super(msg);
	}
}	