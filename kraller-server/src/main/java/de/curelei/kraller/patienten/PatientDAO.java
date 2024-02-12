package de.curelei.kraller.patienten;

import java.util.List;

public interface PatientDAO {
    int save(Patient k);
    void update(Patient k);
    void delete(int id);
    List<Patient> find(String suchbegriff);
    Patient get(String kundenummer);

    int getMaxId();
}
