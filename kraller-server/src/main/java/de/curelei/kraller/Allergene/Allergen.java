package de.curelei.kraller.Allergene;

import java.util.List;
public class Allergen {

    private int id;
    private String unterGruppe;
    private String bezeichnung;
    private List<Allergen> allergene;


    List<Allergen> getAllAllergens(){
        return allergene;
    }
    Allergen getAllergenById(int id){
        this.id=id;
        return null;
    }
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
