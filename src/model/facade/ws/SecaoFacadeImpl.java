package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import model.dao.SecaoDao;
import model.domain.Secao;
import model.facade.SecaoFacade;

@WebService(serviceName="ws/secao")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)

public class SecaoFacadeImpl implements SecaoFacade {
	
	@Inject
	private SecaoDao secaoDao;
	
	@WebMethod
	public List<Secao> getSecoes() {
		return secaoDao.getSecoes(new Secao());
	}
	
	@WebMethod(operationName="getSecoesCodigo")
	public List<Secao> getSecoes(Integer codigo) {
		Secao secao = new Secao();
		secao.setCodSecao(codigo);
		return secaoDao.getSecoes(secao);
	}
	
	@WebMethod
	public Secao salvar(@WebParam(name="secao") Secao secao){
		return secaoDao.salvar(secao);
	}
	
	@WebMethod
	public void atualizar(Secao secao){
		secaoDao.atualizar(secao);
	}
	
	@WebMethod
	public void deletarSecao(Integer codigo){
		Secao secao = new Secao();
		secao.setCodSecao(codigo);
		secaoDao.excluir(secao);
	}
	
}