package com.example.crudsqlite2.Model;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.crudsqlite2.R;

public class CreateData extends Activity implements OnClickListener {

    // inisialisasi elemen-elemen pada layout

    private Button buttonSubmit;
    private EditText edNama;
    private EditText edMerk;
    private EditText edHarga;

    // inisialisasi kontroller/Data Source

    private DBDataSource dataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_data);

        buttonSubmit = (Button) findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(this);
        edNama = (EditText) findViewById(R.id.nama_barang);
        edHarga = (EditText) findViewById(R.id.harga_barang);
        edMerk = (EditText) findViewById(R.id.merk_barang);

        // instansiasi kelas DBDataSource

        dataSource = new DBDataSource(this);

        // membuat sambungan baru ke database
        dataSource.open();
    }

    // Ketika tombol submit diklik

    @Override
    public void onClick(View view) {
        // Inisialisasi data barang

        String nama = null;
        String merk = null;
        String harga = null;
        @SuppressWarnings("unused")

        // inisialisasi barang baru (masih kosong)

                Barang barang = null;

        if(edNama.getText() != null && edMerk.getText() != null && edHarga.getText() != null){
            /* jika field nama, merk, dan harga tidak kosong maka
             * masukkan ke dalam data barang */

            nama = edNama.getText().toString();
            merk = edMerk.getText().toString();
            harga = edHarga.getText().toString();
        }

        switch (view.getId()){
            case R.id.button_submit:

                // insert data barang baru
                barang = dataSource.createBarang(nama, merk, harga);

                // konfirmasi kesuksesan

                Toast.makeText(this, "masuk Barang\n" +
                                "nama" + barang.getNama_barang() +
                                "merk" + barang.getMerk_barang() +
                                "harga" + barang.getHarga_barang(),
                        Toast.LENGTH_LONG).show();
                break;
        }

    }
}
