package de.curelei.kraller.Allergene;

import java.util.List;

public class AllergenServiceImpl implements AllergenService {
    private AllergenDAO allergenDAO = new AllergenDAOImpl();

    @Override
    public List<Allergen> hole() {
        return allergenDAO.getAllAllergens();
    }

    @Override
    public Allergen sucheMitId(int id) {
        // Implementierung der Methode
        return null;
    }

    @Override
    public void neu(Allergen allergen) {
        // Implementierung der Methode
    }

    @Override
    public void aendern(int id, Allergen updatedAllergen) {
        // Implementierung der Methode
    }

    @Override
    public void loeschen(int id) {
        // Implementierung der Methode
    }
}