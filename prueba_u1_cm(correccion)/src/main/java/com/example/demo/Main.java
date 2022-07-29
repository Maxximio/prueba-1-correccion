package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.demo.service.IVehiculoService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.repository.model.Propietario;
import com.example.demo.repository.model.Vehiculo;
import com.example.demo.service.IMatriculaGestorService;

@SpringBootApplication
public class Main implements CommandLineRunner{
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private IMatriculaGestorService gestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/////creando vehiculo
		System.out.println("###############################################################");
		Vehiculo vehiculo=new Vehiculo();
		vehiculo.setMarca("Chevrolet");
		vehiculo.setPlaca("3333333333333");
		vehiculo.setPrecio(new BigDecimal(20000));
		vehiculo.setTipo("P");

		this.vehiculoService.insertarService(vehiculo);
		
		//actualiza vehiculo
		System.out.println("###############################################################");
		vehiculo.setMarca("Mazda");
		vehiculo.setTipo("L");
		
		this.vehiculoService.actualizarService(vehiculo);
		
		//crea propietario
		System.out.println("###############################################################");
		Propietario pro=new Propietario();
		pro.setNombre("Carlos");
		pro.setApellido("Montalvo");
		pro.setCedula("444444444444444");
		pro.setFechaNacimiento(LocalDateTime.of(2000, 04, 01, 5, 30));
		
		this.propietarioService.insertarService(pro);
		
		//realiza matricula
		System.out.println("###############################################################");
		this.gestorService.generar("444444444444444", "3333333333333");
		
	}
}
