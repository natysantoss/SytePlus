package br.edu.unileao.syteplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by Naty Santos on 01/09/2017.
 */

public class TelaDenucia  extends AppCompatActivity {

    private Button Enviar;
    private EditText Ocorrencia;
    private Button Imagem;
    private Usuario usuario;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_tela_denuncia);
      Enviar=(Button) findViewById(R.id.enviar);
        Ocorrencia=(EditText) findViewById(R.id.ocorrencia);
        Imagem=(Button)  findViewById(R.id.imagem);

                }
}
