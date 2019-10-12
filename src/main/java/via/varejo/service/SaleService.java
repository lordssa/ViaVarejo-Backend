package via.varejo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import via.varejo.model.Selic;
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

}
