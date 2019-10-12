package via.varejo.service.factory;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import via.varejo.model.Selic;
import via.varejo.service.strategy.ForwardSale;

/**
 * Created by Cid Soares on 12/10/2019.
 *
 * Factory pattern:
 * - creates objects without exposing the instantiation logic to the client.
 * - refers to the newly created object through a common interface 
 */

@Service
public class SaleFactoryService {
	
	private ForwardSale forwardSale;
	public SaleFactoryService() {
		forwardSale = new ForwardSale();
	}
	
	public BigDecimal getAcumuladoMensalSelic(){
		return forwardSale.getAcumuladoMensalSelic();
	}

}
