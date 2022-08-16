/**
 * Clase DTO para la informacion correspondiente a la entidad Direccion
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.DTO;

import java.util.Objects;

public class DireccionDTO {

	private int idDireccion;
	private String codigoPostal;

	private String estado;

	public DireccionDTO() {

	}

	public DireccionDTO(int idDireccion, String codigoPostal, String estado) {
		this.idDireccion = idDireccion;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
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
		return Objects.hash(codigoPostal, estado, idDireccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionDTO other = (DireccionDTO) obj;
		return Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(estado, other.estado)
				&& idDireccion == other.idDireccion;
	}

	@Override
	public String toString() {
		return "DireccionDTO [idDireccion=" + idDireccion + ", codigoPostal=" + codigoPostal + ", estado=" + estado
				+ "]";
	}

}
