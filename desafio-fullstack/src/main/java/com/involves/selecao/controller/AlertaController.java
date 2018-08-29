package com.involves.selecao.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.involves.selecao.models.Alerta;
import com.involves.selecao.service.PesquisaAlertasService;
import com.involves.selecao.service.ProcessaAlertas;

@RestController
@RequestMapping("/api/v1/alertas")
public class AlertaController {

	@Autowired
	private PesquisaAlertasService buscaAlertasService;
	
	@Autowired
	private ProcessaAlertas processador;
	
	@GetMapping
    public List<Alerta> alertas() {
		return buscaAlertasService.buscarTodos();
    }
	
	@GetMapping("/processar")
    public void processar() {
		try {
			processador.processa();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
