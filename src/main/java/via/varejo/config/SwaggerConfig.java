package via.varejo.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.builders.PathSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket buildingApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			   .select()
			   .apis(RequestHandlerSelectors.basePackage("via.varejo"))
			   .paths(PathSelectors.any())
			   .build()
			   .apiInfo(metaInfo());
	}
	
	private ApiInfo metaInfo() {
		ApiInfo info = new ApiInfo("API REST GRUPO VIA VAREJO"
				                   , "Consultas relacionadas a vendas",
				                   "1.0",
				                   "https://github.com/viavarejo/backend-test", 
				                   "Cid Soares - cidssa@gmail.com", "", "");
		return info;
	}
}
