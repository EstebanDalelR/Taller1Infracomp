package cliente;

public class Cliente extends Thread {

	public Mensaje mensajexdxd;
	public Buffer bofer;

	public boolean dejarMensaje(Mensaje mensajexdxd){

		if (bofer.recibir(mensajexdxd)) {
			wait();
		}	
		else{
			while(!bofer.recibir(mensajexdxd))
			{
				dejarMensaje(mensajexdxd);
			}
		}
	}


}
