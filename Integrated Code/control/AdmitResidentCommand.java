package control;

import entity.Resident;
import manager.ResidentRegistry;
import state.AdmittedState;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AdmitResidentCommand implements Command {
    private static int counter = 1000;
    private final Scanner scanner;

    public AdmitResidentCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Admit New Resident ---");

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        int age = Period.between(dob, LocalDate.now()).getYears();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Emergency Contact: ");
        String emergency = scanner.nextLine();

        String residentId = "R" + (++counter);
        Resident resident = new Resident(
                residentId,
                name,
                age,
                contact,
                emergency,
                new AdmittedState()
        );

        ResidentRegistry.getInstance().addResident(resident);
        System.out.println("Resident admitted successfully. Assigned Resident ID: " + residentId);
    }
}
