package servidor;
import buffer.*;
//Juan Pablo Arévalo								201211889
//Esteban Dalel										201227078
//Diego Tovar										201512531

public class Servidor extends Thread {

	private Buffer bf;
	
	public Servidor(Buffer bf) {
		this.bf=bf;
	}

	public void run() {
		while(true) {
			Mensaje msn = null;
			do {	
				msn = bf.atender();
			}while(msn==null);
			procesar(msn);
		}
	}
	
	public void procesar(Mensaje msn) {
		msn.actualizarInfo(msn.darMensaje()+1);
		try {
			sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Recibido en Buffer SERVIDO\n");
		msn.despertar();
	}
}
