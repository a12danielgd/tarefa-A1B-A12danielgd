package com.platega.angel.diarioviaxe.almacenamento;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public static final String NOME_BD = "diarioviaxe";


    public SQLiteDatabase bd = null;

    public BaseDatos(Context context, int versionBD) {
        super(context, NOME_BD, null, versionBD);
    }


    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public long engadirAula(Lugares lugar){
        ContentValues valores = new ContentValues();
        valores.put("nome", lugar.getNome());
        valores.put("descripcion", lugar.getDescripcion());
        long id = bd.insert("LUGARES",null,valores);

        return id;

    }

}
