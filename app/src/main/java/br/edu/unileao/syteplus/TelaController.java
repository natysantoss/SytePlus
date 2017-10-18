package br.edu.unileao.syteplus;

/**
 * Created by Naty Santos on 16/10/2017.
 */

class TelaController {

    public void ocorrencia(String valor) {
        Denuncia denuncia=new Denuncia();
        denuncia.setDenuncia(valor);
        TelaModel telaModel=new TelaModel();
        telaModel.salavarNOBanco(denuncia);
    }

}

