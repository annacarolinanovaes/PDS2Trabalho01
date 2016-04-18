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

import model.dao.SecaoDao;
import model.domain.Secao;
import model.facade.SecaoFacade;

@Path("/secao")
@Consumes({MediaType.APPLICATION_JSON,
		   MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
public class SecaoFacadeImpl implements SecaoFacade {
	
	@Inject
	private SecaoDao secaoDao;

	@Override
	@GET
	public List<Secao> getSecoes() {
		return secaoDao.getSecoes(new Secao());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Secao>  getSecoes(@PathParam("codigo") Integer codigo) {
		Secao secao = new Secao();
		secao.setCodSecao(codigo);
		return secaoDao.getSecoes(secao);		
	}
	
	@Override
	@POST
	public Secao salvar(Secao secao) {
		secao = secaoDao.salvar(secao);
		return secao;
	}
	
	@Override
	@PUT
	public void atualizar(Secao secao){
		secaoDao.atualizar(secao);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarSecao(@PathParam("codigo") Integer codigo) {
		Secao secao = new Secao();
		secao.setCodSecao(codigo);
			secaoDao.excluir(secao);	
	}
}