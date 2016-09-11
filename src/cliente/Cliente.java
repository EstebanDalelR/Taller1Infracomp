package cliente;

import java.util.ArrayList;

import buffer.*;

public class Cliente extends Thread {

	public Mensaje mensajexdxd;
	public Buffer bofer;
	private ArrayList mensajesProcesados; 

	public boolean dejarMensaje(Mensaje mensajexdxd){

			while(!bofer.recibir(mensajexdxd));
			mensajexdxd.dormir();
			mensajesProcesados.add(mensajexdxd);
		}



}
