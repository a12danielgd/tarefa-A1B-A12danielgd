package com.platega.angel.diarodeviaxe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.platega.angel.diariodeviaxe.utiles.Utiles;

public class AltaRecordos extends Activity  {



	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		// GARDAMOS O RESULTADO DE OBTER A FOTO
		
	}

	@Override
	protected void onSaveInstanceState(Bundle estado) {

		super.onSaveInstanceState(estado);
	}

	@Override
	protected void onRestoreInstanceState(Bundle estado) {
		super.onRestoreInstanceState(estado);
		
		prepararCartafois();
	}

	/**
	 * Menu emerxente. O usamos no HorizontalScrollView
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menualtalugarborrarrecordo, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_altaLugar_borrarRecordo:
			// PROCESAMOS
			Utiles.amosasrLog("BORRAMOS RECORDO");
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}


	/**
	 * Xestiona os dialogos que aparecen cando reproducimos un audio ou gravamos
	 * @param reproducirAudio
	 * @param mensaxe
	 * @param textoBoton
	 */
	private void xestionarDialogos(final boolean reproducirAudio,int mensaxe, int textoBoton){
			AlertDialog.Builder dialog = new AlertDialog.Builder(AltaRecordos.this)
			.setMessage(mensaxe)
			.setPositiveButton(textoBoton, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					if (!reproducirAudio){
						// Paramos de gravar
					}
					else {
						// Paramos de reproducir
					}
					
				}
			});
		dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				// TODO Auto-generated method stub
				try {
					if (!reproducirAudio){
						// Paramos de gravar
					}
					else {
						// Paramos de reproducir
					}
				}
				catch (Exception e){
					
				}
			}
		});
		dialog.show();
			
	}
	private void xestionarEventos() {
		
		//BOTON ATRAS
		ImageButton imgBtnAtras = (ImageButton) findViewById(R.id.imgBtn_altarecordos_volver);
		imgBtnAtras.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				finish();
			}
		});
		

		// BOTON DE IMAXE
		ImageButton imgBtnNovaFoto = (ImageButton) findViewById(R.id.imgBtn_altarecordos_novafoto);
		imgBtnNovaFoto.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


			}
		});
		
		// BOTON DE AUDIO
		ImageButton imgBtnNovoAudio = (ImageButton) findViewById(R.id.imgBtn_altarecordos_novoaudio);
		imgBtnNovoAudio.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			}
		});
		
		// REPRODUCIR AUDIO DA LISTA
		ListView lista = (ListView)findViewById(R.id.listview_altarecordos_audios);
		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		// Gravar Punto GPS
		ImageButton gps = (ImageButton)findViewById(R.id.imgBtn_altarecordos_novogps);
		gps.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 
			}
		});
		
		
	}

	/**
	 * Carga as imaxes no HorizontalScrollView
	 */
	private void cargarImaxes(){
		// Co id do lugar faremos unha consulta á base de datos.
		//  Mentras non se da poden obter as fotos dos arquivos gardados no cartafol de imaxes utilizar File
		
	}
	
	private void cargarAudios(){
		// Co id do lugar faremos unha consulta á base de datos.
		//  Mentras non se da poden obter as fotos dos arquivos gardados no cartafol de audios utilizar File
		
	}
	
	private void cargarGPS(){
		
		// DATO OBTIDO DA BD
		
	}

	// Instanciamos o gravador
	private void prepararGravador(){
	}
	
	// Instanciamos o reproductor 
	private void prepararReproductor(){
		
	}
	
	// Crea os cartafos a partires do nome do lugar da forma: /DIARIO_DE_VIAXE/NOME_LUGAR/IMAXES  | /DIARIO_DE_VIAXE/NOME_LUGAR/AUDIOS
	// Definidas na clase Constantes
	private void prepararCartafois(){

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
	protected void onDestroy(){
		super.onDestroy();
		
	}
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_altarecordos);

	
		// RECUPERAMOS CO ID ENVIADO (no Intent dende AltaLugar) A INFORMACION DE ONDE SE ATOPAN OS RECURSOS

		prepararCartafois();
		xestionarEventos();
		cargarImaxes();
		cargarAudios();

		cargarGPS();

		

		prepararGravador();
		prepararReproductor();
		

	}


}
