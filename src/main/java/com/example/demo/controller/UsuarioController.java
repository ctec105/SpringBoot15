package com.example.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Usuario;
import com.example.demo.utils.RenderizadorPaginas;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioDao usuarioDAO;
	
	@GetMapping("/")
	public String form(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "form";
	}
	
	@PostMapping("/")
	public String guardar(@RequestParam(name="file", required = false) MultipartFile foto , Usuario usuario,
			RedirectAttributes flash) {
		if(!foto.isEmpty()) {
			String rutaRelativa = "C://Temp/uploads";
			String nombreUnico = UUID.randomUUID().toString()+"-"+foto.getOriginalFilename();
			
			try {
				byte[] bytes = foto.getBytes();
				Path rutaAbsoluta = Paths.get(rutaRelativa + "//" + nombreUnico);
				Files.write(rutaAbsoluta, bytes);
				usuario.setFoto(nombreUnico);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			usuarioDAO.save(usuario);
			flash.addFlashAttribute("success", "Foto subida!");
			System.out.println("Nombre único de la foto: " + nombreUnico);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page", defaultValue = "0")int page, Model model) {
		Pageable userPageable = PageRequest.of(page, 3);
		Page<Usuario> usuario = usuarioDAO.findAll(userPageable);
		RenderizadorPaginas<Usuario> renderizadorPaginas = new RenderizadorPaginas<>("/listar", usuario);
		
		
		model.addAttribute("page", renderizadorPaginas);
		model.addAttribute("usuarios", usuario);
		//model.addAttribute("usuarios", usuarioDAO.findAll());
		return "listar";
		
	}
	
}
