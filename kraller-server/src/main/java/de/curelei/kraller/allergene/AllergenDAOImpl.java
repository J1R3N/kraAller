package de.curelei.kraller.allergene;

import java.util.ArrayList;
import java.util.List;

public class AllergenDAOImpl implements AllergenDAO {
    private List<Allergen> allergens = new ArrayList<>();

    @Override
    public List<Allergen> getAll() {
        return allergens;
    }

    @Override
    public Allergen getById(int id) {
        // Implementierung der Methode
        return null;
    }

    @Override
    public void add(Allergen allergen) {
        // Implementierung der Methode
    }

    @Override
    public void update(int id, Allergen updatedAllergen) {
        // Implementierung der Methode
    }

    @Override
    public void delete(int id) {
        // Implementierung der Methode
    }

    public boolean istIdInDatenbankVorhanden(int id){
        db.contains(id);
    }
}