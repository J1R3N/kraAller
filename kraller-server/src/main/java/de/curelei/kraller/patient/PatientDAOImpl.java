package de.curelei.kraller.patient;

import java.util.List;
import java.util.Map;

public class PatientDAOImpl implements PatientDAO {
    //private Datenbank patientDaten;
    private Map<String, Patient> datensaetze;

    public void PatientDAOImpl() {
        //patientDaten = new Datenbank("<<ORT DER SQL DATENBANK>>";
        //datensaetze = lese();
    }
    @Override
    public void save(Patient k) {

        datensaetze.put(k.getPatientRaum(), k);
        String sqlsatz = "SELECT "+ k.getId() +" FROM " + datensaetze.getClass() + "WHERE [...]";
        //patientDaten.schreibe(sqlsatz, true);
    }

    @Override
    public void update(Patient k) {
        for (int i = 0; i < datensaetze.size(); i++) {
            Patient zuUpdaten = datensaetze.get(Integer.toString(i));
            if (zuUpdaten.getId() == k.getId()) {
                datensaetze.put(String.valueOf(zuUpdaten.getId()), zuUpdaten);
                break;
            }
        }
        writeToDatabase();
    }



    @Override
    public void delete(int id) {
        for (Map.Entry<String, Patient> entry : datensaetze.entrySet()) {
            if (entry.getValue().getId() == id){
                datensaetze.remove(id);
            }
        }
    }

    @Override
    public Patient get(int id) {
        return datensaetze.get(id);
    }

    @Override
    public int getMaxId() {
        return 0;
    }


    private void writeToDatabase(){
    }
}
