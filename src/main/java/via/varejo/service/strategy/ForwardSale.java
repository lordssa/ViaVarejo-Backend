package via.varejo.service.strategy;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import via.varejo.model.Selic;

public class ForwardSale extends AbstractSelic {
	
				
	public BigDecimal getAcumuladoMensalSelic() {
		Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -29);
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  
        String dateStart=formatter1.format(cal.getTime());
        String dateEnd=formatter1.format(today);
        
        List<Selic> listSelic = getSelic(dateStart, dateEnd);
        BigDecimal sum = listSelic.stream().map(Selic::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum;
        
	}	
	

}
