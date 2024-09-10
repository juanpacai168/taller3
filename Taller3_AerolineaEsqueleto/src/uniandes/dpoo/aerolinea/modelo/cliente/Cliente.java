package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.LinkedList;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private LinkedList<Tiquete> tiquetesSinUsar = new LinkedList<Tiquete> ();
	private LinkedList<Tiquete> tiquetesUsados = new LinkedList<Tiquete> ();
	public abstract String getTipoCliente();
	public abstract String getIdentificador();
	public void agregarTiquete(Tiquete tiquete)
	{
		tiquetesSinUsar.add(tiquete);
		
		
	}
	
	
	public int calcularValorTotalTiquetes()
	{
		int contador = 0;
		for (Tiquete tiquete: tiquetesSinUsar) {
			contador += tiquete.getTarifa();
		}
		for (Tiquete tiquete: tiquetesUsados) {
			contador += tiquete.getTarifa();
		}
		return contador;
	}
	
	public void usarTiquetes(Vuelo vuelo) {
	
	LinkedList<Tiquete> usados= new LinkedList<>();
	
	for (Tiquete tiquete: tiquetesSinUsar) {
		if (tiquete.getVuelo().equals(vuelo)) {
			tiquete.marcarComoUsado();
			tiquetesUsados.add(tiquete);
			usados.add(tiquete);
			}
		}
	for (Tiquete tiquete: usados) {
		
		tiquetesSinUsar.remove(tiquete);
		
	}
		
	}
}


