package entities;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dominik.kotecki on 28-12-2015.
 */
public class Ride {
    public static AtomicInteger identity = new AtomicInteger(0);
    private final int id;
    private final Person owner;
    private final String from;
    private final String to;
    private final Date date;
    private final int amountOfSeats;
    private final List<Person> persons;


    public Ride(int id, Person owner, String from, String to, Date date, int amountOfSeats, List<Person> persons) {
        this.id = id;
        this.owner = owner;
        this.from = from;
        this.to = to;
        this.date = date;
        this.amountOfSeats = amountOfSeats;
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public List<Person> getPersons() {
        return persons;
    }

}