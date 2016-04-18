package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.ZonaEleitoralDao;
import model.domain.ZonaEleitoral;
import model.facade.ZonaEleitoralFacade;

@WebService(serviceName="ws/zonaeleitoral")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)

public class ZonaEleitoralFacadeImpl implements ZonaEleitoralFacade {
	
	@Inject
	private ZonaEleitoralDao zonaEleitoralDao;
	
	@WebMethod
	public List<ZonaEleitoral> getZonasEleitorais() {
		return zonaEleitoralDao.getZonasEleitorais(new ZonaEleitoral());
	}
	
	@WebMethod(operationName="getZonasEleitoraisCodigo")
	public List<ZonaEleitoral> getZonasEleitorais(Integer codigo) {
		ZonaEleitoral zonaEleitoral = new ZonaEleitoral();
		zonaEleitoral.setCodZona(codigo);
		return zonaEleitoralDao.getZonasEleitorais(zonaEleitoral);
	}
	
	@WebMethod
	public ZonaEleitoral salvar(@WebParam(name="zonaeleitoral") ZonaEleitoral zonaEleitoral){
		return zonaEleitoralDao.salvar(zonaEleitoral);
	}
	
	@WebMethod
	public void atualizar(ZonaEleitoral zonaEleitoral){
		zonaEleitoralDao.atualizar(zonaEleitoral);
	}
	
	@WebMethod
	public void deletarZonaEleitoral(Integer codigo){
		ZonaEleitoral zonaEleitoral = new ZonaEleitoral();
		zonaEleitoral.setCodZona(codigo);
		zonaEleitoralDao.excluir(zonaEleitoral);
	}
	
}