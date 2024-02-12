package de.curelei.kraller;

import de.curelei.kraller.Patienten.Patient;

import java.util.List;

public interface KrallerServiceInterface {
    Patient neu(Patient k) throws ValidierungsException;
    void aendern(Patient k);
    void loeschen(String patientenNr);

    List<Patient> suchen(String suchBegriff);
    Patient holen(String patientNr);
}
