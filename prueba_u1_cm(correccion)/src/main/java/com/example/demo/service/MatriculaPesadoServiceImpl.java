package com.example.demo.service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Pesado")
public class MatriculaPesadoServiceImpl implements IMatriculaService{
	
//	@Override
//	public void realizarMatricula(String cedula,String placa) {
//		System.out.println();
//		System.out.println("Generando Matricula...");
//		
//		BigDecimal valorPagar=null;
//		
//		Vehiculo veh=new Vehiculo();
//		veh=vehiculoRepository.buscar(placa);
//		
//		Propietario pro=new Propietario();
//		pro=propietarioRepository.buscar(cedula);
//		
//		Matricula mat=new Matricula();
//		mat.setFechaMatricula(LocalDateTime.now());
//		mat.setPropietario(pro);
//		mat.setVehiculo(veh);
//		
//		if(veh.getTipo()=="P") {
//			valorPagar=veh.getPrecio().multiply(new BigDecimal(0.15));
//
//		}else {
//			valorPagar=veh.getPrecio().multiply(new BigDecimal(0.1));
//		}
//		
//		int trans=valorPagar.intValue();
//		
//		if(trans>2000) {
//			BigDecimal descuento=valorPagar.multiply(new BigDecimal(0.07));
//			valorPagar=valorPagar.subtract(descuento);
//		}
//		
//		mat.setValor(valorPagar);
//		
//		matriRepo.insertar(mat);
//	}

	@Override
	public BigDecimal calcular(BigDecimal precio) {
		return precio.multiply(new BigDecimal(0.15));
	}

}
