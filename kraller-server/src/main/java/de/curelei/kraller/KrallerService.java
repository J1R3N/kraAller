package de.curelei.kraller;

import de.curelei.kraller.patient.Patient;

public interface KrallerService {
    Patient neu(Patient patient);

    void aendern(Patient patient);

    void loeschen(int patientNr);

    Patient holen(int patientNr);
}
