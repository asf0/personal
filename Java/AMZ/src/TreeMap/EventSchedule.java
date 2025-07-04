package TreeMap;

import java.util.TreeMap;

public class EventSchedule {
    public static void main(String[] args) {
        TreeMap<String, String> schedule = new TreeMap<>();
        // addming sessions to the schedule
        schedule.put("09:00", "Dr. Smith - AI Trends");
        schedule.put("10:30", "Ms.Johnson - Data Privacy");
        schedule.put("11:45", "Mr. Lee = Cloud Computing");
        System.out.println("Conference Schedule: " + schedule);
        // get method
        String session = schedule.get("10:30");
        System.out.println("Session at 10:30: " + session);
        // remove method
        schedule.remove("09:00");
        System.out.println("After removing the 09:00 session: " + schedule);
        // ----------------------------------------------------------------
        TreeMap<String, String> courses = new TreeMap<>();
        // adding courses
        courses.put("CS101", "Introduction to Computer Science");
        courses.put("MATH201", "Calculus II");
        courses.put("ENG102", "English Literature");
        // Display all courses
        System.out.println("Course list: " + courses);
        // Updating a course name
        courses.put("ENG102", "Advanced English Literature");
        // Retriving by name code
        String courseName = courses.get("CS101");
        System.out.println("Course CS101: " + courseName);
        // Removing a course
        courses.remove("MATH201");
        System.out.println("After removing MATH201: " + courses);
    }
}
