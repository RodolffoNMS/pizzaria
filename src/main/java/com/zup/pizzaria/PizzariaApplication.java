//Classe principal
package com.zup.pizzaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //notação que define a porta de entrada do Springboot:
/*
* Essa notation @SpringBootApplication é a "junção" de outras três notation:
* @Configuration-------------> Declara que essa classe pode ter métodos que definem "beans"
* @EnableAutoConfiguration---> Ativa a AutoConf. do Springboot
* @ComponentScan------------->Permita que o Spring scaneie o pacote do projeto, em busca dos componentes, service...
*
*/
public class PizzariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
	}

}
