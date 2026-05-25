public class PartTimeStaff extends Staff implements ClockIn {

    public PartTimeStaff(String id, String name) {
        super(id, name, "PartTime");
    }

    @Override
    public void markAttendance() {
        System.out.println("Marking part-time attendance for: " + name);
        AttendanceRecord.saveAttendance(id, name, type);
    }

    @Override
    public double calculateWorkingHours() {
        return 4.0;
    }

    @Override
    public void clockIn() {
        System.out.println("Part-time staff " + name + " clocked in.");
    }
}