package model.facade;

import java.util.List;

import model.domain.ZonaEleitoral;

public interface ZonaEleitoralFacade {
	List<ZonaEleitoral> getZonasEleitorais();

	List<ZonaEleitoral> getZonasEleitorais(Integer codigo);

	ZonaEleitoral salvar(ZonaEleitoral zonaEleitoral);

	void atualizar(ZonaEleitoral zonaEleitoral);

	void deletarZonaEleitoral(Integer codigo);
}

