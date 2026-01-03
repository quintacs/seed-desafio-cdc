package livraria.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import livraria.api.record.DadosAutor;
import livraria.api.service.AutorService;

@RestController
@RequestMapping("/Autores")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@GetMapping
	public String olaMundo() {
		return "Ola Mundo Autores Controller ";
	}
	
	@PostMapping
	public void cadastrar(@RequestBody DadosAutor dadosAutor) {
		
		autorService.save(dadosAutor);
		
		System.out.println(dadosAutor);
	}
	
}
