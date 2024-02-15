package de.curelei.kraller.patient;

import java.util.List;

public interface PatientDAO {
    void save(Patient k);

    void update(Patient k);

    void delete(int id);

    Patient get(int id);

    List<Patient> search();

    int getMaxId();

}
