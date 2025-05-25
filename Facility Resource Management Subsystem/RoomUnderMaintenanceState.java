package FRMS;

public class RoomUnderMaintenanceState implements RoomState {
    @Override
    public String getStatus() {
        return "Under Maintenance";
    }
}
