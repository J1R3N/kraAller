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
    public Patient neu(Patient k) {
        patientDao.save(k);
        return k;
    }


    private String getNachsteId() {
// TODO
        return null;
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
        return patientDao.get(patientNr);
    }
}
