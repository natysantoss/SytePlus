package br.edu.unileao.syteplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Naty Santos on 23/09/2017.
 */

public class TeladeNumerosDeEmergencia extends AppCompatActivity {

    private EditText Polícia191;
    private EditText Bombeiro193;
    private EditText DisqueDenúncia181;
    private EditText Samu192;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_numeros_de_emergencia);
        Polícia191=(EditText) findViewById(R.id.Polícia191);
        Polícia191.setText("191");
        Bombeiro193=(EditText) findViewById(R.id.Bomdeiro193);
        Bombeiro193.setText("193");
        DisqueDenúncia181=(EditText) findViewById(R.id.DisqueDenúcia181);
        DisqueDenúncia181.setText("181");
        Samu192=(EditText) findViewById(R.id.Samu191);
        Samu192.setText("191");

    }
}
