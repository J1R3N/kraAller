package de.curelei.kraller;

import de.curelei.kraller.patient.Patient;
import de.curelei.kraller.patient.PatientDAO;

public class KrallerServiceImpl implements KrallerService {
    private final PatientDAO patientDao;

    // Constructor with PatientDAO parameter
    public KrallerServiceImpl(PatientDAO patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Patient neu(Patient patient) {
        try {
            patientDao.save(patient);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Patient konnte nicht gespiechert werden.", e);
        }
        return patient;
    }

    private String getNachsteId() {
        int id = patientDao.getMaxId() + 1;
        return String.format("P%05d", id);
    }

    @Override
    public void aendern(Patient patient) {
        try {
            patientDao.update(patient);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Patient Änderung konnten nicht übernommen werden.", e);
        }
    }

    @Override
    public void loeschen(int patientNr) {
        try {
            patientDao.delete(patientNr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Patient konnte nicht entfernt werden.", e);
        }
    }

    @Override
    public Patient holen(int patientNr) {
        try {
            return patientDao.get(patientNr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Patient konnte nicht gefunden werden.", e);
        }
    }
}
