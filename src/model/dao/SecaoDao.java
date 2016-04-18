package model.dao;

import java.util.List;

import model.domain.Secao;

public interface SecaoDao {

	List<Secao> getSecoes(Secao secao);
	public void excluir(Secao secao);
	public Secao salvar(Secao secao);
	void atualizar(Secao secao);
}
