package br.edu.unileao.syteplus;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Naty Santos on 08/09/2017.
 */

class ConfiguracaoFirebase {
    private static DatabaseReference referenceBanco;
private static FirebaseAuth autenticar;

public static DatabaseReference referenciaBancoFirebase() {

if (referenceBanco==null){
    return referenceBanco = FirebaseDatabase.getInstance().getReference();

}
      return  referenceBanco;
}

public static  FirebaseAuth autenticarDados(){
    if (autenticar==null){
        return autenticar = FirebaseAuth.getInstance();


    }
    return autenticar;
}



}