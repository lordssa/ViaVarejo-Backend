package via.varejo.service.strategy;

import java.util.List;

import via.varejo.model.CondicaoPagamento;
import via.varejo.model.Parcela;

public interface SaleStrategy {
	List<Parcela> getPortion(double valor, CondicaoPagamento condicaoPagamento, double installmentsTax);
}
