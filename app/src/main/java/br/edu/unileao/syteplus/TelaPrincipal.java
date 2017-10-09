package br.edu.unileao.syteplus;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class TelaPrincipal extends AppCompatActivity {
    private EditText denuncia;
    private Button sair;
    private Button deletarConta;
    private FirebaseAuth sairSistema;
    private Button telaAtd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        denuncia=(EditText) findViewById(R.id.denuncia);
        sair=(Button) findViewById(R.id.sair);
        deletarConta=(Button) findViewById(R.id.apagarConta);
        telaAtd=(Button) findViewById(R.id.Atualizartela);
        sairSistema= ConfiguracaoFirebase.autenticarDados();
        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sairSistema.signOut();
                Intent intent= new Intent(TelaPrincipal.this,MainActivity_Login.class);
                startActivity(intent);
                finish();
            }
        });
        deletarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apagar();
            }
        });

        telaAtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TelaPrincipal.this,AtualizarDados.class);
                startActivity(intent);
            }
        });
    }

    public void apagar(){

        Usuario us=new Usuario();
        us.deletarConta();
        sairSistema.signOut();
        Intent intent= new Intent(TelaPrincipal.this,MainActivity_Login.class);
        startActivity(intent);
        finish();
    }

}

