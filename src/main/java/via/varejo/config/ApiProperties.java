package via.varejo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "api")
public class ApiProperties {
	
	private String selicUrl;

	public String getSelicUrl() {
		return selicUrl;
	}

	public void setSelicUrl(String selicUrl) {
		this.selicUrl = selicUrl;
	}
}
