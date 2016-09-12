package servidor;
import buffer.*;
public class Servidor extends Thread {

	
	/**
	 * Conexion al buffer
	 */
	private Buffer bf;
	
	
	/**
	 * Constructor de la clase; inicializa la conexion al buffer
	 * @param bf referencia al buffer administrador
	 */
	public Servidor(Buffer bf) {
		this.bf=bf;
	}

	
	public void run() {
		while(true) {
			//variable con el mensaje a procesar
			Mensaje msn = null;
			do {	
				//intenta obtener un mensaje del buffer
				msn = bf.atender();
			}while(msn==null);
			
			//al obtener un mensaje del buffer procede a procesarlo
			procesar(msn);
		}
	}
	
	public void procesar(Mensaje msn) {
		
		//actualiza el valor almacenado en el mensaje
		msn.actualizarInfo(msn.darMensaje()+1);
		
		try {
			//espera un tiempo
			sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Recibido en Buffer SERVIDO\n");
		
		//Despierta a los threads dormidos sobre el objeto del mensaje
		msn.despertar();
	}
}
