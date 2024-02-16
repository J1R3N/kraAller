package de.curelei.kraller.gericht;

import de.curelei.kraller.allergen.Allergen;
import de.curelei.kraller.basis.Beilage;
import de.curelei.kraller.basis.Zusatzstoff;

import java.util.List;

public class Gericht {
    private int id;
    private String bezeichnung;
    private String kategorie;
    private List<Allergen> allergen;
    private List<Zusatzstoff> zusatzstoff;
    private List<Beilage> beilagenZutaten;

    public Gericht() {
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichung) {
        this.bezeichnung = bezeichung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public List<Allergen> getAllergen() {
        return allergen;
    }

    public void setAllergen(List<Allergen> allergen) {
        this.allergen = allergen;
    }

    public List<Zusatzstoff> getZusatzstoff() {
        return zusatzstoff;
    }

    public void setZusatzstoff(List<Zusatzstoff> zusatzstoff) {
        this.zusatzstoff = zusatzstoff;
    }

    public List<Beilage> getBeilagenZutaten() {
        return beilagenZutaten;
    }

    public void setBeilagenZutaten(List<Beilage> beilagenZutaten) {
        this.beilagenZutaten = beilagenZutaten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
