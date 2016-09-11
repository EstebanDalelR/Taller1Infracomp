package servidor;
import buffer.*;
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
		msn.actualizarInfo(msn.darInfo()++);
		sleep(20);
		msn.despertar();
	}
}
