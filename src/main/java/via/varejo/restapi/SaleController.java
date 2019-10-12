package via.varejo.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import via.varejo.config.ApiProperties;
import via.varejo.service.SaleService;

@RestController
@RequestMapping(value = "/api/vendas")
@EnableConfigurationProperties(ApiProperties.class)
@Api(value = "API Via Varejo - Vendas")
@CrossOrigin(origins = "*")
public class SaleController {

	@Autowired
	SaleService _saleService;

	@GetMapping("/listarSelic")
	@ApiOperation(value = "Retorna a lista taxa diária Selic")
	public ResponseEntity ListarImoveisZap() {
		try {
			return new ResponseEntity(_saleService.getAcumuladoMensalSelic(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
