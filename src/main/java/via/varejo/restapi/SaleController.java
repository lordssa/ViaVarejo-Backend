package via.varejo.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import via.varejo.exception.NonComplianceException;
import via.varejo.model.Venda;
import via.varejo.service.SaleService;

@RestController
@RequestMapping(value = "/api/vendas")
@Api(value = "API Via Varejo - Vendas")
@CrossOrigin(origins = "*")
public class SaleController {

	@Autowired
	SaleService _saleService;

	@GetMapping("/listarSelic")
	@ApiOperation(value = "Retorna a taxa Selic no ultimos 30 dias")
	public ResponseEntity ValorMensalSelic() {
		try {
			return new ResponseEntity(_saleService.getAcumuladoMensalSelic(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
		
	@PostMapping("/parcelas")
	@ApiOperation(value = "Retorna a lista de parcelas")
    public ResponseEntity resgataParcelas(Venda venda) {
		try {			
			return new ResponseEntity(_saleService.getParcelas(venda), HttpStatus.OK);
		}
		catch (Exception e) {
			if(e.getClass().equals(NonComplianceException.class)) {
				return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
    }
}
