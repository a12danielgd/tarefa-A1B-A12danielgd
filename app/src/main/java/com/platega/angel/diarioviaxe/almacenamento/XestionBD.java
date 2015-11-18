package com.platega.angel.diarioviaxe.almacenamento;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;


public class XestionBD {

	
	/**
	 * Copia a base de datos dende Assets => /data/data/database
	 */
	public static void copiarBaseDatos(Context contexto,boolean borrardestino)
	     throws IOException
	
	{
		if (!existeBDenData(contexto) || (borrardestino)){
			String pathbd = "/data/data/" + contexto.getPackageName()+"/databases/";
			String bddestino =pathbd + BaseDatos.NOME_BD;
			File filepathdb = new File(pathbd);
			filepathdb.mkdirs();
			
			InputStream inputstream = contexto.getAssets().open(BaseDatos.NOME_BD);
			OutputStream outputstream = new FileOutputStream(bddestino);

			int tamread;
			byte[] buffer = new byte[2048];
			
			while((tamread = inputstream.read(buffer))>0){
				outputstream.write(buffer,0,tamread);
			}
			
			inputstream.close();
			outputstream.close();
			
				
			
		}
		
	}
	
	public static boolean existeBDenData(Context contexto){
		String bddestino ="/data/data/" + contexto.getPackageName()+"/databases/"+ BaseDatos.NOME_BD;
		
		File file = new File(bddestino);
		return file.exists();
	}
	
}
