package de.curelei.kraller;

import de.curelei.kraller.allergen.Allergen;
import de.curelei.kraller.gericht.Gericht;
import de.curelei.kraller.patient.Patient;

import java.util.List;

public interface KrallerService {
    List<Patient> getAllPatients();

    List<de.curelei.kraller.gericht.Gericht> getAllGerichte();

    List<Allergen> getAllAllergene();

    void savePatient(Patient patient);

    void saveGericht(Gericht gericht);

    void saveAllergen(Allergen allergen);

    void updatePatient(Patient patient);

    void updateGericht(Gericht gericht);

    void updateAllergen(Allergen allergen);

    void deletePatient(int id);

    void deleteGericht(int id);

    void deleteAllergen(int id);
}
