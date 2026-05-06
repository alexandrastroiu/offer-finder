import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilizator utilizator1 = new Utilizator();
        Utilizator utilizator2 = new Utilizator();
        Utilizator utilizator3 = new Utilizator();
        Comparator comparator = new Comparator();
        List<Restaurant> restaurante = new ArrayList<>();

        // Restaurante disponibile
        Restaurant r1 = new Restaurant(
           1,
          "Dodo Pizza",
          "Bulevardul Iuliu Maniu 7",
          0.3,
          10.0,
          23.0,
          4.5,
          SpecificRestaurant.FastFood,
          1
        );

        Restaurant r2 = new Restaurant(
           2,
          "Trattoria Locale",
          "Bulevardul Iuliu Maniu 8",
          0.85,
          10.0,
          23.0,
          4.5,
          SpecificRestaurant.Italienesc,
          2
        );


        Restaurant r3 = new Restaurant(
           3,
          "Sushi Terra",
          "Bulevardul General Paul Teodorescu",
          0.6,
          10.0,
          23.0,
          4.4,
          SpecificRestaurant.FastFood,
          3
        );

        Restaurant r4 = new Restaurant(
           4,
          "Treevi Pizza",
          "Bulevardul Iuliu Maniu 7",
          0.2,
          10.0,
          22.0,
          3.8,
          SpecificRestaurant.Italienesc,
          4
        );

        Restaurant r5 = new Restaurant(
           5,
          "PUB 18",
          "Splaiul Independenței 290",
          1.5,
          12.0,
          24.0,
          4.4,
          SpecificRestaurant.FastFood,
          5
        );

        Restaurant r6 = new Restaurant(
           6,
          "King Rolls",
          "Bulevardul Timisoara 4",
          0.85,
          11.0,
          24.0,
          4.0,
          SpecificRestaurant.FastFood,
          6
        );

        Restaurant r7 = new Restaurant(
           7,
          "Casa MYT",
          "Drumul Taberei 4",
          1.3,
          10.0,
          23.0,
          4.1,
          SpecificRestaurant.Romanesc,
          7
        );

        Restaurant r8 = new Restaurant(
           8,
          "Trattoria Roma",
          "Drumul Taberei 26",
          1.8,
          11.0,
          23.0,
          4.4,
          SpecificRestaurant.Italienesc,
          8
        );

        Restaurant r9 = new Restaurant(
           9,
          "Restaurant Vanity",
          "Splaiul Independentei 315",
          1.4,
          11.0,
          24.0,
          4.5,
          SpecificRestaurant.Romanesc,
          9
        );

        Restaurant r10 = new Restaurant(
           10,
          "Mesopotamia",
          "Bulevardul Iuliu Maniu 19",
          1.9,
          9.3,
          21.3,
          4.3,
          SpecificRestaurant.FastFood,
          10
        );

        Restaurant r11 = new Restaurant(
           11,
          "Starbucks",
          "Bulevardul General Paul Teodorescu 4",
          0.45,
          8.0,
          22.3,
          4.3,
          SpecificRestaurant.Patiserie,
          11
        );

        // Adauga meniul pentru restaurantele disponibile
        r1.getMeniu().setProduse();
        r2.getMeniu().setProduse();
        r3.getMeniu().setProduse();
        r4.getMeniu().setProduse();
        r5.getMeniu().setProduse();
        r6.getMeniu().setProduse();
        r7.getMeniu().setProduse();
        r8.getMeniu().setProduse();
        r9.getMeniu().setProduse();
        r10.getMeniu().setProduse();
        r11.getMeniu().setProduse();

        // Adauga oferte pentru restaurantele disponibile
        r1.setOferteValide();
        r2.setOferteValide();
        r3.setOferteValide();
        r4.setOferteValide();
        r5.setOferteValide();
        r6.setOferteValide();
        r7.setOferteValide();
        r8.setOferteValide();
        r9.setOferteValide();
        r10.setOferteValide();
        r11.setOferteValide();


        restaurante.add(r1);
        restaurante.add(r2);
        restaurante.add(r3);
        restaurante.add(r4);
        restaurante.add(r5);
        restaurante.add(r6);
        restaurante.add(r7);
        restaurante.add(r8);
        restaurante.add(r9);
        restaurante.add(r10);
        restaurante.add(r11);
          

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