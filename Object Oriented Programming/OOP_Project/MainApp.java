import java.text.SimpleDateFormat;
import java.util.*;

public class MainApp {
    private static final ArrayList <Staff> records = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Staff Attendance System ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Clock In");
            System.out.println("2. View Attendance Report");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    clockIn(sc);
                    break;
                case "2":
                    viewReport(sc);
                    break;
                case "3":
                    System.out.println("System exited.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
    }

    private static void clockIn(Scanner sc) {
        String id = "";
        while (true) {
            try {
                System.out.print("Enter Staff ID: ");
                id = sc.nextLine().trim();

                if (id.isEmpty()) throw new IllegalArgumentException("Staff ID cannot be empty.");
                if (id.equals("0")) throw new IllegalArgumentException("Staff ID cannot be 0.");
                if (!id.matches("[a-zA-Z0-9]+")) throw new IllegalArgumentException("Staff ID must be alphanumeric.");

                break; // valid ID
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


        String name = "";
        while (true) {
            try {
                System.out.print("Enter Staff Name: ");
                name = sc.nextLine().trim();
                if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");
                if (!name.matches("[a-zA-Z ]+")) throw new IllegalArgumentException("Name must contain only letters and spaces.");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

       boolean isFullTime = false;
        while (true) {
            try {
                System.out.print("Is this Full-Time staff? (yes/no): ");
                String typeInput = sc.nextLine().trim().toLowerCase();

                if (!typeInput.equals("yes") && !typeInput.equals("no")) {
                    throw new IllegalArgumentException("Input must be 'yes' or 'no'.");
                }

                isFullTime = typeInput.equals("yes");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }


        double otHours = 0.0;
        while (true) {
            try {
                System.out.print("Enter OT hours (0 if none): ");
                otHours = Double.parseDouble(sc.nextLine().trim());
                if (otHours < 0) throw new IllegalArgumentException("OT hours cannot be negative.");
                break;
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

        Staff staff = isFullTime ? new FullTimeStaff(id, name) : new PartTimeStaff(id, name);
        if (staff instanceof ClockIn) ((ClockIn) staff).clockIn();

        staff.updateTotalHours(otHours);
        records.add(staff);

        staff.markAttendance();
        System.out.println("Working Hours (including OT): " + staff.getTotalHours());
    }

    private static void viewReport(Scanner sc) {
    if (records.isEmpty()) {
        System.out.println("No attendance records available.");
        return;
    }

    String typeFilter = "";
    while (true) {
        try {
            System.out.print("View which type of staff? (full/part): ");
            typeFilter = sc.nextLine().trim().toLowerCase();

            if (!typeFilter.equals("full") && !typeFilter.equals("part")) {
                throw new IllegalArgumentException("Please enter 'full' or 'part'.");
            }
            break;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    String staffTypeToShow = typeFilter.equals("full") ? "FullTime" : "PartTime";
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    boolean found = false;

    System.out.println("\n--- " + staffTypeToShow + " Attendance Report for " + today + " ---");
    System.out.printf("%-10s %-15s %-12s %-10s %-10s %-10s\n", "ID", "Name", "Type", "Date", "Time", "Hours");

    for (Staff staff : records) {
        String recordDate = new SimpleDateFormat("yyyy-MM-dd").format(staff.getTimestamp());
        if (recordDate.equals(today) && staff.getType().equalsIgnoreCase(staffTypeToShow)) {
            System.out.println(staff.toString());
            found = true;
        }
    }

    if (!found) {
        System.out.println("No records for selected type today.");
    }
}


}
