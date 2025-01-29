package business;

import java.util.List;

import dao.UsuarioDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import dao.UsuarioDao;
import model.Usuario;

@Stateless
public class GestionUsuarios {
	
	@Inject UsuarioDao usuarioDAO;
	
	public Usuario getUsuario(String cedula) throws Exception {
		if(cedula.length() != 10) {
			throw new Exception("Cedula incorrecta");
		}
		Usuario usuario = usuarioDAO.read(cedula);
		if(usuario == null)
			throw new Exception("Usuario no existe");
		return usuario;
	}
	
	
	public List<Usuario> getAll(){
		return usuarioDAO.getUsuarios();
	}
}

