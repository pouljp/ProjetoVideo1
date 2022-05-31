package br.com.muvi.conteiner.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.muvi.conteiner.demo.model.Movimentacao;
import br.com.muvi.conteiner.demo.repository.ConteinerRepository;
import br.com.muvi.conteiner.demo.repository.MovimentacaoRepository;


@Controller
@RequestMapping("movimentacao")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	@Autowired
	private  ConteinerRepository conteinerRepository  ;
	
	@GetMapping("formulario")
	public String formulario (@RequestParam("idConteiner")Long idConteiner 
			,@ModelAttribute("movimentacaoNova")Movimentacao movimentacaoNova) {
		movimentacaoNova.setConteiner(conteinerRepository.findById(idConteiner).get());
		return "movimentacao/formulario";
	}
	
	@PostMapping("novo")
	public String novo(Movimentacao movimentacaoNova) {
		movimentacaoRepository.save(movimentacaoNova);
		return "redirect:/home";
  	}
	
//	@GetMapping("filtro")
//	public String filtro(@RequestParam("movimentacao") String filtro) {
//		List<Movimentacao> resultList  = movimentacaoRepository.findByMovimento(filtro);
//		resultList.stream().forEach(t -> System.out.println(t.getMovimento()));
//		
//		return "redirect:/home";
//  	}
	
}
