/**
 * Clase para implementar las funciones de la interfaz de servicio
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercam.DTO.CuentaDTO;
import com.intercam.DTO.DireccionDTO;
import com.intercam.DTO.UsuarioDTO;
import com.intercam.Entity.CuentaEntity;
import com.intercam.Entity.DireccionEntity;
import com.intercam.Entity.UsuarioEntity;
import com.intercam.IRepository.IUsuarioRepository;
import com.intercam.IService.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	/**
	 * Funcion para insertar un registro en base de datos
	 */
	@Override
	public boolean InsertarUsuario(UsuarioDTO usuario) throws Exception {

		if (usuario.getCuenta().getIngreso() < 0) {
			throw new Exception("Los ingresos deben ser mayor a cero");
		}

		if (isnumeric(usuario.getCuenta().getNumeroCuenta()) && usuario.getCuenta().getNumeroCuenta().length() > 10) {
			throw new Exception("El numero de cuenta debe ser mayor a 10 digitos y mayor a cero ");
		}

		if (usuario.getDireccion().getCodigoPostal().length() < 6) {
			throw new Exception("El codigo postal no cumple con la longotud de 6 caracteres");
		}

		UsuarioEntity usuarioSave = usuarioRepository.save(new UsuarioEntity(usuario.getNombre(),
				usuario.getApellidoPaterno(), usuario.getApellidoMaterno(), generaFecha(usuario.getFechaNacimiento()),
				new CuentaEntity(Integer.valueOf(usuario.getCuenta().getNumeroCuenta()),
						usuario.getCuenta().getIngreso()),
				new DireccionEntity(usuario.getDireccion().getCodigoPostal(), usuario.getDireccion().getEstado())));

		if (usuarioSave != null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Funcion para actualizar un registro en base de datos
	 */
	@Override
	public boolean ActualizarUsuario(UsuarioDTO usuario) throws Exception {

		UsuarioEntity usuarioSave;
		try {
			if (usuario.getCuenta().getIngreso() < 0) {
				throw new Exception("Los ingresos deben ser mayor a cero");
			}

			if (isnumeric(usuario.getCuenta().getNumeroCuenta())
					&& usuario.getCuenta().getNumeroCuenta().length() > 10) {
				throw new Exception("El numero de cuenta debe ser mayor a 10 digitos y mayor a cero ");
			}

			if (usuario.getDireccion().getCodigoPostal().length() < 6) {
				throw new Exception("El codigo postal no cumple con la longotud de 6 caracteres");
			}

			usuarioSave = usuarioRepository.save(new UsuarioEntity(usuario.getIdUsuario(), usuario.getNombre(),
					usuario.getApellidoPaterno(), usuario.getApellidoMaterno(),
					generaFecha(usuario.getFechaNacimiento()),
					new CuentaEntity(usuario.getCuenta().getIdCuenta(),
							Integer.valueOf(usuario.getCuenta().getNumeroCuenta()), usuario.getCuenta().getIngreso()),
					new DireccionEntity(usuario.getDireccion().getIdDireccion(),
							usuario.getDireccion().getCodigoPostal(), usuario.getDireccion().getEstado())));

			if (usuarioSave != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Funcion para obtener todos los registros en base de datos
	 */
	@Override
	public List<UsuarioDTO> BuscarTodoUsuario() throws Exception {

		try {
			List<UsuarioDTO> listaDTO = new ArrayList<>();

			for (UsuarioEntity entity : usuarioRepository.findAll()) {
				listaDTO.add(ParseaUsuario(entity));
			}
			return listaDTO;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Funcion para obtener un usuario por su ID
	 */

	@Override
	public UsuarioDTO BuscarUsuario(int idUsuario) throws Exception {

		Optional<UsuarioEntity> entity = usuarioRepository.findById(idUsuario);

		return ParseaUsuario(entity.get());
	}

	/**
	 * Funcion para eliminar un usuario en base de datos por su ID
	 */
	@Override
	public boolean eliminarUsuario(UsuarioDTO usuario) throws Exception {
		try {
			usuarioRepository.deleteById(usuario.getIdUsuario());
			;

			return true;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Funcion para validar la longitud del numero de cuenta
	 * 
	 * @param numero
	 * @return
	 */
	private boolean isnumeric(String numero) {
		try {
			if (Integer.parseInt(numero) > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * funcion para validar el formato de la fecha en formato dd/mm/yyyy
	 * 
	 * @param strFecha
	 * @return verdadero en caso de ser el formato correcto, falso en caso contraro
	 */

	private Date generaFecha(String strFecha) throws Exception {
		try {
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
			sdfrmt.setLenient(false);
			Date fechaFormato = sdfrmt.parse(strFecha);
			return fechaFormato;
		} catch (ParseException e) {

			throw new Exception("Fecha incorrecta");
		}

	}

	/**
	 * Funcion para parsear la fecha que se obtiene de la base de datos al formato
	 * dia mes anio
	 * 
	 * @param fecha valor de DATE que se obtiene de la base de datos
	 * @return cadena con la fecha en formato dia mes añio, para responder la
	 *         peticion
	 * @throws Exception mensaje de error
	 */
	private String parseFecha(Date fecha) throws Exception {
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		sdfrmt.setLenient(false);
		String fechaFormato = sdfrmt.format(fecha);
		return fechaFormato;
	}

	/**
	 * Funcion para responder nuemero de cuenta a 10 caracteres
	 * 
	 * @param numeroCuenta
	 * @return cadena con las 10 posiciones del numero de cuenta
	 */
	private String FormatoNumeroCuenta(int numeroCuenta) {
		String numero = numeroCuenta + "";
		String complemento = "";

		int tamanio = 10 - numero.length();

		for (int i = 1; i <= tamanio; i++) {
			complemento = complemento + "0";
		}

		return complemento + numero;
	}

	/**
	 * Funcion para parsear un objeto entity a un objeto DTO y responder la
	 * informacion al WS
	 * 
	 * @param entity objeto con la informacion de la base de datos
	 * @return objeto DTO con la informacion del Entity
	 * @throws Exception mensaje de error
	 */
	private UsuarioDTO ParseaUsuario(UsuarioEntity entity) throws Exception

	{
		UsuarioDTO usuario;
		try {
			usuario = new UsuarioDTO(entity.getId(), entity.getNombre(), entity.getApellidoPaterno(),
					entity.getApellidoMaterno(), parseFecha(entity.getFechaNacimiento()));

			usuario.setCuenta(new CuentaDTO(entity.getCuenta().getId(),
					FormatoNumeroCuenta(entity.getCuenta().getNumeroCuenta()), entity.getCuenta().getIngreso()));
			usuario.setDireccion(new DireccionDTO(entity.getDireccion().getId(),
					entity.getDireccion().getCodigoPostal(), entity.getDireccion().getEstado()));

			return usuario;
		} catch (Exception e) {
			throw new Exception("Error al castear usuario: " + e.getMessage());
		}

	}

}
