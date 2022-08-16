/**
 * Clase entidad para mapear la tabla de usuario definida en la base de datos
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.Entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	@Basic
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@OneToOne(cascade = CascadeType.ALL)
	private CuentaEntity cuenta;
	@OneToOne(cascade = CascadeType.ALL)
	private DireccionEntity direccion;

	public UsuarioEntity() {

	}

	public UsuarioEntity(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
			CuentaEntity cuenta, DireccionEntity direccion) {
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.cuenta = cuenta;
		this.direccion = direccion;
	}

	public UsuarioEntity(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento,
			CuentaEntity cuenta, DireccionEntity direccion) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;
		this.cuenta = cuenta;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public CuentaEntity getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaEntity cuenta) {
		this.cuenta = cuenta;
	}

	public DireccionEntity getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMaterno, apellidoPaterno, cuenta, direccion, fechaNacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioEntity other = (UsuarioEntity) obj;
		return Objects.equals(apellidoMaterno, other.apellidoMaterno)
				&& Objects.equals(apellidoPaterno, other.apellidoPaterno) && Objects.equals(cuenta, other.cuenta)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", cuenta=" + cuenta
				+ ", direccion=" + direccion + "]";
	}

}
