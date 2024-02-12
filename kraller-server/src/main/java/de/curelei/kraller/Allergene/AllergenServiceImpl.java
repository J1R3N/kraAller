package de.curelei.kraller.Allergene;

import java.util.List;

public class AllergenServiceImpl implements AllergenService {
    private AllergenDAO allergenDAO = new AllergenDAOImpl();

    @Override
    public List<Allergen> getAllAllergens() {
        return allergenDAO.getAllAllergens();
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