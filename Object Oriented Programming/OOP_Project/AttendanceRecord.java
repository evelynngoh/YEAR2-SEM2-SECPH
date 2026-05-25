import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Handles saving attendance to a file (simplified for beginner level)
public class AttendanceRecord {

    public static void saveAttendance(String id, String name, String type) {
        try {
            FileWriter writer = new FileWriter("attendance.txt", true); // Append mode

            // Get current date and time
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = formatter.format(now);

            // Write to file
            writer.write(id + "," + name + "," + type + "," + timestamp + "\n");
            writer.close();
            System.out.println("Attendance saved.\n");
        } catch (IOException e) {
            System.out.println("Error saving attendance: " + e.getMessage());
        }
    }
}


