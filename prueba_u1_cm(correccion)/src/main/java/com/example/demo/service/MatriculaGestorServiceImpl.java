package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.model.Matricula;
import com.example.demo.repository.model.Propietario;
import com.example.demo.repository.model.Vehiculo;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService{

	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Autowired
	@Qualifier("Pesado")
	private IMatriculaService matriculaServicePesado;
	
	@Autowired
	@Qualifier("Liviano")
	private IMatriculaService matriculaServiceLiviano;
	
	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Override
	public void generar(String cedula, String placa) {
		
		Propietario pro=this.propietarioRepository.buscar(cedula);
		Vehiculo vehi=this.vehiculoRepository.buscar(placa);
		
		String tipo=vehi.getTipo();
		BigDecimal valorMatricula;
		
		if(tipo.equals("P")) {
			valorMatricula=this.matriculaServicePesado.calcular(vehi.getPrecio());
		}else {
			valorMatricula=this.matriculaServiceLiviano.calcular(vehi.getPrecio());
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000))>0) {
			BigDecimal valorDescuento=valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula=valorMatricula.subtract(valorDescuento);
		}
		
		Matricula matricula=new Matricula();
		matricula.setPropietario(pro);
		//matricula.setVehiculo(vehi);
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValor(valorMatricula);
		
		this.matriculaRepository.insertar(matricula);
		vehi.setMatricula(matricula);
		this.vehiculoRepository.actualizar(vehi);
		
	}

}
