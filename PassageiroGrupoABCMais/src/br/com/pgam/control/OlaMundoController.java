package br.com.pgam.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/index")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "index";
	}

}
