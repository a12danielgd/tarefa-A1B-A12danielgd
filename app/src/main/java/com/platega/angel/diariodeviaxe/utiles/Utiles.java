package com.platega.angel.diariodeviaxe.utiles;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Utiles {

	private final static String TAG = "DIARIOVIAXE";
	
	public static void amosarMensaxe(int id, Context context){
		Toast.makeText(context, context.getResources().getString(id), Toast.LENGTH_LONG).show();
	}
	
	public static void amosasrLog(String mensaxe){
		
		Log.i(TAG, mensaxe);
	}
}
