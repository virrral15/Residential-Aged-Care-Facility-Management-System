package FRMS;

public class EquipmentOutOfOrderState implements EquipmentState {
    @Override
    public String getStatus() {
        return "Out of Order";
    }
}
