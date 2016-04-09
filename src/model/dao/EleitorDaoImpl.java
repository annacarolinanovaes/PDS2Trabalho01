package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Eleitor;

public class EleitorDaoImpl implements EleitorDao {
	
	@PersistenceContext(unitName="bdtre")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Eleitor> getEleitores(Eleitor eleitor) {
		StringBuffer hql = new StringBuffer("from Eleitor e"
				+ " where 1 = 1");		
		if (eleitor.getCodEleitor() != null) {
			hql.append(" and e.codEleitor = :codEleitor");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (eleitor.getCodEleitor()  != null) {
			query.setParameter("codigo",eleitor.getCodEleitor());
		} 
		return query.getResultList();
	}
	
	@Override //Método que não existe
	@Transactional
	public void excluir(Eleitor eleitor){
		eleitor = entityManager.merge(eleitor);
		entityManager.remove(eleitor);
	}
	
	@Override
	@Transactional
	public Eleitor salvar(Eleitor eleitor) {
		entityManager.persist(eleitor);
		return eleitor;
	}
	
	@Override
	@Transactional
	public void atualizar(Eleitor eleitor) {
		eleitor = entityManager.merge(eleitor);
		entityManager.persist(eleitor);
	}
	

}