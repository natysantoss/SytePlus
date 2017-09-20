package br.edu.unileao.syteplus;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetSenha extends AppCompatActivity {
    private Button salvar;
    private EditText email;
    private Usuario usuario;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_senha);
        auth= ConfiguracaoFirebase.autenticarDados();
        email=(EditText) findViewById(R.id.emalReset);
        salvar=(Button) findViewById(R.id.envairReset);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario=new Usuario();
                usuario.setEmail(email.getText().toString());
                resetar();
            }
        });
    }

    private void resetar(){
        auth.sendPasswordResetEmail(usuario.getEmail()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(ResetSenha.this,"Um E-mail foi enviado para você. Confira sua caixa de entrada!",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(ResetSenha.this,MainActivity_Login.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(ResetSenha.this,"Erro ao enviar E-mail para reset de senha",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
