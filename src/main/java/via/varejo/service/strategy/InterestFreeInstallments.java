package via.varejo.service.strategy;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import via.varejo.model.CondicaoPagamento;
import via.varejo.model.Parcela;
import via.varejo.model.Selic;

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
