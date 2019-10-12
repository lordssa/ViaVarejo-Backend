package via.varejo.service.factory;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import via.varejo.model.CondicaoPagamento;
import via.varejo.model.Parcela;
import via.varejo.service.strategy.ForwardSale;
import via.varejo.service.strategy.InterestFreeInstallments;
import via.varejo.service.strategy.InterestInstallments;

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
	private InterestFreeInstallments interestFreeInstallments;
	private InterestInstallments interestInstallments;
	
	public SaleFactoryService() {
		forwardSale = new ForwardSale();
		interestFreeInstallments = new InterestFreeInstallments();
		interestInstallments = new InterestInstallments();
	}
	
	public BigDecimal getAcumuladoMensalSelic(){
		return forwardSale.getAcumuladoMensalSelic();
	}
	
	public List<Parcela> getPortion(double valor, CondicaoPagamento condicaoPagamento){
		if(condicaoPagamento.getQtdeParcelas() <= 6) {
			return interestFreeInstallments.getPortion(valor, condicaoPagamento, 0);
		}else {
			return interestInstallments.getPortion(valor, condicaoPagamento, getAcumuladoMensalSelic().doubleValue());
		}
	}

}
