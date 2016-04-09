package model.util;

@SuppressWarnings("serial")
public class EleitorNaoEncontradoException extends Exception{

	public EleitorNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}
}