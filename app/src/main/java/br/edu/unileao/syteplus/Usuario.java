package br.edu.unileao.syteplus;

import android.provider.ContactsContract;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String Id;
    private String nome;
    private String senha;
    private String email;
    private FirebaseAuth aut=ConfiguracaoFirebase.autenticarDados();

    public Usuario() {
    }

    public void salvarBD(){
        DatabaseReference dados=ConfiguracaoFirebase.referenciaBancoFirebase();
        dados.child("user").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude
    public Map<String,Object> toMap(){
        HashMap<String,Object> dadosSalvar=new HashMap<>();
        dadosSalvar.put("nome",getNome());
        dadosSalvar.put("senha",getSenha());
        dadosSalvar.put("email",getEmail());
        return dadosSalvar;
    }

    public void atualizarDados(){
        DatabaseReference atualizar=ConfiguracaoFirebase.referenciaBancoFirebase();

        FirebaseUser user=aut.getCurrentUser();
        Map<String,Object> up=new HashMap<>();
        up.put("nome",getNome());
        up.put("email",getEmail());
        atualizar.child("user").child(String.valueOf(user.getUid().toString())).updateChildren(up);

    }

    public void deletarConta(){
        DatabaseReference remover=ConfiguracaoFirebase.referenciaBancoFirebase();
        FirebaseUser user=aut.getCurrentUser();
        remover.child("user").child(user.getUid().toString()).removeValue();
        user.delete();

    }

public String getId()  {return Id;}
    public void  setId (String Id) {this.Id = Id;}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {return email; }
    public void setEmail(String Email) {this.email=Email;}


}



