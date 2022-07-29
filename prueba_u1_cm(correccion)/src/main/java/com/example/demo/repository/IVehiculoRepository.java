package com.example.demo.repository;

import com.example.demo.repository.model.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo vehiculo) ;
	
	public Vehiculo buscar(String placa);
	
	public void actualizar(Vehiculo vehiculo);
	
	public void eliminar(String placa);
}
