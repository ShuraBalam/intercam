/**
 * Clase DTO para la informacion correspondiente a la entidad Cuenta
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.DTO;

import java.util.Objects;

public class CuentaDTO {

	private int idCuenta;

	private String numeroCuenta;

	private float ingreso;

	public CuentaDTO() {

	}

	public CuentaDTO(int idCuenta, String numeroCuenta, float ingreso) {
		this.idCuenta = idCuenta;
		this.numeroCuenta = numeroCuenta;
		this.ingreso = ingreso;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
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
		return Objects.hash(idCuenta, ingreso, numeroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaDTO other = (CuentaDTO) obj;
		return idCuenta == other.idCuenta && Float.floatToIntBits(ingreso) == Float.floatToIntBits(other.ingreso)
				&& Objects.equals(numeroCuenta, other.numeroCuenta);
	}

	@Override
	public String toString() {
		return "CuentaDTO [idCuenta=" + idCuenta + ", numeroCuenta=" + numeroCuenta + ", ingreso=" + ingreso + "]";
	}
}
