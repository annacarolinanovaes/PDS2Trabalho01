package model.service;

import java.util.List;

import model.domain.Secao;

public interface SecaoService {
	public List<Secao> getSecoes();
	public List<Secao> getSecoes(Secao secao);
}


