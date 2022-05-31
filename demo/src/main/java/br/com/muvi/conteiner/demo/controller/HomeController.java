package br.com.muvi.conteiner.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import br.com.muvi.conteiner.demo.model.Cliente;
import br.com.muvi.conteiner.demo.repository.ClienteRepository;



@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ClienteRepository  clienteRepository;
	
	@GetMapping
	public String cadastro (Model model) {
		List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes);
		return "home";
	}
	

}

