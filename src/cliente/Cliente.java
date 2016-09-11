package cliente;

import java.util.ArrayList;

import buffer.*;

public class Cliente extends Thread {

	public Buffer bofer;
	private ArrayList<Mensaje> mensajesProcesados; 
	private long solicitudes;
	
	public Cliente(long numSolicitudes, Buffer bf) {
		solicitudes=numSolicitudes;
		mensajesProcesados=new ArrayList<>();
		bofer=bf;
	}

	public void dejarMensaje(Mensaje mensajexdxd){

			while(!bofer.recibir(mensajexdxd))yield();
			mensajexdxd.dormir();
			mensajesProcesados.add(mensajexdxd);
			solicitudes--;
	}
	
	public void run() {
		while(solicitudes>0) {
			dejarMensaje(new Mensaje(solicitudes));
		}
	}
	
	public int arraySize() {
		return mensajesProcesados.size();
	}
}
