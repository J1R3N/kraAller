package de.curelei.kraller.basis;

import de.curelei.kraller.allergen.Allergen;
import java.util.List;
public class Beilage {
    private String bezeichnung;
    private List<Allergen> allergen;
    private List<Zusatzstoff> zusatzstoffZutaten;


    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public List<Allergen> getAllergen() {
        return allergen;
    }

    public void setAllergen(List<Allergen> allergen) {
        this.allergen = allergen;
    }

    public List<Zusatzstoff> getZusatzstoffZutaten() {
        return zusatzstoffZutaten;
    }

    public void setZusatzstoffZutaten(List<Zusatzstoff> zusatzstoffZutaten) {
        this.zusatzstoffZutaten = zusatzstoffZutaten;
    }
}
