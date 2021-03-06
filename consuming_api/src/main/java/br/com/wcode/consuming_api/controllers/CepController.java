package br.com.wcode.consuming_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wcode.consuming_api.models.Endereco;
import br.com.wcode.consuming_api.services.CepService;

@RestController
@RequestMapping
public class CepController {

	@Autowired
	private CepService cepService;

	@GetMapping("/{cep}")
	public ResponseEntity<Endereco> index(@PathVariable("cep") String cep, Model model) {
		Endereco endereco = this.cepService.buscaEnderecoPorCep(cep);
		return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
	}

}
