package de.curelei.kraller.patient;

import java.util.List;

public interface PatientDAO {
    List<Patient> getAllPatients();

    Patient getPatientByID(int id);

    void savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(int id);
}