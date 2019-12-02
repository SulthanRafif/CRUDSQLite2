package com.example.crudsqlite2.Model;

// deklarasi import package

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    /** deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     nama-nama kolom, nama database, dan versi dari database **/

    public static final String TABLE_NAME = "data_inventori";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nama_barang";
    public static final String COLUMN_MERK = "merk_barang";
    public static final String COLUMN_HARGA = "harga_barang";
    private static final String db_name ="inventori.db";
    private static final int db_version=1;

    // Perintah SQL untuk membuat tabel database baru

    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_MERK+ " varchar(50) not null, "
            + COLUMN_HARGA+ " varchar(50) not null);";


    public DBHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
        // Auto generated
    }

    // mengeksekusi perintah SQL diatas untuk membuat tabel
    // database baru

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(db_create);
    }

    // dijalankan apabila ingin mengupgrade database

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.w(DBHelper.class.getName(),"Upgrading database from version " + i + " to "
                + i1 + ", which will destroy all old data");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
