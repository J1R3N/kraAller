package de.curelei.kraller.gui;

import javafx.scene.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class KrallerAppTest {

    FxRobot robot = new FxRobot();

    @BeforeEach
    public void setUp() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(KrallerApp.class);
    }

    @AfterEach
    public void tearDown() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    @Test
    void testVorlage() {
        int ergebnis = 2 + 3;
        assertEquals(5, ergebnis);
    }


    @Test
    void testOpenWeiteresFenster() {
        robot.clickOn("#oeffneKategorieFenster");
        assertNotNull(lookupNode("#oeffneAllergeneFenster"));
    }

    @Test
    void testOpenKategorieFenster() {
        robot.clickOn("#oeffneWeiteresFenster");
        assertNotNull(lookupNode("#oeffneAllergeneFenster"));
    }

    private <T extends Node> T lookupNode(String query) {
        return robot.lookup(query).query();
    }
}
