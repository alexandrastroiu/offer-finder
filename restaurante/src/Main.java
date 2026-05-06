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
          0.3f,
          10.0f,
          23.0f,
          4.5f,
          SpecificRestaurant.FastFood,
          1
        );

        Restaurant r2 = new Restaurant(
           2,
          "Trattoria Locale",
          "Bulevardul Iuliu Maniu 8",
          0.85f,
          10.0f,
          23.0f,
          4.5f,
          SpecificRestaurant.Italienesc,
          2
        );


        Restaurant r3 = new Restaurant(
           3,
          "Sushi Terra",
          "Bulevardul General Paul Teodorescu",
          0.6f,
          10.0f,
          23.0f,
          4.4f,
          SpecificRestaurant.FastFood,
          3
        );

        Restaurant r4 = new Restaurant(
           4,
          "Treevi Pizza",
          "Bulevardul Iuliu Maniu 7",
          0.2f,
          10.0f,
          22.0f,
          3.8f,
          SpecificRestaurant.Italienesc,
          4
        );

        Restaurant r5 = new Restaurant(
           5,
          "PUB 18",
          "Splaiul Independenței 290",
          1.5f,
          12.0f,
          24.0f,
          4.4f,
          SpecificRestaurant.FastFood,
          5
        );

        Restaurant r6 = new Restaurant(
           6,
          "King Rolls",
          "Bulevardul Timisoara 4",
          0.85f,
          11.0f,
          24.0f,
          4.0f,
          SpecificRestaurant.FastFood,
          6
        );

        Restaurant r7 = new Restaurant(
           7,
          "Casa MYT",
          "Drumul Taberei 4",
          1.3f,
          10.0f,
          23.0f,
          4.1f,
          SpecificRestaurant.Romanesc,
          7
        );

        Restaurant r8 = new Restaurant(
           8,
          "Trattoria Roma",
          "Drumul Taberei 26",
          1.8f,
          11.0f,
          23.0f,
          4.4f,
          SpecificRestaurant.Italienesc,
          8
        );

        Restaurant r9 = new Restaurant(
           9,
          "Restaurant Vanity",
          "Splaiul Independentei 315",
          1.4f,
          11.0f,
          24.0f,
          4.5f,
          SpecificRestaurant.Romanesc,
          9
        );

        Restaurant r10 = new Restaurant(
           10,
          "Mesopotamia",
          "Bulevardul Iuliu Maniu 19",
          1.9f,
          9.3f,
          21.3f,
          4.3f,
          SpecificRestaurant.FastFood,
          10
        );

        Restaurant r11 = new Restaurant(
           11,
          "Starbucks",
          "Bulevardul General Paul Teodorescu 4",
          0.45f,
          8.0f,
          22.3f,
          4.3f,
          SpecificRestaurant.Patiserie,
          11
        );

        // Adauga meniul pentru restaurantele disponibile
        r1.getMeniu().setProduse(creeazaListaProduse(
            new Produs(1, "Pizza Quatro Formaggi", 30, "", 850),
            new Produs(2, "Pizza Margherita", 25, "", 600),
            new Produs(3, "Pizza Prosciutto", 33 , "", 670),
            new Produs(4, "Paste", 38 , "", 65)
        ));
        r2.getMeniu().setProduse(creeazaListaProduse(
            new Produs(5, "Paste Carbonara", 39 , "", 670),
            new Produs(6, "Pizza Margherita", 35, "", 550),
            new Produs(7, "Paste Bolognese", 43, "", 680),
            new Produs(8, "Pizza Prosciutto", 46, "", 680)
        ));
        r3.getMeniu().setProduse(creeazaListaProduse(
            new Produs(9, "Somon", 55 , "", 450),
            new Produs(10, "Creveti", 60 , "", 460),
            new Produs(11, "Noodles cu fructe de mare", 46, "",500 ),
            new Produs(12, "Noodles creveti", 55, "", 520)
        ));
        r4.getMeniu().setProduse(creeazaListaProduse(
            new Produs(13, "Pizza Margherita", 22, "", 550),
            new Produs(14, "Pizza Quatro Formaggi", 28, "", 580),
            new Produs(15, "Burger Clasic", 35, "", 560),
            new Produs(16, "Cartofi prajiti", 17, "", 350)
        ));
        r5.getMeniu().setProduse(creeazaListaProduse(
            new Produs(17, "Burger Clasic", 40, "", 570),
            new Produs(18, "Cartofi prajiti", 20, "", 360),
            new Produs(19, "Cheeseburger", 43, "", 650)
        ));
        r6.getMeniu().setProduse(creeazaListaProduse(
            new Produs(20, "Cartofi prajiti", 19, "", 340),
            new Produs(21, "Burger Clasic", 37, "", 570),
            new Produs(22, "Cheesy rolls",40 , "", 560)
        ));
        r7.getMeniu().setProduse(creeazaListaProduse(
            new Produs(23, "Cartofi prajiti", 16, "", 340),
            new Produs(24, "Burger clasic", 40, "", 560)
        ));
        r8.getMeniu().setProduse(creeazaListaProduse(
            new Produs(25, "Paste Carbonara", 45 , "", 670),
            new Produs(26, "Pizza Margherita", 34, "", 600)
        ));
        r9.getMeniu().setProduse(creeazaListaProduse(
            new Produs(27, "Burger Clasic", 44, "", 550)
        ));
        r10.getMeniu().setProduse(creeazaListaProduse(
            new Produs(28, "Falafel", 25, "", 400)
        ));
        r11.getMeniu().setProduse(creeazaListaProduse(
            new Produs(29, "Croissant", 15 , "", 320)
        ));

        // Adauga oferte pentru restaurantele disponibile
        //r1.setOferteValide();
        //r2.setOferteValide();
        //r3.setOferteValide();
        //r4.setOferteValide();
        //r5.setOferteValide();
        //6.setOferteValide();
        //r7.setOferteValide();
        //r8.setOferteValide();
        //r9.setOferteValide();
        //r10.setOferteValide();
        //r11.setOferteValide();


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

    private static ArrayList<Produs> creeazaListaProduse(Produs... produse) {
        ArrayList<Produs> listaProduse = new ArrayList<>();

        for (Produs p : produse) {
            listaProduse.add(p);
        }
        return listaProduse;
    }

}