package com.android.posttest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText input_nim, input_nama, input_slot;
    RadioGroup radio_group;
    RadioButton radioA, radioB, radioC, radioD, radioE;
    CheckBox hobi_futsal, hobi_badminton, hobi_basket, hobi_volley, hobi_esports;
    Button button;
    String var_input_nim, var_input_nama, var_input_slot;
    String terpilih, terpilih1 = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_nim = (EditText)findViewById(R.id.input_nim);
        input_nama = (EditText)findViewById(R.id.input_nama);
        input_slot = (EditText)findViewById(R.id.input_slot);
        radio_group = (RadioGroup)findViewById(R.id.radio_group);
        radioA = (RadioButton)findViewById(R.id.radioA);
        radioB = (RadioButton)findViewById(R.id.radioB);
        radioC = (RadioButton)findViewById(R.id.radioC);
        radioD = (RadioButton)findViewById(R.id.radioD);
        radioE = (RadioButton)findViewById(R.id.radioE);
        hobi_futsal = (CheckBox)findViewById(R.id.hobi_futsal);
        hobi_badminton = (CheckBox)findViewById(R.id.hobi_badminton);
        hobi_volley = (CheckBox)findViewById(R.id.hobi_volley);
        hobi_basket = (CheckBox)findViewById(R.id.hobi_basket);
        hobi_esports = (CheckBox)findViewById(R.id.hobi_esports);
        button = (Button)findViewById(R.id.btn_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var_input_nim = input_nim.getText().toString();
                var_input_nama = input_nama.getText().toString();
                var_input_slot = input_slot.getText().toString();

                        switch (radio_group.getCheckedRadioButtonId()){
                            case R.id.radioA :
                                terpilih = radioA.getText().toString();
                                break;
                            case R.id.radioB :
                                terpilih = radioB.getText().toString();
                                break;
                            case R.id.radioC :
                                terpilih = radioC.getText().toString();
                                break;
                            case R.id.radioD :
                                terpilih = radioD.getText().toString();
                                break;
                            case R.id.radioE :
                                terpilih = radioE.getText().toString();
                                break;
                            default:
                                throw new IllegalStateException("Nggak Punya Kelas ?" + radio_group.getCheckedRadioButtonId());
                        }

                if(hobi_futsal.isChecked()){
                    terpilih1 = terpilih1 + "Futsal \n";
                }
                if (hobi_badminton.isChecked()) {
                    terpilih1 = terpilih1 + "Badminton \n";
                }
                if (hobi_basket.isChecked()){
                    terpilih1 = terpilih1 + "Basket \n";
                }
                if (hobi_volley.isChecked()){
                    terpilih1 = terpilih1 + "Volley \n";
                }
                if (hobi_esports.isChecked()){
                    terpilih1 = terpilih1 + "E-Sports \n";
                }

                Intent i = null;
                i = new Intent(MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();

                b.putString("parse_input_nim", var_input_nim);
                b.putString("parse_input_nama", var_input_nama);
                b.putString("parse_input_slot", var_input_slot);
                b.putString("parse_kelas", terpilih);
                b.putString("parse_hobi", terpilih1);

                i.putExtras(b);
                startActivity(i);
            }
        });

    }
}
