package de.curelei.kraller;

import de.curelei.kraller.allergen.Allergen;
import de.curelei.kraller.allergen.AllergenDAO;
import de.curelei.kraller.gericht.Gericht;
import de.curelei.kraller.gericht.GerichtDAO;
import de.curelei.kraller.patient.Patient;
import de.curelei.kraller.patient.PatientDAO;

import java.util.List;

public class KrallerServiceImpl implements KrallerService {
    private final PatientDAO patientDAO;
    private final GerichtDAO gerichtDAO;
    private final AllergenDAO allergenDAO;

    public KrallerServiceImpl(PatientDAO patientDAO, GerichtDAO gerichtDAO, AllergenDAO allergenDAO) {
        this.patientDAO = patientDAO;
        this.gerichtDAO = gerichtDAO;
        this.allergenDAO = allergenDAO;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    @Override
    public List<Gericht> getAllGerichte() {
        return gerichtDAO.getAllGerichte();
    }

    @Override
    public List<Allergen> getAllAllergene() {
        return allergenDAO.getAllAllergene();
    }

    @Override
    public void savePatient(Patient patient) {
        patientDAO.savePatient(patient);
    }

    @Override
    public void saveGericht(Gericht gericht) {
        gerichtDAO.saveGericht(gericht);
    }

    @Override
    public void saveAllergen(Allergen allergen) {
        allergenDAO.saveAllergen(allergen);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDAO.updatePatient(patient);
    }

    @Override
    public void updateGericht(Gericht gericht) {
        gerichtDAO.updateGericht(gericht);
    }

    @Override
    public void updateAllergen(Allergen allergen) {
        allergenDAO.updateAllergen(allergen);
    }

    @Override
    public void deletePatient(int id) {
        patientDAO.deletePatient(id);
    }

    @Override
    public void deleteGericht(int id) {
        gerichtDAO.deleteGericht(id);
    }

    @Override
    public void deleteAllergen(int id) {
        allergenDAO.deleteAllergen(id);
    }
}
