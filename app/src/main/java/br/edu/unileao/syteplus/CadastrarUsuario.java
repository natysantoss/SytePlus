package br.edu.unileao.syteplus;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.support.annotation.NonNull;

public class CadastrarUsuario extends AppCompatActivity {

    private EditText Email;
    private EditText senha;
    private EditText confimarSenha;
    private Button salvar;
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);

        Email=(EditText) findViewById(R.id.emailUsuario);
        senha=(EditText) findViewById(R.id.senhaUsuario);
        confimarSenha=(EditText) findViewById(R.id.confirSenhaUsuario);
        salvar=(Button) findViewById(R.id.btSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(senha.getText().toString().equals(confimarSenha.getText().toString())){
                    usuario=new Usuario();
                    FirebaseAuth aut= FirebaseAuth.getInstance();
                    usuario.setEmail(Email.getText().toString());
                    usuario.setSenha(senha.getText().toString());



                    cadastraUsuario();
                }else{
                    Toast.makeText(CadastrarUsuario.this,"As senhas são divergentes",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void cadastraUsuario(){
        FirebaseAuth aut= FirebaseAuth.getInstance();
        aut.createUserWithEmailAndPassword(usuario.getEmail(),usuario.getSenha());



    }
}


