package via.varejo.service.strategy;

import java.util.List;
import via.varejo.model.CondicaoPagamento;
import via.varejo.model.Parcela;

/**
 * 
 * @author Cid Soares
 *
 * Class responsible for calculating interest-free installments
 */
public class InterestFreeInstallments extends AbstractSelic implements SaleStrategy {
	
				
	public List<Parcela> getPortion(double valor, CondicaoPagamento condicaoPagamento, double installmentsTax){
	
		double amount = valor-condicaoPagamento.getValorEntrada();
	    double portionValue = amount/condicaoPagamento.getQtdeParcelas();
	    
	    return getListParcelas(portionValue, condicaoPagamento.getQtdeParcelas(), installmentsTax);
              
	}	


}
