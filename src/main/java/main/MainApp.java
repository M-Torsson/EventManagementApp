package main;

import dao.EventDAO;
import dao.ParticipantDAO;
import model.Event;
import model.Participant;

import java.sql.Date;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EventDAO eventDAO = new EventDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();

        boolean running = true;

        while (running) {
            System.out.println("\nEvent Management App");
            System.out.println("1. Add Event");
            System.out.println("2. Show All Events");
            System.out.println("3. Add Participant");
            System.out.println("4. Show Events With Participants");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();

                    System.out.print("Enter event date (yyyy-mm-dd): ");
                    String dateInput = scanner.nextLine();

                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();

                    Event event = new Event(eventName, Date.valueOf(dateInput), location);
                    eventDAO.addEvent(event);
                    break;

                case 2:
                    eventDAO.getAllEvents();
                    break;

                case 3:
                    System.out.print("Enter participant name: ");
                    String participantName = scanner.nextLine();

                    System.out.print("Enter event ID: ");
                    int eventId = scanner.nextInt();
                    scanner.nextLine();

                    Participant participant = new Participant(participantName, eventId);
                    participantDAO.addParticipant(participant);
                    break;

                case 4:
                    eventDAO.getEventsWithParticipants();
                    break;

                case 0:
                    running = false;
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}