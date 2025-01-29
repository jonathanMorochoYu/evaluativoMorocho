package model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import model.Binomio;

@Entity
@Table (name="tbl_Usuarios")
public class Usuario {
	

	@Id
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;	
	
	@Column(name = "telefono")
	private String telefono;	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cedula_cliente")
    private List<Binomio> binomios;
	


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Binomio> getConsumos() {
		return binomios;
	}

	public void setConsumos(List<Binomio> binomios) {
		this.binomios = binomios;
	}


	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", binomios=" + binomios + "]";
	}
	
	public void addBinomio(Binomio binomio) {
		if(this.binomios == null) {
			this.binomios = new ArrayList<>();
		}
		this.binomios.add(binomio);
	}
	

	
}

