package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="tbl_Binomio")
public class Binomio {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
	    private int id;


	    @Column(name = "NombreBinomio")
	    private String NombreBinomio;

	    @Column(name = "lista")
	    private String lista;

	    @Column(name = "cargo")
	    private String cargo;

		

		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}


		


		public String getNombreBinomio() {
			return NombreBinomio;
		}



		public void setNombreBinomio(String nombreBinomio) {
			NombreBinomio = nombreBinomio;
		}



		public String getLista() {
			return lista;
		}



		public void setLista(String lista) {
			this.lista = lista;
		}



		public String getCargo() {
			return cargo;
		}



		public void setCargo(String cargo) {
			this.cargo = cargo;
		}


		

		@Override
		public String toString() {
			return "Binomio [id=" + id + ", NombreBinomio=" + NombreBinomio + ", lista=" + lista + ", cargo=" + cargo
					+ "]";
		}
		

	}
	//