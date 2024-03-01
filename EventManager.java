import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class EventManager {
    private List<Event> events = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void loadEvents() {
       
    }

    public void saveEvents() {
        // 
    }

    public void registerUser() {
        System.out.println("Digite o nome do usuário:");
        String name = scanner.nextLine();

        System.out.println("Digite o email do usuário:");
        String email = scanner.nextLine();

        System.out.println("Digite a cidade do usuário:");
        String city = scanner.nextLine();

        User newUser = new User(name, email, city);
        users.add(newUser);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void createEvent() {
        System.out.println("Nome do evento:");
        String name = scanner.nextLine();

        System.out.println("Endereço do evento:");
        String address = scanner.nextLine();

        System.out.println("Categoria do evento (Festas, Esportes, Shows, etc.):");
        String category = scanner.nextLine();

        System.out.println("Data e hora do evento (dd/MM/yyyy HH:mm):");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);

        System.out.println("Descrição do evento:");
        String description = scanner.nextLine();

        Event newEvent = new Event(name, address, category, dateTime, description);
        events.add(newEvent);
        System.out.println("Evento cadastrado com sucesso!");
    }

    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("Não há eventos cadastrados.");
            return;
        }
        System.out.println("Eventos cadastrados:");
        for (Event event : events) {
            System.out.println("Nome: " + event.getName() + ", Endereço: " + event.getAddress() +
                    ", Categoria: " + event.getCategory() + ", Data e Hora: " +
                    event.getDateTime().format(formatter) + ", Descrição: " + event.getDescription());
        }
    }

    public void participateInEvent() {
        System.out.println("Digite o nome do evento que deseja participar:");
        String eventName = scanner.nextLine();
        Event event = events.stream()
                            .filter(e -> e.getName().equalsIgnoreCase(eventName))
                            .findFirst()
                            .orElse(null);
        if (event == null) {
            System.out.println("Evento não encontrado.");
            return;
        }

        System.out.println("Digite o nome do usuário:");
        String userName = scanner.nextLine();
        User user = users.stream()
                         .filter(u -> u.getName().equalsIgnoreCase(userName))
                         .findFirst()
                         .orElse(null);
        if (user == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
       
        System.out.println("Usuário " + user.getName() + " participará do evento " + event.getName() + ".");
    }
}
