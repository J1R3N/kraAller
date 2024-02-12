package de.curelei.kraller.allergene;

import java.util.List;
public class Allergen {

    private int id;
    private String unterGruppe;
    private String bezeichnung;

    private String getUntergruppe(){
        return unterGruppe;
    }
    private void setUntergruppe(String untergruppe){
        this.unterGruppe=untergruppe;
    }
    private String setBezeichnung(){

        return bezeichnung;
    }
    private void getBezeichnung(String bezeichnung){
        this.bezeichnung=bezeichnung;
    }

}
