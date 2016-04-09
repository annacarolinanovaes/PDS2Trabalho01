package model.facade;

import java.util.List;

import model.domain.Eleitor;

public interface EleitorFacade {
	List<Eleitor> getEleitores();

	List<Eleitor> getEleitores(Integer codigo);

	Eleitor salvar(Eleitor eleitor);

	void atualizar(Eleitor eleitor);

	void deletarEleitor(Integer codigo);
}
