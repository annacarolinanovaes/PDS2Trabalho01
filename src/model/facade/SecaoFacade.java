package model.facade;

import java.util.List;

import model.domain.Secao;

public interface SecaoFacade {	
	List<Secao> getSecoes();
	List<Secao> getSecoes(Integer codigo);
	void deletarSecao(Integer codigo);
	public Secao salvar(Secao secao);
	void atualizar(Secao secao);
}
