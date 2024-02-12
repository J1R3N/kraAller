package de.curelei.kraller.patienten;

import de.curelei.kraller.ValidierungsException;

import java.util.List;

public interface PatientService {
    Patient neu(Patient k) throws ValidierungsException;
    void aendern(Patient k) throws ValidierungsException;
    void loeschen(String kundennummer);

    List<Patient> suchen(String suchBegriff);
    Patient holen(String kundennummer);
}
