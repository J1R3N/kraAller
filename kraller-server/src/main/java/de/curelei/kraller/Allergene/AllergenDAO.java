package de.curelei.kraller.Allergene;

import java.util.List;

public interface AllergenDAO {
    List<Allergen> getAllAllergens();
    Allergen getAllergenById(int id);
    void addAllergen(Allergen allergen);
    void updateAllergen(int id, Allergen updatedAllergen); //NUR DAS
    void deleteAllergen(int id);
}