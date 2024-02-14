package de.curelei.kraller.patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    private List<Patient> patients;
    private int maxId;

    public PatientDAOImpl() {
        this.patients = new ArrayList<>();
        this.maxId = 0;
    }

    @Override
    public void save(Patient patient) {
        patient.setId(getNextId());
        patients.add(patient);
        maxId = Math.max(maxId, patient.getId());
    }


    @Override
    public void update(Patient updatedPatient) {
        for (Patient patient : patients) {
            if (patient.getId() == updatedPatient.getId()) {
                patient.setNname(updatedPatient.getNname());
                return;
            }
        }

        throw new RuntimeException("Patient not found for update with ID: " + updatedPatient.getId());
    }

    @Override
    public void delete(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }

    @Override
    public Patient get(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }

        throw new RuntimeException("Patient not found with ID: " + id);
    }

    @Override
    public List<Patient> search(String searchTerm) {
        List<Patient> searchResults = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getNname().contains(searchTerm)) {
                searchResults.add(patient);
            }
        }
        return searchResults;
    }

    @Override
    public int getMaxId() {
        return maxId;
    }

    private int getNextId() {
        return ++maxId;
    }
}
