package br.com.pgam.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pgam.dao.UsuarioDAO;
import br.com.pgam.model.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("formularioLogin")
    public String loginForm() {
        return "formularioLogin";
    }
	
	@RequestMapping("home")
    public String home() {
        return "home";
    }
	
	@RequestMapping("efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session) {
        
		if(new UsuarioDAO().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "home";
        }
        return "redirect:formularioLogin";
    }
	
	@RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:formularioLogin";
    }
}
