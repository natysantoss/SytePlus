package br.edu.unileao.syteplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class TelaDenucia  extends AppCompatActivity {


    private EditText Ocorrencia;
    private Button Enviar;
    private Usuario usuario;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_tela_denuncia);
      Enviar=(Button) findViewById(R.id.enviar);
        Ocorrencia=(EditText) findViewById(R.id.Ocorrencia);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TelaController telaController=new TelaController();
                telaController.ocorrencia(Ocorrencia.getText().toString());
            }
        });


                }
}
