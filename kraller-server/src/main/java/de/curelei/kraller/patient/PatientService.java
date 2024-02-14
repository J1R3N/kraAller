package de.curelei.kraller.patient;

import de.curelei.kraller.ValidierungsException;

import java.util.List;

public interface PatientService {
    void neu(Patient k) throws ValidierungsException;
    void aendern(Patient k) throws ValidierungsException;
    void loeschen(int patientNr);

    List<Patient> suchen(String suchBegriff);

    List<Patient> getAll();
    Patient holen(int patientNr);
}
