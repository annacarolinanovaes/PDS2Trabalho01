package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Secao;

public class SecaoDaoImpl implements SecaoDao {
	
	@PersistenceContext(unitName="bdtre")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Secao> getSecoes(Secao secao) {
		StringBuffer hql = new StringBuffer("from Secao e"
				+ " where 1 = 1");		
		if (secao.getCodSecao() != null) {
			hql.append(" and e.codSecao = :codSecao");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (secao.getCodSecao()  != null) {
			query.setParameter("codigo",secao.getCodSecao());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Secao secao){
		secao = entityManager.merge(secao);
		entityManager.remove(secao);
	}
	
	@Override
	@Transactional
	public Secao salvar(Secao secao) {
		entityManager.persist(secao);
		return secao;
	}
	
	@Override
	@Transactional
	public void atualizar(Secao secao) {
		secao = entityManager.merge(secao);
		entityManager.persist(secao);
	}
	

}