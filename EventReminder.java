import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Event {
    String name;
    String date;
    String time;

    public Event(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event: " + name + " | Date: " + date + " | Time: " + time;
    }
}

public class EventReminder {

    private ArrayList<Event> events;
    private Scanner scanner;

    public EventReminder() {
        events = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEvent() {
        System.out.println("\n--- Add a New Event ---");
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        System.out.print("Enter event date (e.g., YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter event time (e.g., HH:MM): ");
        String time = scanner.nextLine();

        Event newEvent = new Event(name, date, time);
        events.add(newEvent);

        System.out.println("Event added successfully!");
    }

    public void viewEvents() {
        System.out.println("\n--- All Events ---");
        if (events.isEmpty()) {
            System.out.println("No events have been added yet.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public void searchEvent() {
        System.out.println("\n--- Search for an Event ---");
        System.out.print("Enter the name of the event to search for: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Event event : events) {
            if (event.name.equalsIgnoreCase(searchName)) {
                System.out.println("Event found:");
                System.out.println(event);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Event with name '" + searchName + "' not found.");
        }
    }

    public void deleteEvent() {
        System.out.println("\n--- Delete an Event ---");
        System.out.print("Enter the name of the event to delete: ");
        String deleteName = scanner.nextLine();

        Iterator<Event> iterator = events.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.name.equalsIgnoreCase(deleteName)) {
                iterator.remove();
                removed = true;
                System.out.println("Event '" + deleteName + "' has been deleted.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Event with name '" + deleteName + "' not found.");
        }
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n===== Event Reminder Menu =====");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. Search for an Event");
            System.out.println("4. Delete an Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    viewEvents();
                    break;
                case 3:
                    searchEvent();
                    break;
                case 4:
                    deleteEvent();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        EventReminder reminderApp = new EventReminder();
        reminderApp.run();
    }
}
