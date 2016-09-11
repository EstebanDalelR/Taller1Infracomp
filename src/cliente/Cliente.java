package cliente;

import java.util.ArrayList;

import buffer.*;

public class Cliente extends Thread {

	public Mensaje mensajexdxd;
	public Buffer bofer;
	private ArrayList mensajesProcesados; 
	private long solicitudes;
	
	public Cliente(long numSolicitudes) {
		solicitudes=numSolicitudes;
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
}
