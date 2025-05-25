package FRMS;

public class DisplayRoomStatusCommand implements Command {
    private RoomManager roomManager;

    public DisplayRoomStatusCommand() {
        this.roomManager = RoomManager.getInstance();
    }

    @Override
    public void execute() {
        System.out.println("\n📋 Room Status Summary:");
        roomManager.displayRoomStatus();
    }
}
