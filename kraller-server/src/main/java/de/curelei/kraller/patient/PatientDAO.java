package de.curelei.kraller.patient;

public interface PatientDAO {
    void save(Patient k);
    void update(Patient k);
    void delete(int id);
    Patient get(int id);

    int getMaxId();
}
