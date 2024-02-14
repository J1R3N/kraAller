package de.curelei.kraller.patient;

import de.curelei.kraller.ValidierungsException;

import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final PatientDAOImpl patientDAO = new PatientDAOImpl();


    @Override
    public void neu(Patient k) throws ValidierungsException {
        if (k == null) {
            throw new ValidierungsException("Fehler beim Anlegen des Patienten");
        }
        patientDAO.add(k);
    }

    @Override
    public void aendern(Patient k) throws ValidierungsException {
        if (k == null) {
            throw new ValidierungsException("Fehler beim Ändern");
        }
        patientDAO.update(k.getId(), k);
    }

    @Override
    public void loeschen(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Fehlerhafte ID");
        }
        patientDAO.delete(id);
    }

    @Override
    public List<Patient> suchen(String suchBegriff) {
        if (suchBegriff == null) {
            throw new IllegalArgumentException("Suchbegriff darf nicht leer sein");
        }
        return patientDAO.suchen(suchBegriff);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }

    @Override
    public Patient holen(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Fehlerhafte ID");
        }
        return patientDAO.getByID(id);
    }
}
