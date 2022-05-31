package br.com.muvi.conteiner.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.muvi.conteiner.demo.model.Cliente;
import br.com.muvi.conteiner.demo.repository.ClienteRepository;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@Autowired // Extensão da Classe 
	private ClienteRepository clienteRepository;

	@GetMapping("formulario") //mapeando 
	public String formulario(Cliente novoCliente) {
		return "cliente/formulario";

	}

	@PostMapping("novo")
	public String novo(@Valid Cliente novoCliente, BindingResult result) {
		if (result.hasErrors()) {
			return "cliente/formulario";
		}
		clienteRepository.save(novoCliente);
		return "redirect:/home";
	}

}
