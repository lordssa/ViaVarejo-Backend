package via.varejo.service.strategy;

import java.util.List;

import via.varejo.model.Selic;

/**
 * Created by Cid Soares on 12/10/2019.
 *
 * Strategy pattern:
 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 */
public interface BCBStrategy {	
	List<Selic> getSelic(String dataInicial, String dataFinal);
}
