public class Person {

    private String name;
    private String surname;
    private int numOfTickets;

    public Person(String name, String surname, int numOfTickets) {
        this.name = name;
        this.surname = surname;
        this.numOfTickets = numOfTickets;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getNumOfTickets() {
        return  this.numOfTickets;
    }

    public void useOneTicket() {
        this.numOfTickets--;
    }
}
