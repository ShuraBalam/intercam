/**
 * Clase repositorio para usar la interfaz de JPA e invocar las funciones de CRUD para operar la base de datos
 * 
 * @author Efrain Coronel Rojas
 * @Fecha Creacion 15/08/2022 
 */
package com.intercam.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intercam.Entity.UsuarioEntity;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

}
