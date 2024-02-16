/*
package de.curelei.kraller;

import de.curelei.kraller.patient.Patient;
import de.curelei.kraller.patient.PatientDAO;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KraAllerTest {

    private PatientDAO patientDaoMock;
    private KrallerServiceImpl krallerService;

    @BeforeEach
    public void setUp() {
        // Create a mock for the PatientDAO interface
        patientDaoMock = EasyMock.createMock(PatientDAO.class);

        // Create an instance of KrallerServiceImpl with the mock
        krallerService = new KrallerServiceImpl(patientDaoMock);
    }

    @Test
    public void testNeu() {
        // Setup: Define the expected behavior for the mock
        Patient patient = new Patient();
        patientDaoMock.save(EasyMock.isA(Patient.class));
        EasyMock.expectLastCall();


        EasyMock.replay(patientDaoMock);

        // Exercise: Call the method under test
        Patient result = krallerService.neu(patient);

        // Verify: Check that the expected method was called on the mock
        EasyMock.verify(patientDaoMock);

        // Assert: Check the result
        Assertions.assertEquals(patient, result);
    }

    @Test
    public void testHolen() {
        int patientNr = 1;
        Patient expectedPatient = new Patient();
        EasyMock.expect(patientDaoMock.get(patientNr)).andReturn(expectedPatient);
        EasyMock.replay(patientDaoMock);


        Patient result = krallerService.holen(patientNr);

        assertEquals(expectedPatient, result);
        EasyMock.verify(patientDaoMock);
    }

}
*/
