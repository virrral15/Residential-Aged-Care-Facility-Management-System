package facility_resource_management;

public class EquipmentOutOfOrderState implements EquipmentState {
    @Override
    public String getStatus() {
        return "Out of Order";
    }
}
