package br.edu.unileao.syteplus;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Naty Santos on 18/10/2017.
 */

public class TelaModel {
    DatabaseReference conexão=ConfiguracaoFirebase.referenciaBancoFirebase();
    public void salavarNOBanco(Denuncia denuncia){
        conexão.child("ocorrencia").setValue(denuncia.de());
    }
}
