package model.dao;

import java.util.List;

import model.domain.Eleitor;

public interface EleitorDao {

	List<Eleitor> getEleitores(Eleitor eleitor);
	public void excluir(Eleitor eleitor);
	public Eleitor salvar(Eleitor eleitor);
	void atualizar(Eleitor eleitor);

}