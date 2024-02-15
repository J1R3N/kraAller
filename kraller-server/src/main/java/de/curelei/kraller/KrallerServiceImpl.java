package de.curelei.kraller;

import de.curelei.kraller.patient.Patient;
import de.curelei.kraller.patient.PatientDAO;
import de.curelei.kraller.patient.PatientDAOImpl;

import java.util.List;

public class KrallerServiceImpl implements KrallerService {
    private static KrallerService instance;

    private final PatientDAO patientDao;

    // einfache Variante ohne Sync.
    public static KrallerService getInstance() {
        if (instance == null) {
            instance = new KrallerServiceImpl();
        }
        return instance;
    }

    private KrallerServiceImpl() {
        System.out.println("Erzeuge Kunden-Service");
        patientDao = new PatientDAOImpl();
    }

    @Override
    public Patient neu(Patient k) throws ValidierungsException {
        validiereKunde(k);
        patientDao.save(k);
        return k;
    }

    private void validiereKunde(Patient k) throws ValidierungsException {
        if (k.getNname() == null || k.getNname().isBlank()) {
            throw new ValidierungsException("Namchname ist ein Pflichtfeld.");
        }
    }

    private String getNachsteId() {
// TODO
        return null;
    }

    @Override
    public void aendern(Patient k) {

    }

    @Override
    public void loeschen(int patientNr) {

    }


    @Override
    public List<Patient> suchen(String suchbegriff) {
        return null;
    }

    @Override
    public Patient holen(int patientNr) {
        return patientDao.getByID(patientNr);
    }

}

