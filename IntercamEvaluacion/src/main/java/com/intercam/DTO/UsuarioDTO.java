/**
 * Clase DTO para la informacion correspondiente a la entidad Usuario
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.DTO;

import java.util.Objects;

public class UsuarioDTO {

	private int idUsuario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	private String fechaNacimiento;

	private CuentaDTO cuenta;

	private DireccionDTO direccion;

	public UsuarioDTO() {

	}

	public UsuarioDTO(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno,
			String fechaNacimiento) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	public DireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, cuenta, direccion, fechaNacimiento, idUsuario, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(cuenta, other.cuenta)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& idUsuario == other.idUsuario && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", cuenta=" + cuenta
				+ ", direccion=" + direccion + "]";
	}

}
