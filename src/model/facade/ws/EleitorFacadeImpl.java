package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.EleitorDao;
import model.domain.Eleitor;
import model.facade.EleitorFacade;

@WebService(serviceName="ws/eleitor")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)

public class EleitorFacadeImpl implements EleitorFacade {
	
	@Inject
	private EleitorDao eleitorDao;
	
	@WebMethod
	public List<Eleitor> getEleitores() {
		return eleitorDao.getEleitores(new Eleitor());
	}
	
	@WebMethod(operationName="getEleitoresCodigo")
	public List<Eleitor> getEleitores(Integer codigo) {
		Eleitor eleitor = new Eleitor();
		eleitor.setCodEleitor(codigo);
		return eleitorDao.getEleitores(eleitor);
	}
	
	@WebMethod
	public Eleitor salvar(@WebParam(name="eleitor") Eleitor eleitor){
		return eleitorDao.salvar(eleitor);
	}
	
	@WebMethod
	public void atualizar(Eleitor eleitor){
		eleitorDao.atualizar(eleitor);
	}
	
	@WebMethod
	public void deletarEleitor(Integer codigo){
		Eleitor eleitor = new Eleitor();
		eleitor.setCodEleitor(codigo);
		eleitorDao.excluir(eleitor);
	}
	
}