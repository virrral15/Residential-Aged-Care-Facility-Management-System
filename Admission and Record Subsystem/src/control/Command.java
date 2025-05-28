package control;

import manager.AdmissionManager;

public interface Command {
	 CommandResponse execute(AdmissionManager manager, String[] args);

}
