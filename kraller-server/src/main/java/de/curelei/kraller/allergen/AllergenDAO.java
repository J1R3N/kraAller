package de.curelei.kraller.allergen;

import java.util.List;

public interface AllergenDAO {
    List<Allergen> getAllergenAll();

    List<Allergen> getAllAllergene();

    Allergen getAllergenById(int id);

    void saveAllergen(Allergen allergen);

    void addAllergen(Allergen allergen);

    void updateAllergen(Allergen allergen);

    void deleteAllergen(int id);
}