package tddmicroexercises.telemetrysystem;

public class TelemetryConnectionServiceImpl implements TelemetryConnectionService {

    private TelemetryClient telemetryClient;

    public TelemetryConnectionServiceImpl(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    public boolean getOnlineStatus() {
        return telemetryClient.getOnlineStatus();
    }

    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = telemetryClient.getConnectionEventsSimulator().nextInt(10) <= 8;
        telemetryClient.setOnlineStatus(success);
    }

    public void disconnect() {
        telemetryClient.setOnlineStatus(false);
    }
}
