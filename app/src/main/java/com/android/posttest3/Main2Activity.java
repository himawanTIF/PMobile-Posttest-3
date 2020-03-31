package com.android.posttest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView nim_anda, nama_anda, slot_anda, kelas_anda, hobi_anda;
    String get_input_nim, get_input_nama, get_input_slot, get_kelas, get_hobi;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button)findViewById(R.id.btn_submit);
        nim_anda = (TextView)findViewById(R.id.isi_nim);
        nama_anda = (TextView)findViewById(R.id.isi_nama);
        slot_anda = (TextView)findViewById(R.id.isi_slot);
        kelas_anda = (TextView)findViewById(R.id.isi_kelas);
        hobi_anda = (TextView)findViewById(R.id.isi_hobi);

        Bundle b = getIntent().getExtras();
        get_input_nim = b.getString("parse_input_nim");
        get_input_nama = b.getString("parse_input_nama");
        get_input_slot = b.getString("parse_input_slot");
        get_kelas = b.getString("parse_kelas");
        get_hobi = b.getString("parse_hobi");

        nim_anda.setText("NIM : "+get_input_nim);
        nama_anda.setText("Nama : "+get_input_nama);
        slot_anda.setText("Slot : "+get_input_slot);
        kelas_anda.setText("Kelas : "+get_kelas);
        hobi_anda.setText("Hobi : "+get_hobi);
    }
    public void onClick(View v){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
