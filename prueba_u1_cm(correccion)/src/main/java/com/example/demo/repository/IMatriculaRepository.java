package com.example.demo.repository;

import com.example.demo.repository.model.Matricula;

public interface IMatriculaRepository {
	
	// crear
	public void insertar(Matricula matricula);

	// read
	public Matricula buscar(int numero);

	// update
	public void actualizar(Matricula matricula);

	// delete
	public void eliminar(int numero);

}
