package de.curelei.kraller.patient;


import java.util.List;

public interface PatientDAO {
    List<Patient> getAll();

    Patient getByID(int id);

    List<Patient> findByName(String suchBegriff);

    void save(Patient patient);

    void update(int id, Patient updatedPatient);
    void delete(int id);

}
