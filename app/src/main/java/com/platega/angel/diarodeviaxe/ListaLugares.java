package com.platega.angel.diarodeviaxe;

import java.io.File;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;

import com.platega.angel.diariodeviaxe.utiles.Constantes;
import com.platega.angel.diariodeviaxe.utiles.Utiles;
import com.platega.angel.diarioviaxe.almacenamento.BaseDatos;
import com.platega.angel.diarioviaxe.almacenamento.Lugares;

public class ListaLugares extends ListActivity {

	private ArrayAdapter<Lugares> adaptador;
	
	@Override
	protected void onStart(){
		super.onStart();
		

	}
	


	@Override 
	public void onStop(){
		super.onStop();
		
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menulistalugares, menu);
	}	

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		Lugares lugar = (Lugares)getListAdapter().getItem(info.position);
		switch (item.getItemId()) {
		case R.id.menu_listalugares_detalleLugar:
			Intent intento = new Intent(this,AltaRecordos.class);
			
//			long id = lugar.getId();
//
//			intento.putExtra(Constantes.ID_LUGAR, id);
//			intento.putExtra(Constantes.NOME_LUGAR, lugar.getNome());
			
			startActivity(intento);

			return true;
		case R.id.menu_listalugares_borrarLugar:
			// PROCESAMOS

			Utiles.amosarMensaxe(R.string.string_listalugares_mensaxe_lugarBorrado, this);
			return true;
		case R.id.menu_listalugares_mapaLugar:
			// PROCESAMOS
			Intent intento2 = new Intent(this,XestionMapa.class);
			
//			long id2 = lugar.getId();
//
//			intento2.putExtra(Constantes.ID_LUGAR, id2);
//			intento2.putExtra(Constantes.NOME_LUGAR, lugar.getNome());
			
			startActivity(intento2);
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}
	


	public static void deleteDirectory(File dir) {

		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				File child = new File(dir, children[i]);
				if (child.isDirectory()) {
					deleteDirectory(child);
					child.delete();
				} else {
					child.delete();

				}
			}
			dir.delete();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<Lugares>lugares = null;

		// lugares = mibd.getLugares();
		// Cando se faga a parte de base de datos, teremos que ter un metodo que devolva a lista de lugares
		if (lugares != null) {
			adaptador = new ArrayAdapter<Lugares>(this, android.R.layout.simple_list_item_1,lugares);
			setListAdapter(adaptador);
		
			registerForContextMenu(getListView());
		}
		else
			Utiles.amosarMensaxe(R.string.string_listalugares_mensaxe_senLugares, this);
			
	}
}
