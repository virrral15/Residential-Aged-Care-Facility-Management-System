package FRMS;

public class DisplayEquipmentStatusCommand implements Command {
    private EquipmentManager equipmentManager;

    public DisplayEquipmentStatusCommand() {
        this.equipmentManager = EquipmentManager.getInstance();
    }

    @Override
    public void execute() {
        System.out.println("\n📋 Equipment Status Summary:");
        equipmentManager.displayEquipmentStatus();
    }
}
