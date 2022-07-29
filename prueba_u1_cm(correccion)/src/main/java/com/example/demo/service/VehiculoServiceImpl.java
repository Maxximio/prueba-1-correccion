package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.model.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository estuRepo;
	
	@Override
	public void insertarService(Vehiculo e) {
		this.estuRepo.insertar(e);
	}

	@Override
	public Vehiculo buscarService(String apellido) {
		return this.estuRepo.buscar(apellido);
	}

	@Override
	public void actualizarService(Vehiculo e) {
		this.estuRepo.actualizar(e);
	}

	@Override
	public void eliminarService(String cedula) {
		this.estuRepo.eliminar(cedula);
	}

}
