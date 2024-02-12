package de.curelei.kraller.allergene;

import java.util.List;

public interface AllergenService {
    List<Allergen> hole();
    Allergen sucheMitId(int id);
    void neu(Allergen allergen);
    void aendern(int id, Allergen updatedAllergen);
    void loeschen(int id);
}
