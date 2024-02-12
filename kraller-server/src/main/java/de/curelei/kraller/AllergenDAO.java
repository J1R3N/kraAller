package de.curelei.kraller;

import java.util.List;

public interface AllergenDAO {
    List<Allergen> getAllAllergens();
    Allergen getAllergenById(int id);
    void addAllergen(Allergen allergen);
    void updateAllergen(int id, Allergen updatedAllergen);
    void deleteAllergen(int id);
}