package com.example.demo.service;

import com.example.demo.repository.model.Propietario;

public interface IPropietarioService {

	// crear
	public void insertarService(Propietario e);

	// read
	public Propietario buscarService(String cedula);

	// update
	public void actualizarService(Propietario e);

	// delete
	public void eliminarService(String cedula);

}
