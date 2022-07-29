package com.example.demo.service;

import com.example.demo.repository.model.Vehiculo;

public interface IVehiculoService {

	// crear
	public void insertarService(Vehiculo vehiculo);

	// read
	public Vehiculo buscarService(String placa);

	// update
	public void actualizarService(Vehiculo vehiculo);

	// delete
	public void eliminarService(String placa);

}
