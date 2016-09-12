
//Juan Pablo Arévalo								201211889
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

	//constructor
	public Cliente(long numSolicitudes, Buffer bf) {
		solicitudes=numSolicitudes;
		mensajesProcesados=new ArrayList<>();
		bofer=bf;
	}
	
	//deja un mensaje en el buffer
	public void dejarMensaje(Mensaje mensajexdxd){
		msn = mensajexdxd;
		//espera activa para entregar mensaje
		while(!bofer.recibir(mensajexdxd, this))
			yield();
		//al despertar agrega el mensaje procesado
		mensajesProcesados.add(mensajexdxd);
		solicitudes--;
	}

	//ejecución
	public void run() {
		//mientras queden solicitudes por atender, lo intenta
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
