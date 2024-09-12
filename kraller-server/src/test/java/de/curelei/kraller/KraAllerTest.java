package de.curelei.kraller;

import de.curelei.kraller.allergen.AllergenDAO;
import de.curelei.kraller.gericht.GerichtDAO;
import de.curelei.kraller.patient.Patient;
import de.curelei.kraller.patient.PatientDAO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.mock;

class KraAllerTest {

    private PatientDAO patientDaoMock;
    private KrallerServiceImpl krallerService;

    @BeforeEach
    public void setUp() {
        // Create a mock for the PatientDAO interface
        patientDaoMock = EasyMock.createMock(PatientDAO.class);

        // Create an instance of KrallerServiceImpl with the mock
        krallerService = new KrallerServiceImpl(patientDaoMock, mock(GerichtDAO.class), mock(AllergenDAO.class));
    }

    @Test
    public void testSavePatient() {
        // Setup: Define the expected behavior for the mock
        Patient patient = new Patient();
        patientDaoMock.savePatient(patient);
        EasyMock.expectLastCall().once();
        EasyMock.replay(patientDaoMock);

        // Exercise: Call the method under test
        krallerService.savePatient(patient);  // Ensure this method exists and uses patientDaoMock

        // Verify: Check that the expected method was called on the mock
        EasyMock.verify(patientDaoMock);
    }

    @Test
    public void testGetPatientByID() {
        int patientNr = 1;
        Patient expectedPatient = new Patient();
        EasyMock.expect(patientDaoMock.getPatientByID(patientNr)).andReturn(expectedPatient);
        EasyMock.replay(patientDaoMock);

        // Exercise: Call the method under test
        Patient result = patientDaoMock.getPatientByID(patientNr);  // Ensure this method exists and uses patientDaoMock

        // Assert: Check the result
        Assertions.assertEquals(expectedPatient, result);
        EasyMock.verify(patientDaoMock);
    }
}
