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

import model.dao.EleitorDao;
import model.domain.Eleitor;
import model.facade.EleitorFacade;

@Path("/eleitor")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class EleitorFacadeImpl implements EleitorFacade {
	
	@Inject
	private EleitorDao eleitorDao;

	@Override
	@GET
	public List<Eleitor> getEleitores() {
		return eleitorDao.getEleitores(new Eleitor());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Eleitor>  getEleitores(@PathParam("codigo") Integer codigo) {
		Eleitor eleitor = new Eleitor();
		eleitor.setCodEleitor(codigo);
		return eleitorDao.getEleitores(eleitor);		
	}
	
	@Override
	@POST
	public Eleitor salvar(Eleitor eleitor) {
		eleitor = eleitorDao.salvar(eleitor);
		return eleitor;
	}
	
	@Override
	@PUT
	public void atualizar(Eleitor eleitor){
		eleitorDao.atualizar(eleitor);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarEleitor(@PathParam("codigo") Integer codigo) {
		Eleitor eleitor = new Eleitor();
		eleitor.setCodEleitor(codigo);
			eleitorDao.excluir(eleitor);	
	}
}