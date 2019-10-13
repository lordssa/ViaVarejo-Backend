package via.varejo.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import via.varejo.model.CondicaoPagamento;
import via.varejo.model.Parcela;
import via.varejo.model.Produto;
import via.varejo.model.Venda;
import via.varejo.service.SaleService;
import via.varejo.service.factory.SaleFactoryService;
import via.varejo.service.strategy.ForwardSale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ViaVarejoProjectApplicationTests {

	private SaleService _saleService;
	
	@Before
	public void contextLoads() {		
		_saleService = new SaleService(new SaleFactoryService());
	}
	
	@Test
	public void isBCBServiceActive() {
		ForwardSale forwardSale = new ForwardSale();
		Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -3);
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
        String dateStart=formatter1.format(cal.getTime());
        String dateEnd=formatter1.format(today);
		assertTrue(forwardSale.getSelic(dateStart, dateEnd).size() > 0);
	}
	
	@Test	
	public void parcelas_IsOK() {
		Venda venda = new Venda();
		CondicaoPagamento condicao= new CondicaoPagamento();
		condicao.setValorEntrada(0);
		condicao.setQtdeParcelas(6);
		Produto produto = new Produto();
		produto.setValor(120);
		venda.setProduto(produto);
		venda.setCondicaoPagamento(condicao);		
		List<Parcela> parcelasList = _saleService.getParcelas(venda);
		assertThat(parcelasList, is(notNullValue()));
		assertThat(parcelasList.size(), is(6));
	}
	
	@Test
	public void parcelas_Fail() {
		Venda venda = new Venda();
		CondicaoPagamento condicao= new CondicaoPagamento();
		condicao.setValorEntrada(10);
		condicao.setQtdeParcelas(-1);
		Produto produto = new Produto();
		produto.setValor(110);
		venda.setProduto(produto);
		venda.setCondicaoPagamento(condicao);		
		assertThat(_saleService.getParcelas(venda), is(nullValue()));		
	}
	
	@Test
	public void returns_Right_Values_Parcelas() {
		Venda venda = new Venda();
		CondicaoPagamento condicao= new CondicaoPagamento();
		condicao.setValorEntrada(20);
		condicao.setQtdeParcelas(5);
		Produto produto = new Produto();
		produto.setValor(120);
		venda.setProduto(produto);
		venda.setCondicaoPagamento(condicao);		
		assertThat(_saleService.getParcelas(venda).get(0).getValor(), is(20d));		
	}
	
	@After
	public void ReleaseAll() {
		_saleService = null;
	}	

}
