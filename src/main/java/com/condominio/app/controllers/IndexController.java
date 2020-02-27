package com.condominio.app.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.condominio.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.index.perfil}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.index.listar}")
	private String textoListar;
	
	
	//Por defecto si no se indica un requestmapping es get
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		
		model.addAttribute("titulo", "textoListar");
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Andres","Guzman", "dasds@gmail.com"),
				new Usuario("Andres","Guzman", "dasds@gmail.com"),
				new Usuario("Andres","Guzman", "dasds@gmail.com"),
				new Usuario("Tornado","Guzman", "dasds@gmail.com"));
		
		return usuarios;
	}
}
