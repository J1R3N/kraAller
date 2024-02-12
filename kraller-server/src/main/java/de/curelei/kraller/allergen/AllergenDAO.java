package de.curelei.kraller.allergen;

import java.util.List;

public interface AllergenDAO {
    List<Allergen> getAll();
    Allergen getById(int id);
    void add(Allergen allergen);
    void update(int id, Allergen updatedAllergen); //NUR DAS
    void delete(int id);
}