package cliente;

public class Cliente extends Thread {

	public Mensaje mensajexdxd;
	public Buffer bofer;
	private arrayList mensajesProcesados; 

	public boolean dejarMensaje(Mensaje mensajexdxd){

		if (bofer.recibir(mensajexdxd)) {
			wait();
			mensajesProcesados.add(mensajexdxd);
		}	
		else{
			while(!bofer.recibir(mensajexdxd))
			{
				dejarMensaje(mensajexdxd);
			}
		}
	}





}
