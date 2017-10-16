package br.edu.unileao.syteplus;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class  AtualizarDados extends Activity {

    private EditText nome;
    private EditText senha;
    private Button atualizar;
    private EditText email;
    private boolean teste;
    private String[] dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_dados);

        nome = (EditText) findViewById(R.id.Nome);
        senha= (EditText) findViewById(R.id.senha);
        atualizar = (Button) findViewById(R.id.enviarAtualizacao);
        email= (EditText) findViewById(R.id.email);
        UsuarioController usuarioController = new UsuarioController();

        usuarioController.renoDados(AtualizarDados.this);
        teste = nome.getText().toString().isEmpty();
        if (teste) {
            usuarioController.pegarDados(AtualizarDados.this);
        }
        nome.setText(dados[0].toString());
        senha.setText(dados[1].toString());
        teste = nome.getText().toString().isEmpty();
        if (teste) {
            Handler handler = new Handler();
            handler.postDelayed((Runnable) this, 10000);

            atualizar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }



    }

    private void atualizarDados(){
        Usuario usuario=new Usuario();
        usuario.setNome(nome.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setSenha(senha.getText().toString());
        UsuarioController usuarioController = new UsuarioController();
        usuario.atualizarDados();


    }


    }


