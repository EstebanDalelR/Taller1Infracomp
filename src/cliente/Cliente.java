
//Juan Pablo Arévalo									201211889
//Esteban Dalel										201227078
//Diego Tovar										201512531
package cliente;

import java.util.ArrayList;

import buffer.*;

public class Cliente extends Thread {

	public Buffer bofer;
	private ArrayList<Mensaje> mensajesProcesados; 
	private long solicitudes;
	private Mensaje msn;
	
	public Cliente(long numSolicitudes, Buffer bf) {
		solicitudes=numSolicitudes;
		mensajesProcesados=new ArrayList<>();
		bofer=bf;
	}

	public void dejarMensaje(Mensaje mensajexdxd){
			msn = mensajexdxd;
			while(!bofer.recibir(mensajexdxd, this))yield();
			mensajesProcesados.add(mensajexdxd);
			solicitudes--;
	}
	
	public void run() {
		while(solicitudes>0) {
			dejarMensaje(new Mensaje(solicitudes));
			System.out.println("dejo una solicitud");
		}
	}
	
	public int arraySize() {
		return mensajesProcesados.size();
	}
	
	public Mensaje getMessage() {
		return msn;
	}
}
