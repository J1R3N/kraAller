package de.curelei.kraller;

import de.curelei.kraller.Patienten.Patient;
import de.curelei.kraller.Patienten.PatientDAO;
import de.curelei.kraller.Patienten.PatientDAOImpl;

import java.util.List;

public class KrallerServiceImpl implements KrallerServiceInterface {
    private static KrallerServiceInterface instance;

    private final PatientDAO kundenDao;

    // einfache Variante ohne Sync.
    public static KrallerServiceInterface getInstance() {
        if (instance == null) {
            instance = new KrallerServiceImpl();
        }
        return instance;
    }

    private KrallerServiceImpl() {
        System.out.println("Erzeuge Kunden-Service");
        kundenDao = new PatientDAOImpl();
    }

    @Override
    public Patient neu(Patient k) throws ValidierungsException {
        validiereKunde(k);
        int neueId = kundenDao.save(k);
        k.setId(neueId);
        return k;
    }

    private void validiereKunde(Patient k) throws ValidierungsException {
        if (k.getNname() == null || k.getNname().isBlank()) {
            throw new ValidierungsException("Namchname ist ein Pflichtfeld.");
        }
    }

    private String getNachsteId() {
        int id = kundenDao.getMaxId() + 1;
        return String.format("K%05d", id);
    }

    @Override
    public void aendern(Patient k) {

    }

    @Override
    public void loeschen(String kundennummer) {

    }

    @Override
    public List<Patient> suchen(String suchbegriff) {
        return null;
    }

    @Override
    public Patient holen(String kundennummer) {
        return kundenDao.get(kundennummer);
    }
}
