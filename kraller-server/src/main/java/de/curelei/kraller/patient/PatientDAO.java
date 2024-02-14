package de.curelei.kraller.patient;


import java.util.List;

public interface PatientDAO {
    List<Patient> getAll();

    Patient getByID(int id);

    List<Patient> suchen(String suchBegriff);

    void add(Patient patient);

    void update(int id, Patient updatedPatient);
    void delete(int id);

}
