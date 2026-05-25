public class FullTimeStaff extends Staff implements ClockIn {

    public FullTimeStaff(String id, String name) {
        super(id, name, "FullTime");
    }

    @Override
    public void markAttendance() {
        System.out.println("Marking full-time attendance for: " + name);
        AttendanceRecord.saveAttendance(id, name, type);
    }

    @Override
    public double calculateWorkingHours() {
        return 8.0;
    }

    @Override
    public void clockIn() {
        System.out.println("Full-time staff " + name + " clocked in.");
    }
}