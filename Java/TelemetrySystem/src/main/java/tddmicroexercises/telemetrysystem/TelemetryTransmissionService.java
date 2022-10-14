package tddmicroexercises.telemetrysystem;

public interface TelemetryTransmissionService {

    public void send(String message);

    public String receive();
}
