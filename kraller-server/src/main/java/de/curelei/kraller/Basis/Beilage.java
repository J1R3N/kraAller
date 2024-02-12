package de.curelei.kraller.Basis;

import de.curelei.kraller.Allergene.Allergen;
import java.util.List;
public class Beilage {
    private String bezeichnung;
    private List<Allergen> allergen;
    private List<Zusatzstoffe> zusatzstoffZutaten;


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

    public List<Zusatzstoffe> getZusatzstoffZutaten() {
        return zusatzstoffZutaten;
    }

    public void setZusatzstoffZutaten(List<Zusatzstoffe> zusatzstoffZutaten) {
        this.zusatzstoffZutaten = zusatzstoffZutaten;
    }
}
