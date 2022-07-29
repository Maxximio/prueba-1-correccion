package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Vehiculo;

@Transactional
@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo vehi) {
		this.entityManager.persist(vehi);
		System.out.println("se ha insertado el vehiculo "+vehi);
	}

	@Override
	public Vehiculo buscar(String placa) {
		Query jpqlQuery=this.entityManager
				.createQuery("select v from Vehiculo v Where v.placa = :datoPlaca");
		jpqlQuery.setParameter("datoPlaca", placa);
		
		return (Vehiculo) jpqlQuery.getSingleResult();
	}

	@Override
	public void actualizar(Vehiculo vehi) {
		this.entityManager.merge(vehi);
		System.out.println("se ha actualizado "+vehi);
	}

	@Override
	public void eliminar(String placa) {
		Vehiculo v=this.buscar(placa);
		this.entityManager.remove(v);
		System.out.println("se elimina al vehiculo por placa: "+placa);
	}

	
}
