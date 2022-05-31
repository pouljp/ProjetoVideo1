package br.com.muvi.conteiner.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.muvi.conteiner.demo.model.Conteiner;
import br.com.muvi.conteiner.demo.repository.ClienteRepository;
import br.com.muvi.conteiner.demo.repository.ConteinerRepository;


@Controller
@RequestMapping("conteiner")
public class ConteinerController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ConteinerRepository conteinerRepository;

	@GetMapping("formulario")
	public String formulario(@RequestParam("idCliente")Long idCliente 
			,@ModelAttribute("novoConteiner")Conteiner novoConteiner) {
		novoConteiner.setCliente(clienteRepository.findById(idCliente).get());
		return "conteiner/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid Conteiner novoConteiner, BindingResult result) {
		if (result.hasErrors()) {
			return "conteiner/formulario";
		}
		conteinerRepository.save(novoConteiner);
		return "redirect:/home";
	}

}
