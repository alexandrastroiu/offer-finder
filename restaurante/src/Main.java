import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilizator utilizator1 = new Utilizator();
        Utilizator utilizator2 = new Utilizator();
        Utilizator utilizator3 = new Utilizator();

        System.out.println("---------------------------------------------------------------");
        System.out.println("                 Comparator Oferte Restaurante                 ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("\nIntroduceti datele pentru autentificare: ");
        System.out.print("Nume utilizator: ");
        String numeUtilizator = scanner.nextLine();
        System.out.print("Parola: ");
        String parola = scanner.nextLine();

        // Login
        boolean esteAutentificat = utilizator1.autentificare(numeUtilizator, parola, "../data/utilizatori.csv");

        if (esteAutentificat) {
            System.out.println("\nAutentificare reusita!");
        }
        else {
            System.out.println("\nAutentificare esuata!");
            System.out.println("Nume utilizator sau parola incorecta.");
        }

        scanner.close();
    }

}