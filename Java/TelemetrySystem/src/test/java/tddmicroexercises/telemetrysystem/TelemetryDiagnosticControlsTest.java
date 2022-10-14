package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

import org.mockito.Mockito;


public class TelemetryDiagnosticControlsTest {

    @Test
    void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        String diagnosticInfo = "test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        TelemetryConnectionServiceImpl connectionService = mock(TelemetryConnectionServiceImpl.class);
        Mockito.when(connectionService.getOnlineStatus()).thenReturn(true);
        TelemetryTransmissionServiceImpl transmissionService = mock(TelemetryTransmissionServiceImpl.class);
        Mockito.when(transmissionService.receive()).thenReturn(diagnosticInfo);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(transmissionService, connectionService);
        telemetryDiagnosticControls.setDiagnosticInfo(diagnosticInfo);
        telemetryDiagnosticControls.checkTransmission();
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
        Assertions.assertEquals(diagnosticInfo, telemetryDiagnosticControls.getDiagnosticInfo());
    }

    @Test()
    void giving_unable_to_connect_exception() throws Exception {
        String diagnosticInfo = "test";
        TelemetryClient telemetryClient = mock(TelemetryClient.class);
        TelemetryConnectionServiceImpl connectionService = mock(TelemetryConnectionServiceImpl.class);
        TelemetryTransmissionServiceImpl transmissionService = mock(TelemetryTransmissionServiceImpl.class);
        Mockito.when(transmissionService.receive()).thenReturn(diagnosticInfo);
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(transmissionService, connectionService);
        Exception exception = Assertions.assertThrows(Exception.class, telemetryDiagnosticControls::checkTransmission);
        String expectedMessage = "Unable to connect.";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

}
