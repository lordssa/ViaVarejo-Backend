package via.varejo.service.strategy;

import java.util.List;

import via.varejo.model.CondicaoPagamento;
import via.varejo.model.Parcela;

/**
 * 
 * @author Cid Soares
 *
 * Class responsible for calculating interest installments
 */
public class InterestInstallments extends AbstractSelic implements SaleStrategy {
	
				
	public List<Parcela> getPortion(double valor, CondicaoPagamento condicaoPagamento, double installmentsTax){
	
		double amount = valor-condicaoPagamento.getValorEntrada();
		double installments = amount * (installmentsTax/100) * condicaoPagamento.getQtdeParcelas();
	    double portionValue = (amount+installments)/condicaoPagamento.getQtdeParcelas();
	    
	    return getListParcelas(portionValue, condicaoPagamento.getQtdeParcelas(), installmentsTax);
	            
	}	
	

}
