package de.curelei.kraller;

import java.util.List;

public interface iKrallerService {
    Patient neu(Patient k) throws ValidierungsException;
    void aendern(Patient k);
    void loeschen(String patientenNr);

    List<Patient> suchen(String suchBegriff);
    Patient holen(String patientNr);
}
