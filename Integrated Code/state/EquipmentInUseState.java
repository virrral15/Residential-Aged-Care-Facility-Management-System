package state;

public class EquipmentInUseState implements EquipmentState {
    @Override
    public String getStatus() {
        return "In Use";
    }
}
