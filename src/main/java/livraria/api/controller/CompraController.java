package livraria.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import livraria.api.dto.DadosCompraDto;
import livraria.api.form.CompraForm;
import livraria.api.service.CompraService;
import livraria.api.validator.EstadoPaisValidator;
import livraria.api.validator.VerificaDocumentoCpfCnpjValidator;

@RestController
@RequestMapping("/Compras")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@Autowired
	private VerificaDocumentoCpfCnpjValidator cpfCnpjValidator;
	
	@Autowired
	private EstadoPaisValidator estadoPaisvalidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(cpfCnpjValidator, estadoPaisvalidator);
	}
	
	@GetMapping
	public ResponseEntity<List<DadosCompraDto>>  listar() {
		
		return ResponseEntity.ok(compraService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<DadosCompraDto> cadastrar(@RequestBody @Valid CompraForm compraForm, UriComponentsBuilder uriBuilder) {
		
		compraService.save(compraForm);
		
		DadosCompraDto dadosCompraDto = compraService.consultar(compraForm);
		URI uri = uriBuilder.path("/Compras/{id}").buildAndExpand(dadosCompraDto.getId()).toUri();
		return ResponseEntity.created(uri).body(dadosCompraDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosCompraDto> detalhar(@PathVariable Long id) {
		DadosCompraDto dadosCompraDto = compraService.consultar(id);
		
		if (dadosCompraDto != null) {
			return ResponseEntity.ok(dadosCompraDto);
		}

		return ResponseEntity.notFound().build();
	}
	
}
