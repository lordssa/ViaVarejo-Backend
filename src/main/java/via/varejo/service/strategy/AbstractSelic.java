package via.varejo.service.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import via.varejo.model.Parcela;
import via.varejo.model.Selic;

public abstract class AbstractSelic implements BCBStrategy {

	final private String SELIC_URL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json";
	
	public List<Selic> getSelic(String dataInicial, String dataFinal) {
		RestTemplate restTemplate = new RestTemplate();		
		ResponseEntity<Selic[]> responseEntity = restTemplate.getForEntity(SELIC_URL+"&dataInicial="+dataInicial+"&dataFinal="+dataFinal, Selic[].class);
		Selic[] objects = responseEntity.getBody();
		List<Selic> list = new ArrayList<Selic>(Arrays.asList(objects));
		return list;		
	}
	
	public List<Parcela> getListParcelas(double value, int quantidadeParcelas, double installmentsTax){
		List<Parcela> portions = new ArrayList<Parcela>();
	    Parcela objParcela = null; 
	    for(int i=1 ; i<= quantidadeParcelas ; i++) {
	       	objParcela = new Parcela();
	       	objParcela.setNumeroParcela(i);
	       	objParcela.setValor(value);
	       	objParcela.setTaxaJurosAoMes(installmentsTax);
	       	
	       	portions.add(objParcela);
	    }
	    return portions;
	}
}
