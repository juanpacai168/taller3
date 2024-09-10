package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected static final int COSTO_POR_KM_NATURAL= 600;
	protected static final int COSTO_POR_KM_CORPORATIVO= 900;
	protected static final double DESCUENTO_PEQ= 0.02;
	protected static final double DESCUENTO_MEDIANAS= 0.1;
	protected static final double DESCUENTO_GRANDES= 0.2;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
	    Aeropuerto aeropuertoOrigen = vuelo.getRuta().getOrigen();
	    Aeropuerto aeropuertoDestino = vuelo.getRuta().getDestino();
	    int distancia = Aeropuerto.calcularDistancia(aeropuertoOrigen, aeropuertoDestino);

	    int costoBase;
	    
	    
	    if (cliente.getTipoCliente().equals("Corporativo")) {
	        costoBase = distancia * COSTO_POR_KM_CORPORATIVO;
	    } else {
	        costoBase = distancia * COSTO_POR_KM_NATURAL;
	    }

	    return costoBase;
	}
	public double calcularPorcentajeDescuento(Cliente cliente) {
		
		if (cliente.getTipoCliente().equals("Corporativo")) {
		    ClienteCorporativo clienteCorporativo = (ClienteCorporativo) cliente;
		    
		    
		    int tamanoEmpresa = clienteCorporativo.getTamanoEmpresa();
		    
		    
		    if (tamanoEmpresa == clienteCorporativo.GRANDE) {
		        return DESCUENTO_GRANDES;
		    } else if (tamanoEmpresa == clienteCorporativo.MEDIANA) {
		        return DESCUENTO_MEDIANAS;
		    } else {
		        return DESCUENTO_PEQ;
		    }
		}
		
		
		return 0;
	}

			
		
	}
	





	
	
	
	



