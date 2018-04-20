package br.com.pgam.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pgam.dao.UsuarioDAO;
import br.com.pgam.model.Usuario;

@Controller
public class UsuarioController {

	private final UsuarioDAO dao;

	@Autowired
    public UsuarioController(UsuarioDAO dao) {
        this.dao = dao;  
    }

	@RequestMapping("formularioUsuario")
	public String form() {
		return "usuario/formularioUsuario";
	}

	@RequestMapping("adicionaUsuario")
	public String adiciona(Usuario usuario) {

		dao.adiciona(usuario);
		return "usuarioAdicionado";
	}

	@RequestMapping("listaUsuario")
	public String lista(Model model) {
		model.addAttribute("usuarios", dao.getLista());
		return "usuario/listaUsuario";
	}

	@RequestMapping("mostraUsuario")
	public String mostra(long id, Model model) {
		model.addAttribute("usuario", dao.buscaUsuario(id));
		return "usuario/mostraUsuario";
	}

	@RequestMapping("alteraUsuario")
	public String altera(Usuario usuario) {
		dao.altera(usuario);
		return "redirect:listaUsuario";
	}

	@RequestMapping("removeUsuario")
	public String remove(Usuario usuario) {
		dao.remove(usuario);
		return "redirect:listaUsuario";
	}
}
