package main;

import cliente.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import buffer.*;
import servidor.*;

//Juan Pablo Ar�valo									201211889
//Esteban Dalel										201227078
//Diego Tovar										201512531


public class Main {
	
	private static ArrayList<Cliente> clientes;
	private static ArrayList<Servidor> servidores;
	
	public static void main(String[] args) {
		//tomado de https://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example
		
		ArrayList<Integer> a = new ArrayList();
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("./src/main/propiedades.txt"));
			System.out.println("leido del archivo");
		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {
		int l = Integer.parseInt(sCurrentLine);
		       a.add(l);       
		}

		} catch (IOException e) {
		e.printStackTrace();
		}
		
		int numServ = a.get(0);
		int capBuffer = a.get(1);
		int numClientes = a.get(2);
		int numMensajes = a.get(3);
		System.out.println("recibido parametro");
		Buffer bf = new Buffer(capBuffer, numClientes);
		
		clientes = new ArrayList<>();
		servidores = new ArrayList<>();
		
		for(int i=0; i<numClientes; i++) {
			Cliente actual=new Cliente(numMensajes, bf);
			actual.start();
			clientes.add(actual);
		}
		
		System.out.println("creados servidores");
		//while(true)
		System.out.println("creados clientes");
		for(int i=0; i<numServ;i++) {
			Servidor actual=new Servidor(bf);
			actual.start();
			servidores.add(actual);
		}
		System.out.println(clientes.get(0).arraySize());

	}

}
