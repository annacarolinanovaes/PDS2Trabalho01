package model.service;

import java.util.List;

import model.domain.ZonaEleitoral;

public interface ZonaEleitoralService {
	public List<ZonaEleitoral> getEleitores();
	public List<ZonaEleitoral> getEleitores(ZonaEleitoral zonaEleitoral);
}
