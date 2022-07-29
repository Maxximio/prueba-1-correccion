package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.model.Propietario;
import com.example.demo.repository.IPropietarioRepository;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository materiaRepo;

	@Override
	public void insertarService(Propietario e) {

		this.materiaRepo.insertar(e);
	}

	@Override
	public Propietario buscarService(String nombre) {
		// TODO Auto-generated method stub
		return this.materiaRepo.buscar(nombre);
	}

	@Override
	public void actualizarService(Propietario e) {
		// TODO Auto-generated method stub
		this.materiaRepo.actualizar(e);
	}

	@Override
	public void eliminarService(String nombre) {
		// TODO Auto-generated method stub
		this.materiaRepo.eliminar(nombre);
	}
	
	

}
