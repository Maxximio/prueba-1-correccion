package com.example.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Propietario;

@Transactional
@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario propietario) {
		this.entityManager.persist(propietario);
		System.out.println("Insertando "+propietario);
	}

	@Override
	public Propietario buscar(String cedula) {
		Query jpqlQuery=this.entityManager
				.createQuery("select p from Propietario p Where p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		return (Propietario) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);
	}

	@Override
	public void eliminar(String cedula) {
		Propietario p=this.buscar(cedula);
		this.entityManager.remove(p);
		System.out.println("eliminando propietario de cedula "+cedula);
	}
}
