package tddmicroexercises.telemetrysystem;

public interface TelemetryConnectionService {
    public boolean getOnlineStatus();

    public void connect(String telemetryServerConnectionString);

    public void disconnect();
}
