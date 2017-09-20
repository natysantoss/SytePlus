package br.edu.unileao.syteplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity_Login extends AppCompatActivity {

    private TextView cadastrar;
    private TextView resetSenha;
    private Button logar;
    private EditText email;
    private EditText senha;
    private FirebaseAuth aut;
    private FirebaseAuth.AuthStateListener verificarUsuario;
    private Usuario usuario;
    private String TAG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__login);

        email=(EditText) findViewById(R.id.emialLogin);
        senha=(EditText) findViewById(R.id.senhaLogin);
        logar=(Button) findViewById(R.id.logarSistema);
        aut= (FirebaseAuth) ConfiguracaoFirebase.autenticarDados();
        cadastrar=(TextView) findViewById(R.id.cadatrarUusario);
        resetSenha=(TextView) findViewById(R.id.recuperarSenha);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario=new Usuario();
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                autenticarUsuario();
            }


        });
        resetSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity_Login.this,ResetSenha.class);
                startActivity(intent);
            }
        });

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity_Login.this,CadastrarUsuario.class);
                startActivity(intent);
            }
        });

        verificarUsuario = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }

            }
        };
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = aut.getCurrentUser();
        aut.addAuthStateListener(verificarUsuario);
        logar(currentUser);
    }

    @Override
    public void onStop(){
        super.onStop();
        if (verificarUsuario != null) {
            aut.removeAuthStateListener(verificarUsuario);
        }
    }

    private void autenticarUsuario(){
        aut.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser us=aut.getCurrentUser();
                    logar(us);
                    Toast.makeText(MainActivity_Login.this,"Seja bem vindo",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(MainActivity_Login.this,"Erro ao logar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void logar(FirebaseUser user){
        if(user!=null){
            Intent intent= new Intent(MainActivity_Login.this,TelaPrincipal.class);
            startActivity(intent);
        }


    }
}



