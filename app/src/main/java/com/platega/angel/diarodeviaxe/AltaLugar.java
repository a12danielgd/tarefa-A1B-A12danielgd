package com.platega.angel.diarodeviaxe;



import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.platega.angel.diariodeviaxe.utiles.Constantes;
import com.platega.angel.diariodeviaxe.utiles.Utiles;
import com.platega.angel.diarioviaxe.almacenamento.BaseDatos;
import com.platega.angel.diarioviaxe.almacenamento.Lugares;

public class AltaLugar extends Activity {

	
	
	private void xestionarEventos(){
		
		ImageButton img = (ImageButton)findViewById(R.id.imgBtn_altalugar_volver);
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		img = (ImageButton)findViewById(R.id.imgBtn_altalugar_novoLugar);
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (!comprobarNome()){
					return;
				}
				Utiles.amosarMensaxe(R.string.string_altalugar_mensaxe_altaFeita, AltaLugar.this);

				EditText nome = (EditText)findViewById(R.id.editT_altalugar_nome);
				EditText descrip = (EditText)findViewById(R.id.editT_altalugar_desciprcion);
				

				// Creamos os cartafois onde gardar a imaxes e audios => Enviamos á bd.
				File sdCard= Environment.getExternalStorageDirectory();
				
				// DAR DE ALTA NA BD
				// DE AQUI OBTERIAMOS O NUMERO (ID) CLAVE PRIMARIA DA TABOA
				// ACTUALIZAMOS A BASE DE DATOS PARA GARDAR NA TABOA LUGARES A RUTA O RAIZ DO SITIO E ÓS RECURSOS (IMAXES/FOTOS) DA SD.
				
				
				// Lanzamos a activity de AltaRecordos coa nova Id.
				Intent intento = new Intent(AltaLugar.this,AltaRecordos.class);
//				long id = lugar.getId();
//
//				intento.putExtra(Constantes.ID_LUGAR, id);
//				intento.putExtra(Constantes.NOME_LUGAR, lugar.getNome());
				
				startActivity(intento);
				
				finish();
			}
		});
		
	}

	
	private boolean comprobarNome(){
		EditText edit = (EditText)findViewById(R.id.editT_altalugar_nome);
		if (edit.getText().length()==0){
			Utiles.amosarMensaxe(R.string.string_altalugar_mensaxe_nomeObrigatorio, this);
			return false;
		}
		return true;
		
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		
	}
	


	@Override 
	public void onStop(){
		super.onStop();
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_altalugar);
		
		xestionarEventos();

	}
}
