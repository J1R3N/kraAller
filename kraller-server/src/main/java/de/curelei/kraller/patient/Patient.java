package de.curelei.kraller.patient;

import de.curelei.kraller.allergen.Allergen;

import java.util.List;

public class Patient {
    private int id;
    private String vname;
    private String nname;
    private int alter;
    private String raum;
    private List<Allergen> allergene;

    public Patient() {

    }

    public Patient(int id, String vname, String nname, int alter, String geschlecht, String raum) {
        this.id = id;
        this.vname = vname;
        this.nname = nname;
        this.alter = alter;
        this.raum = raum;
//        this.allergene = allergene;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getPatientRaum() {
        return raum;
    }

    public void setPatientRaum(String raum) {
        this.raum = raum;
    }

    public List<Allergen> getPatientAllergene() {
        return allergene;
    }

    public void setAllergene(List<Allergen> allergene) {
        this.allergene = allergene;
    }

}
