package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Matricula;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula m) {
		this.entityManager.persist(m);
		System.out.println("Se ha insetrtado la matricula "+m);
	}

	@Override
	public Matricula buscar(int numero) {
		this.entityManager.find(Matricula.class, numero);
		System.out.println("se busca la matricula por id "+numero);
		return null;
	}

	@Override
	public void actualizar(Matricula m) {
		this.entityManager.merge(m);
		System.out.println("actualizando matricula "+m);
	}

	@Override
	public void eliminar(int numero) {
		Matricula m=this.buscar(numero);
		this.entityManager.remove(m);
	}

	
	
}
