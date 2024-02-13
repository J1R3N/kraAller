package de.curelei.kraller;

import de.curelei.kraller.patient.Patient;

import java.util.List;

public interface KrallerService {
    Patient neu(Patient k) throws ValidierungsException;
    void aendern(Patient k);
    void loeschen(int patientNr);

    List<Patient> suchen(String suchBegriff);
    Patient holen(int patientNr);
}
