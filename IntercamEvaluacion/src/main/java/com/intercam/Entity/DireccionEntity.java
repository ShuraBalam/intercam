/**
 * Clase entidad para mapear la tabla de Direccion definida en la base de datos
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DireccionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "varchar(6)")
	private String codigoPostal;
	@Column(columnDefinition = "varchar(60)")
	private String estado;

	
	public DireccionEntity() {
		
	}

	public DireccionEntity(String codigoPostal, String estado) {

		this.codigoPostal = codigoPostal;
		this.estado = estado;
	}
	
	

	public DireccionEntity(int id, String codigoPostal, String estado) {
		this.id = id;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoPostal, estado, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionEntity other = (DireccionEntity) obj;
		return Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(estado, other.estado)
				&& id == other.id;
	}

	@Override
	public String toString() {
		return "DireccionEntity [id=" + id + ", codigoPostal=" + codigoPostal + ", estado=" + estado + "]";
	}

}
