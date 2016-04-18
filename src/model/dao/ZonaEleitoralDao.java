package model.dao;

import java.util.List;

import model.domain.ZonaEleitoral;

public interface ZonaEleitoralDao {
	public void excluir(ZonaEleitoral zonaEleitoral);
	public ZonaEleitoral salvar(ZonaEleitoral zonaEleitoral);
	void atualizar(ZonaEleitoral zonaEleitoral);
	List<ZonaEleitoral> getZonasEleitorais(ZonaEleitoral zonaEleitoral);
}


	