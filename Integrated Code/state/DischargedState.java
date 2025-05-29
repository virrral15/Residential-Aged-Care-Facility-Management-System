package state;

public class DischargedState implements ResidentState {
    @Override
    public String getStatus() {
        return "Discharged";
    }
}
