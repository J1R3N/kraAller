package de.curelei.kraller.patient;

import java.util.List;

public interface PatientDAO {

    void save(Patient patient);

    void update(Patient patient);

    void delete(int id);

    Patient get(int id);

    List<Patient> search();

    int getMaxId();
}
