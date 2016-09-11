package cliente;

public class Cliente extends Thread {

	public Mensaje mensajexdxd;
	public Buffer bofer;
	private arrayList mensajesProcesados; 

	public boolean dejarMensaje(Mensaje mensajexdxd){

			while(!bofer.recibir(mensajexdxd))
			{
				dejarMensaje(mensajexdxd);
			}
		}



}
