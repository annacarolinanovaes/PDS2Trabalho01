package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.domain.ZonaEleitoral;

public class ZonaEleitoralDaoImpl implements ZonaEleitoralDao {

	@PersistenceContext(unitName="bdtre")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ZonaEleitoral> getZonasEleitorais(ZonaEleitoral zonaEleitoral) {
		StringBuffer hql = new StringBuffer("from ZonaEleitoral e"
				+ " where 1 = 1");		
		if (zonaEleitoral.getCodZona() != null) {
			hql.append(" and e.codZonaEleitoral = :codZonaEleitoral");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (zonaEleitoral.getCodZona()  != null) {
			query.setParameter("codigo",zonaEleitoral.getCodZona());
		} 
		return query.getResultList();
	}

	@Override
	public void excluir(ZonaEleitoral zonaEleitoral) {
		zonaEleitoral = entityManager.merge(zonaEleitoral);
		entityManager.remove(zonaEleitoral);
	}

	@Override
	public ZonaEleitoral salvar(ZonaEleitoral zonaEleitoral) {
		entityManager.persist(zonaEleitoral);
		return zonaEleitoral;
	}

	@Override
	public void atualizar(ZonaEleitoral zonaEleitoral) {
		zonaEleitoral = entityManager.merge(zonaEleitoral);
		entityManager.persist(zonaEleitoral);
	}

}
