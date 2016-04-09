package model.service;

import java.util.List;

import model.domain.Eleitor;

public interface EleitorService {
	public List<Eleitor> getEleitores();
	public List<Eleitor> getEleitores(Eleitor eleitor);
}

