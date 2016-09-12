package buffer;

import cliente.Cliente;

public class Buffer {

	/**
	 * Número de clientes que querrán acceder al buffer
	 */
	private int numClientes;
	
	/**
	 * Capacidad de almacenamiento del buffer
	 */
	private int capacidad;
	
	/**
	 * Numero de mensajes guardados en el momento en el buffer
	 */
	private int nMensajes;

	/**
	 * Arreglo para almacenar los mensajes
	 */
	private Mensaje [] listaMensaje;

	/**
	 * Método que sirve para recibir y almacenar un mensaje en el buffer
	 * @param m mensaje a almacenar
	 * @param cl Cliente que almacena el mensaje en el buffer
	 * @return true si pudo almacenar el mensaje, false de lo contrario
	 */
	public synchronized boolean recibir(Mensaje m, Cliente cl)
	{
		System.out.println("entré recibir"); 
		
		//revisa si la capacidad actual me permite almacenar un mensaje
		if(capacidad>nMensajes)
		{
			//agrega el mensaje al arreglo
			listaMensaje[nMensajes] = m;
			nMensajes++;
			
			//notifica a un servidor en caso de que haya alguno dormido sobre el buffer
			notify();
			
			//duerme al cliente sobre el objeto del mensaje
			cl.getMessage().dormir();
			System.out.println("Recibido en Buffer\n");
			return true;
		}
		else return false;
	}
	
	/**
	 * Metodo que sirve para que un mesaje sea procesado y extraido del buffer
	 * @return Mensaje que se remueve del buffer
	 */
	public synchronized Mensaje atender()
	{
		//si no hay mensajes en el buffer, se pone al servidor a dormir
		if(listaMensaje.length==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ME VOY A DORMIR SERVIDO");
		
		//obtiene el primer mensaje en el buffer
		Mensaje men = listaMensaje[0];
		//rota los elementos del arreglo; esto para que siempre se atienda al primer mensaje en el arreglo
		arreglarArreglo(listaMensaje);
		nMensajes--;
		
		System.out.println(men.msj);
		return men;
	} 
	
	/**
	 * Constructor del Buffer
	 * @param ncapacidad Capacidad de almacenamiento del buffer
	 * @param numClientes Nuumero de clientes que espera recibir el buffer
	 */
	public Buffer(int ncapacidad, int numClientes) 
	{
		this.numClientes=numClientes;
		capacidad=ncapacidad;
		listaMensaje = new Mensaje[capacidad];
		nMensajes = 0;
	}

	/**
	 * Metodo auxiliar para rotar los elementos del array
	 * @param mensa
	 */
	public void arreglarArreglo(Mensaje [] mensa)
	{
		mensa[0]=null;
		for(int i=0; i<mensa.length-1;i++)
		{
			mensa[i]=mensa[i+1]; 			
		}
	}

}
