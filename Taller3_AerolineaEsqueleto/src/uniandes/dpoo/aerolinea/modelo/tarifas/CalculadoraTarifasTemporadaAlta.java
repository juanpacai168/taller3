package uniandes.dpoo.aerolinea.modelo.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;



public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas {

	protected static final int COSTO_POR_KM= 1000;
	
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		
		int costo= 0;
		int distancia = Aeropuerto.calcularDistancia(vuelo.getRuta().getOrigen(), vuelo.getRuta().getDestino());

        costo+= distancia * COSTO_POR_KM;

        return costo;
		
	}
	
	public double calcularPorcentajeDescuento(Cliente cliente) {
	
		double porcentaje= 0.0;
				
				
		return porcentaje;
	
	}
}
	
