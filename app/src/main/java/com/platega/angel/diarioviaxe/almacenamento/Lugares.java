package com.platega.angel.diarioviaxe.almacenamento;

import java.util.ArrayList;


public class Lugares {

	private long _id;
	private String nome;
	private String descripcion;
//	private ArrayList<LatLng>coordenadasGPS;		=> Ata que non importemos os Google Play Services non podemos usar o tipo LatLng
	
	public Lugares(){
		
	}

	public Lugares(long id, String nome, String descripcion){
		this._id=id;
		this.nome=nome;
		this.descripcion=descripcion;
		
//		coordenadasGPS = new ArrayList<LatLng>();	=> Ata que non importemos os Google Play Services non podemos usar o tipo LatLng
	}
	

	
	
	
	
	@Override
	public String toString() {
	    return nome;
	}

	
}
