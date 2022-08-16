/**
 * Clase controlador para exponer api rest para el uso de CRUD de los registros en base de datos
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022
 */
package com.intercam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.intercam.DTO.UsuarioDTO;
import com.intercam.IService.IUsuarioService;

@RestController
@RequestMapping("/api")

public class UsuarioController {

	@Autowired
	private IUsuarioService service;

	/**
	 * Funcion para exponer la funcionalidad de insertar un nuevo usuario en base de
	 * datos
	 * 
	 * @param usuarioDTO objeto con la informacion del usuario para insertarla en
	 *                   base de datos
	 * @return verdadero en el caso de insertarla en base de datos
	 * @throws Exception Mensaje de error en el caso de tener error en la validacion
	 *                   de los campos
	 */

	@ResponseBody
	@PostMapping
	public ResponseEntity<Boolean> insertarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		try {
			return ResponseEntity.ok(service.InsertarUsuario(usuarioDTO));
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
	}

	/**
	 * Funcion para obtener los registros existentes en base de datos
	 * 
	 * @return lista de registros de base de datos
	 * @throws Exception mensaje de error
	 */
	@ResponseBody
	@GetMapping("/consultaTodos")
	public ResponseEntity<List<UsuarioDTO>> obtenerTodos() throws Exception {

		return ResponseEntity.ok(service.BuscarTodoUsuario());
	}

	/**
	 * Funcion para buscar un usuario por ID
	 * 
	 * @param idUsuario
	 * @return entidad con la informacion del usuario buscado
	 * @throws Exception mensaje de error
	 */
	@ResponseBody
	@GetMapping("/consultaUnico")
	public ResponseEntity<UsuarioDTO> obtenerUsuario(@RequestParam String idUsuario) throws Exception {

		return ResponseEntity.ok(service.BuscarUsuario(Integer.parseInt(idUsuario)));
	}

	/**
	 * Funcion para eliminar un usuario de la base de datos por medio del ID
	 * 
	 * @param usuarioDTO
	 * @return true en el caso de eliminarlo
	 */
	@ResponseBody
	@DeleteMapping
	public ResponseEntity<Boolean> eliminarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return ResponseEntity.ok(service.eliminarUsuario(usuarioDTO));
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
	}

	/**
	 * Funcion para actualizar un registro de base de datos de acuerdo al objeto
	 * consultado previamente
	 * 
	 * @param usuarioDTO
	 * @return
	 */
	@ResponseBody
	@PutMapping
	public ResponseEntity<Boolean> ActualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			return ResponseEntity.ok(service.ActualizarUsuario(usuarioDTO));
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

		}
	}
}
