package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.ZonaEleitoralDao;
import model.domain.ZonaEleitoral;
import model.facade.ZonaEleitoralFacade;

@Path("/zonaeleitoral")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class ZonaEleitoralFacadeImpl implements ZonaEleitoralFacade {
	
	@Inject
	private ZonaEleitoralDao zonaEleitoralDao;

	@Override
	@GET
	public List<ZonaEleitoral> getZonasEleitorais() {
		return zonaEleitoralDao.getZonasEleitorais(new ZonaEleitoral());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<ZonaEleitoral>  getZonasEleitorais(@PathParam("codigo") Integer codigo) {
		ZonaEleitoral zonaEleitoral = new ZonaEleitoral();
		zonaEleitoral.setCodZona(codigo);
		return zonaEleitoralDao.getZonasEleitorais(zonaEleitoral);		
	}
	
	@Override
	@POST
	public ZonaEleitoral salvar(ZonaEleitoral zonaEleitoral) {
		zonaEleitoral = zonaEleitoralDao.salvar(zonaEleitoral);
		return zonaEleitoral;
	}
	
	@Override
	@PUT
	public void atualizar(ZonaEleitoral zonaEleitoral){
		zonaEleitoralDao.atualizar(zonaEleitoral);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarZonaEleitoral(@PathParam("codigo") Integer codigo) {
		ZonaEleitoral zonaEleitoral = new ZonaEleitoral();
		zonaEleitoral.setCodZona(codigo);
		zonaEleitoralDao.excluir(zonaEleitoral);	
	}
}