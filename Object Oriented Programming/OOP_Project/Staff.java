import java.util.Date;

public abstract class Staff {
    protected String id;
    protected String name;
    protected String type;
    protected Date timestamp;
    protected double totalHours;

    public Staff(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.timestamp = new Date(); // Set to current time when created
        this.totalHours = 0.0; // Initialize to 0, will be updated later
    }

    // Abstract method for marking attendance
    public abstract void markAttendance();

    // Abstract method for calculating working hours
    public abstract double calculateWorkingHours();

    // Method to update total hours (including OT)
    public void updateTotalHours(double otHours) {
        this.totalHours = calculateWorkingHours() + otHours;
    }

    // Getters for the fields (you can add setters if needed)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public Date getTimestamp() { return timestamp; }
    public double getTotalHours() { return totalHours; }

    // You might want to override toString() for easy printing
    @Override
    public String toString() {
        return String.format("%-10s %-15s %-12s %-10s %-10.2f",
                id, name, type, new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp), totalHours);
    }
}
