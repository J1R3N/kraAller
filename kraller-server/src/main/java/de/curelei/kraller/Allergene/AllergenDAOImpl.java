package de.curelei.kraller.Allergene;

import java.util.ArrayList;
import java.util.List;

public class AllergenDAOImpl implements AllergenDAO {
    private List<Allergen> allergens = new ArrayList<>();

    @Override
    public List<Allergen> getAllAllergens() {
        return allergens;
    }

    @Override
    public Allergen getAllergenById(int id) {
        // Implementierung der Methode
        return null;
    }

    @Override
    public void addAllergen(Allergen allergen) {
        // Implementierung der Methode
    }

    @Override
    public void updateAllergen(int id, Allergen updatedAllergen) {
        // Implementierung der Methode
    }

    @Override
    public void deleteAllergen(int id) {
        // Implementierung der Methode
    }
}