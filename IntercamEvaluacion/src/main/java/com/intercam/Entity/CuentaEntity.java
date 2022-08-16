/**
 * Clase entidad para mapear la tabla de Cuenta definida en la base de datos
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.Entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CuentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int numeroCuenta;

	private float ingreso;

	
	public CuentaEntity() {
		
	}

	public CuentaEntity(int numeroCuenta, float ingreso) {

		this.numeroCuenta = numeroCuenta;
		this.ingreso = ingreso;
	}
	
	public CuentaEntity(int id, int numeroCuenta, float ingreso) {
		this.id = id;
		this.numeroCuenta = numeroCuenta;
		this.ingreso = ingreso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public float getIngreso() {
		return ingreso;
	}

	public void setIngreso(float ingreso) {
		this.ingreso = ingreso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ingreso, numeroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaEntity other = (CuentaEntity) obj;
		return id == other.id && Float.floatToIntBits(ingreso) == Float.floatToIntBits(other.ingreso)
				&& numeroCuenta == other.numeroCuenta;
	}

	@Override
	public String toString() {
		return "CuentaEntity [id=" + id + ", numeroCuenta=" + numeroCuenta + ", ingreso=" + ingreso + "]";
	}

}
