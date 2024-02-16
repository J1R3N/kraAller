package de.curelei.kraller.allergen;

import java.util.List;

public class AllergenServiceImpl implements AllergenService {
    private AllergenDAO allergenDAO = new AllergenDAOImpl();

    @Override
    public List<Allergen> hole() {
        return allergenDAO.getAllAllergene();
    }

    @Override
    public Allergen sucheMitId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Fehlerhafte ID");
        }
        return allergenDAO.getAllergenById(id);
    }

    //
    @Override
    public void neu(Allergen allergen) {
        if (allergen != null) {
            System.out.println("Neue Allergie angelegt");
            allergenDAO.addAllergen(allergen);
        }

    }

    @Override
    public void aendern(int id, Allergen updatedAllergen) {
        if (updatedAllergen != null) {
            System.out.println(updatedAllergen + " geändert");
            allergenDAO.updateAllergen(updatedAllergen);
        }
    }

    @Override
    public void loeschen(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Fehlerhafte ID");
        }
        allergenDAO.deleteAllergen(id);
    }
}