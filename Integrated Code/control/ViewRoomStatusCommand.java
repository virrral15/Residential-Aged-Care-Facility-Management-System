package control;

import manager.RoomManager;

public class ViewRoomStatusCommand implements Command {
    @Override
    public void execute() {
        System.out.println("--- View Room Status ---");
        RoomManager.getInstance().displayRoomStatus();
    }
}
