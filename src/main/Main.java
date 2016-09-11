package main;

import cliente.*;

import java.util.ArrayList;

import buffer.*;
import servidor.*;

public class Main {

	private static ArrayList<Cliente> clientes;
	
	public static void main(String[] args) {
		Buffer bf = new Buffer(6, 3);
		
		clientes = new ArrayList<>();
		for(int i=0; i<3; i++) {
			Cliente actual=new Cliente(3, bf);
			actual.start();
			clientes.add(actual);
		}
		Servidor s1=new Servidor(bf);
		Servidor s2=new Servidor(bf);
		
		s1.start();
		s2.start();
		
		for(Cliente c : clientes) {
			System.out.println(c.arraySize()+ " I: " + clientes.indexOf(c));
		}
	}

}
