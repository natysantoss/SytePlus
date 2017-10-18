package br.edu.unileao.syteplus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Naty Santos on 18/10/2017.
 */

class Denuncia {
    private String denuncia;


    public String getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(String denuncia) {
        this.denuncia = denuncia;
    }

    public Map<String,Object> de(){
        HashMap<String,Object> salvar=new HashMap<>();
        salvar.put("denuncia",getDenuncia());
        return salvar;
    }
}

