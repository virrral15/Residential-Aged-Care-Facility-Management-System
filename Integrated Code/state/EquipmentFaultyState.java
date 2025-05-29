package state;

public class EquipmentFaultyState implements EquipmentState {
    @Override
    public String getStatus() {
        return "Faulty";
    }
}
