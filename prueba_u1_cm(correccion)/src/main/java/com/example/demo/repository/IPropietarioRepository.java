package com.example.demo.repository;

import com.example.demo.repository.model.Propietario;

public interface IPropietarioRepository {

	// crear
	public void insertar(Propietario propietario);

	// read
	public Propietario buscar(String cedula);

	// update
	public void actualizar(Propietario propietario);

	// delete
	public void eliminar(String cedula);

}
