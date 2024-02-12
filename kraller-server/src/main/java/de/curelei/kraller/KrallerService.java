package de.curelei.kraller;

import de.curelei.kraller.patienten.Patient;

import java.util.List;

public interface KrallerService {
    Patient neu(Patient k) throws ValidierungsException;
    void aendern(Patient k);
    void loeschen(String patientenNr);

    List<Patient> suchen(String suchBegriff);
    Patient holen(String patientNr);
}
