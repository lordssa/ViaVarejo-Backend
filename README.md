# ViaVarejo Backend-Test

API Rest Grupo Via Varejo

Endpoint to simulate a product sale.

This repository is a simple spring boot application, that demonstrates a few design patterns:

* Factory
* Strategy


### Prerequisites

* [Java 8](https://www.java.com/pt_BR/download/) - Development Kit 
* [Spring Tools 4 for Eclipse](https://spring.io/tools) - IDE for Development
* [Git](https://git-scm.com/downloads) - Open source distributed version control system

### Installing

Checkout the code from Github repository inside Eclipse Workspace 
```
$ git clone https://github.com/lordssa/ViaVarejo-Backend.git
```

After acquire the project, open the Eclipse and select the option "import existing Maven projects" in "File > Import"

## Running the project

Expand the folders src/main/java/via/varejo/ and execute ViaVarejoProjectApplication.java. After server up, the api will be available in http://localhost at 8080

### Accessing documentation and contract

With server up, access http://localhost:8080/swagger-ui.html. On the sale-controller contains a list of API services, parameters and output sample. 

### Trying out

Through Swagger.
```
*Example*
On the section sale-controller, select method POST "/api/vendas/parcelas" and click "try it out" button, fill the required parameters, click in execute button and that's it!
```

## Testing

Execute JUnit Test ViaVarejoProjectApplicationTests.java on test project.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/) - Testing Framework
* [Swagger](https://swagger.io/) - Documentation and User Interface for the REST Service

## Authors

* **Cid Soares** - *Initial work* 


