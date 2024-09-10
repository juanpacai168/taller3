package uniandes.dpoo.aerolinea.modelo;

import java.util.LinkedList;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private LinkedList<Tiquete> tiquetes = new LinkedList<Tiquete> ();
	
	public Vuelo(Ruta ruta,String fecha, Avion avion) {
        this.fecha = fecha;
        this.ruta = ruta;
        this.avion = avion;
        

    }

	public String getFecha() {
		return fecha;
	}

	
	public Avion getAvion() {
		return avion;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public LinkedList<Tiquete> getTiquetes() {
		return tiquetes;
	}
	
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true; 
	    }
	    else;{
	       return false;
	    }
	}

	public  int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
	    int capacidad = avion.getCapacidad();
	    int tiquetesVendidos = tiquetes.size();

	    if (capacidad - tiquetesVendidos < cantidad) {
	        throw new VueloSobrevendidoException(this); 
	    }

	    int total = 0;

	    for (int i = 0; i < cantidad; i++) {
	        int costoTiquete = calculadora.calcularTarifa(this, cliente);
	        Tiquete tiquete = GeneradorTiquetes.generarTiquete(this, cliente, costoTiquete);
	        tiquetes.add(tiquete); 
	        cliente.agregarTiquete(tiquete); 
	        total += costoTiquete; 
	    }
	    return total;
	}}