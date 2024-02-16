package de.curelei.kraller.gericht;

import java.util.List;

public interface GerichtDAO {
    List<Gericht> getAllGerichte();

    Gericht getGerichtById(int id);

    void saveGericht(Gericht gericht);

    void updateGericht(Gericht gericht);

    void deleteGericht(int id);
}