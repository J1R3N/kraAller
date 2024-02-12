package de.curelei.kraller.basis;

import de.curelei.kraller.allergen.Allergen;

import java.util.List;

public class Gericht {
    private String bezeichung;
    private String kategorie;
    private List<Allergen> allergen;
    private List<Zusatzstoff> zusatzstoff;
    private List<Beilage> beilagenZutaten;

    public String getBezeichung() {
        return bezeichung;
    }

    public void setBezeichung(String bezeichung) {
        this.bezeichung = bezeichung;
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
}
