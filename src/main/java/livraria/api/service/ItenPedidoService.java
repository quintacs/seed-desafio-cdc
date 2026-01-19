package livraria.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import livraria.api.dto.DadosItenPedidoDto;
import livraria.api.form.ItenPedidoForm;
import livraria.api.modelo.ItenPedido;
import livraria.api.repository.ItenPedidoRepository;

@Service
public class ItenPedidoService {

	@Autowired
	private ItenPedidoRepository itenPedidoRepository;
	
	public void save(@Valid ItenPedidoForm itenPedidoForm) {
		
		itenPedidoRepository.save(new ItenPedido(itenPedidoForm));
	}
	
	public List<DadosItenPedidoDto> findAll() {
		
		List<DadosItenPedidoDto> listDadosItenPedido = new ArrayList<DadosItenPedidoDto>();
		
		itenPedidoRepository.findAll().forEach(itenPedido -> listDadosItenPedido.add(new DadosItenPedidoDto(itenPedido)));
		
		return listDadosItenPedido;
	}

	public DadosItenPedidoDto consultar(ItenPedidoForm itenPedidoForm) throws IllegalArgumentException {
		
		DadosItenPedidoDto itenPedidoDto = itenPedidoRepository.findByIdLivro(itenPedidoForm.getIdLivro());
		
		return itenPedidoDto;
	}
	
	public DadosItenPedidoDto consultar(Long id) {
		
		Optional<ItenPedido> optional = itenPedidoRepository.findById(id);
		
		if(optional.isPresent()) {
			ItenPedido itenPedido = optional.get();
			return new DadosItenPedidoDto(itenPedido);
		}
		return null;
	}
}
