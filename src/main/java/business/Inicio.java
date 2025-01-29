package business;

import java.time.LocalDate;
import java.util.List;

import dao.UsuarioDao;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import dao.UsuarioDao;
import model.Binomio;
import model.Usuario;

@Singleton
@Startup
public class Inicio {
	
	@Inject
	private UsuarioDao usuarioDAO;
	
	@PostConstruct
	public void init() {
		
		// Usuarios
		 Usuario usuario1 = new Usuario();
	        usuario1.setCedula("1254785414");
	        usuario1.setNombre("Carlos Mendex");
	        usuario1.setDireccion("RemigioCrespo");
	        usuario1.setTelefono("1234598741");
	        
	        
	      Usuario usuario2 = new Usuario();
	        usuario2.setCedula("4785421544");
	        usuario2.setNombre("Juan Perez");
	        usuario2.setDireccion("Calle Larga");
	        usuario2.setTelefono("1234589741");
	        
	        
	        // Binomio
	        Binomio bino1 = new Binomio();
	        bino1.setNombreBinomio("Partido Socialista");
	        bino1.setLista("35");
	        bino1.setCargo("Asambleista");
	        usuario1.addBinomio(bino1);
	        
	        Binomio bino2 = new Binomio();
	        bino2.setNombreBinomio("Partido Cristiano");
	        bino2.setLista("7");
	        bino2.setCargo("Vicepresidente");
	        usuario2.addBinomio(bino2);
	        
	        //Agregar usuarios
	        usuarioDAO.agregarUsuario(usuario1);
	        usuarioDAO.agregarUsuario(usuario2);
	        
	        System.out.println("----------------Usuarios y sus BINOMIOS----------------------");
	        List<Usuario> listado = usuarioDAO.getUsuarios();
	        
	        for (Usuario usr : listado) {
	            System.out.println(usr.toString());
	        }
	}

}

