/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import acoes.Apadrinamiento;
import acoes.Envio;
import acoes.Ninos;
import acoes.Socios;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class ListaApadrinamientos {
    private ArrayList<Apadrinamiento> lApadrinamiento;
    private Ninos ninio;
    private Socios socio;
    private Envio envio;
    
     public void ListaApadrinamiento(){
        lApadrinamiento = new ArrayList<>();
        lApadrinamiento.add(new Apadrinamiento((long) 0001, ninio, socio, envio));
    }

    public ArrayList<Apadrinamiento> getlApadrinamiento() {
        return lApadrinamiento;
    }

    public void setlApadrinamiento(ArrayList<Apadrinamiento> lApadrinamiento) {
        this.lApadrinamiento = lApadrinamiento;
    }
}
