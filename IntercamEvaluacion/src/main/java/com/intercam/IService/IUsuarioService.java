/**
 * Clase interfaz para definir las funciones que se usaran para las operaciones de negocio sobre la informacion
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.IService;

import java.util.List;

import com.intercam.DTO.UsuarioDTO;

public interface IUsuarioService {

	boolean InsertarUsuario(UsuarioDTO usuario) throws Exception;

	boolean ActualizarUsuario(UsuarioDTO usuario) throws Exception;

	List<UsuarioDTO> BuscarTodoUsuario() throws Exception;

	UsuarioDTO BuscarUsuario(int idUsuario) throws Exception;

	boolean eliminarUsuario(UsuarioDTO usuario) throws Exception;
}
