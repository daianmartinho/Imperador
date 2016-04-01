package excecao;

import anotacao.ExcecaoDeAplicacao;

@ExcecaoDeAplicacao
public class AniversarianteNaoEncontradoException extends AplicacaoException
{	
	private final static long serialVersionUID = 1;
	
	public AniversarianteNaoEncontradoException(String msg)
	{	super(msg);
	}
}	