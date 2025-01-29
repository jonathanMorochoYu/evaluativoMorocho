package dao;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.Usuario;

@Stateless
public class UsuarioDao {
@PersistenceContext
private EntityManager em;

public void agregarUsuario(Usuario usuario) {
	em.persist(usuario);
}

public void actualizarUsuario(Usuario usuario) {
	em.merge(usuario);
}

public void eliminarUsuario(String cedula) {
	Usuario usuario= em.find(Usuario.class, cedula);
	em.remove(usuario);
}

public Usuario read(String cedula) {
	Usuario usuario = em.find(Usuario.class, cedula);
	return usuario;
}        

public List<Usuario> getUsuarios() {
	String jpql = "SELECT c FROM Usuario c";
	Query query = em.createQuery(jpql, Usuario.class);
	
	List<Usuario> list = query.getResultList();
	
	return list;
}
}
