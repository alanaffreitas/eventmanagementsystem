import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EventManager eventManager = new EventManager();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Cadastrar evento");
            System.out.println("3. Listar eventos");
            System.out.println("4. Participar de um evento");
            System.out.println("5. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (choice) {
                case 1:
                    eventManager.registerUser();
                    break;
                case 2:
                    eventManager.createEvent();
                    break;
                case 3:
                    eventManager.listEvents();
                    break;
                case 4:
                    eventManager.participateInEvent();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
