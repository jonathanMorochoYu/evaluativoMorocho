package services;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import business.GestionUsuarios;
import model.Usuario;
import services.Respuesta;

@Path("/usuarios")
public class UsuarioService {
	
	@Inject
	private GestionUsuarios gUsuarios;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> list(){
		return gUsuarios.getAll();
	}
	
	@POST
	public void create(Usuario usuario) {
		
	}
	
	@PUT
	public void update(Usuario usuario) {
			
	}

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("get/{id}")
	    public Response read(@PathParam("id") String id) {
	        if (id == null || !id.matches("\\d{10}")) {
	            return Response.status(Response.Status.BAD_REQUEST)
	                           .entity(new Respuesta(Respuesta.ERROR, "Cédula incorrecta"))
	                           .build();
	        }
	        try {
	            Usuario usuario = gUsuarios.getUsuario(id);
	            return Response.ok(usuario).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Usuario no encontrado")).build();
	        }
	    }
}
