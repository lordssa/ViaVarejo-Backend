package via.varejo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import via.varejo.model.Parcela;
import via.varejo.model.Venda;
import via.varejo.service.factory.SaleFactoryService;

@Service
public class SaleService {
	
	private SaleFactoryService saleFactoryService;
	
	@Autowired
	public SaleService(SaleFactoryService saleFactoryService) {
		this.saleFactoryService = saleFactoryService;
	}
	
	public BigDecimal getAcumuladoMensalSelic(){
		return saleFactoryService.getAcumuladoMensalSelic();
	}
	
	public List<Parcela> getParcelas(Venda venda){		 
		if(venda != null && venda.getProduto() != null && venda.getCondicaoPagamento() != null) {
			return saleFactoryService.getPortion(venda.getProduto().getValor(), venda.getCondicaoPagamento());
		}else {
			return null;
		}
	}

}
