import java.util.*;

public class Main {

    public static List<Person> generateClients() {

        Random random = new Random();

        List<String> maleNames = new ArrayList<>(Arrays.asList("Василий", "Иван", "Константин", "Петр", "Евгений", "Афанасий"));
        List<String> femaleNames = new ArrayList<>(Arrays.asList("Мария", "Агата", "Екатерина", "Надежда", "Татьяна", "Наталия"));
        List<String> maleSurnames = new ArrayList<>(Arrays.asList("Васин", "Иванов", "Костин", "Назаров", "Таликов", "Петров"));
        List<String> femaleSurnames = new ArrayList<>(Arrays.asList("Васина", "Иванова", "Костина", "Назарова", "Таликова", "Петрова"));

        List<Person> clients = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            int male = random.nextInt(2);
            String genName = male == 1 ? maleNames.get(random.nextInt(maleNames.size())) : femaleNames.get(random.nextInt(femaleNames.size()));
            String genSurname = male == 1 ? maleSurnames.get(random.nextInt(maleNames.size())) : femaleSurnames.get(random.nextInt(femaleSurnames.size()));
            int genNumOfTickets = random.nextInt(5);
            clients.add(new Person(genName,genSurname, genNumOfTickets));
        }
        return clients;
    }

    public static void main(String[] args) {

        List<Person> clients = generateClients();
        for (Person client: clients) {
            System.out.println(client.getName() + " " + client.getSurname() + " владеет билетами в количестве " + client.getNumOfTickets());
        }

        Queue<Person> queue = new LinkedList<>(clients);

        while (!queue.isEmpty()) {
            Person person = queue.peek();
            if (person.getNumOfTickets() == 0) {
                queue.remove();
            } else {
                person = queue.poll();
                System.out.println("Посетитель " + person.getName() + " " + person.getSurname() + " прокатился на аттракционе");
                person.useOneTicket();
                queue.add(person);
            }
        }
    }
}
