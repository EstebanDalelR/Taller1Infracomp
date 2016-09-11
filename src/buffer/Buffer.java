package buffer;

public class Buffer {

	public int capacidad;
	public int nMensajes;
	public boolean lleno;
	public Mensaje [] listaMensaje;
	public synchronized boolean recibir(Mensaje m)
	{
		if(capacidad>nMensajes)
		{
			listaMensaje[nMensajes] = m;
			nMensajes++;
			return true;
		}
		else return false;
	}
	public synchronized Mensaje atender()
	{
		Mensaje men = listaMensaje[0];
		arreglarArreglo(listaMensaje);
		nMensajes--;
		return men;
	} 
	
	public Buffer(int ncapacidad) 
	{
		listaMensaje = new Mensaje[capacidad];
		nMensajes = 0;
	}

	public void arreglarArreglo(Mensaje [] mensa)
	{
		mensa[0]=null;
		for(int i=0; i<mensa.length;i++)
		{
			mensa[i]=mensa[i+1]; 			
		}
	}

}
