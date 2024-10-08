package de.curelei.kraller.allergen;

public class Allergen {

    private int id;
    private String unterGruppe;
    private String bezeichnung;

    public Allergen() {
    }

    public Allergen(int id, String unterGruppe, String bezeichnung) {
        this.id = id;
        this.unterGruppe = unterGruppe;
        this.bezeichnung = bezeichnung;
    }

    public String getUntergruppe() {
        return unterGruppe;
    }

    public void setUntergruppe(String untergruppe) {
        this.unterGruppe = untergruppe;
    }

    public String getBezeichnung() {

        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
