package buffer;

import cliente.Cliente;

public class Buffer {

	
	private int numClientes;
	private int capacidad;
	private int nMensajes;
	private boolean lleno;
	private Mensaje [] listaMensaje;

	public synchronized boolean recibir(Mensaje m, Cliente cl)
	{
		if(capacidad>nMensajes)
		{
			listaMensaje[nMensajes] = m;
			nMensajes++;
			notify();
			cl.getMessage().dormir();
			return true;
		}
		else return false;
	}
	public synchronized Mensaje atender()
	{
		if(listaMensaje.length==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Mensaje men = listaMensaje[0];
		arreglarArreglo(listaMensaje);
		nMensajes--;
		return men;
	} 
	
	public Buffer(int ncapacidad, int numClientes) 
	{
		this.numClientes=numClientes;
		capacidad=ncapacidad;
		listaMensaje = new Mensaje[capacidad];
		nMensajes = 0;
	}

	public void arreglarArreglo(Mensaje [] mensa)
	{
		mensa[0]=null;
		for(int i=0; i<mensa.length-1;i++)
		{
			mensa[i]=mensa[i+1]; 			
		}
	}

}
