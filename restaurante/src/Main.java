import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilizator utilizator = new Utilizator();
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
            new Produs(29, "Croissant", 15 , "", 320),
            new Produs(30, "Cafea Americano", 19 , "", 150)
        ));

        // TODO
        // Adauga oferte pentru restaurantele disponibile
              
        r1.setOferteValide(creeazaListaOferte(
            new OfertaCombo(1, "Combo Pizza + Paste", 50)
        ));
        
        r2.setOferteValide(creeazaListaOferte(
            new OfertaCombo(2, "Combo Pizza", 52),
            new OfertaCombo(3, "Combo Pizza + Paste", 60),
            new OfertaMeniu(4, "Reducere Meniu", 10, r2.getMeniu())
        ));
        r3.setOferteValide(creeazaListaOferte(
            new OfertaCombo(5, "Combo Noodles", 44),
            new OfertaMeniu(6, "Reducere Meniu", 5, r3.getMeniu())
        ));
        r4.setOferteValide(creeazaListaOferte(
            new OfertaCombo(7, "Combo Burger + Cartofi", 45)
        ));
        r5.setOferteValide(creeazaListaOferte(
            new OfertaMeniu(8, "Reducere Meniu", 7, r5.getMeniu())
        ));
        r6.setOferteValide(creeazaListaOferte(
            new OfertaCombo(9, "Combo Burger + Cartofi", 39),
            new OfertaMeniu(10, "Reducere Meniu", 12, r6.getMeniu())
        ));
        r7.setOferteValide(creeazaListaOferte(
            new OfertaCombo(11, "Combo Burger + Cartofi", 45)
        ));
        r8.setOferteValide(creeazaListaOferte(
            new OfertaMeniu(12, "Reducere Meniu", 2, r8.getMeniu())
        ));
        r9.setOferteValide(creeazaListaOferte(
            new OfertaMeniu(13, "Reducere Meniu", 5, r9.getMeniu())
        ));
        r10.setOferteValide(creeazaListaOferte(
                new OfertaMeniu(14, "Reducere Meniu", 2, r10.getMeniu())
        ));
        r11.setOferteValide(creeazaListaOferte(
            new OfertaCombo(15, "Combo Cafea + Croissant", 25)
        ));

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

        comparator.setRestaurante(restaurante);

        System.out.println("---------------------------------------------------------------");
        System.out.println("                 Comparator Oferte Restaurante                 ");
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("\nIntroduceti datele pentru autentificare: ");
        System.out.print("Nume utilizator: ");
        String numeUtilizator = scanner.nextLine();
        System.out.print("Parola: ");
        String parola = scanner.nextLine();

        // Login
        boolean esteAutentificat = utilizator.autentificare(numeUtilizator, parola, "./../restaurante/data/utilizatori.csv");

        if (esteAutentificat) {
            System.out.println("\nAutentificare reusita!\n");

            // Verifica rolul utilizatorului
            if (utilizator.getRol().equalsIgnoreCase("client")) {
                Client client = new Client(utilizator.getId(), utilizator.getEmail(), utilizator.getNumeUtilizator(), utilizator.getParola(), utilizator.getRol());
                boolean continuaProgram = true;

                client.asignareComparator(comparator);

                client.afiseazaDateClient();

                while (continuaProgram) {
                System.out.println("\n--------------------Optiuni Disponibile:------------------------");
                System.out.println("                     1. Cauta restaurant                          ");
                System.out.println("                     2. Cauta produs                              ");
                System.out.println("                     3. Compara oferte                            ");
                System.out.println("                     4. Filtreaza oferte si restaurante           ");
                System.out.println("                     5. Deconectare                               ");
                System.out.println("-----------------------------------------------------------------\n");

                System.out.print("\nAlegeti o optiune: ");
                int optiune = scanner.nextInt();
                scanner.nextLine();

                // Identifica optiunea aleasa de utilizator
                switch (optiune) {
                    case 1:{
                        System.out.print("Introduceti numele restaurantului: ");
                        String numeRestaurant = scanner.nextLine();

                        List<Restaurant> rezultat = client.getComparator().cautaRestaurant(numeRestaurant);

                        if (rezultat.isEmpty()) {
                            System.out.println("Restaurantul nu a fost gasit.");
                        } else {
                            System.out.println("Restaurant gasit:");
                            for (Restaurant r : rezultat) {
                                System.out.println(r.getDenumire());
                            }
                        }
                        break; 
                    }

                    case 2:{
                        System.out.print("Introduceti numele produsului: ");
                        String numeProdus = scanner.nextLine();

                        List<Produs> rezultat = client.getComparator().cautaProdus(numeProdus);

                        if (rezultat.isEmpty()) {
                            System.out.println("Produsul nu a fost gasit.");
                        } else {
                            for (Produs p : rezultat) {
                                System.out.println(p.getDenumire() + " - " + p.getPret() + " lei");
                            }
                        }
                        break;
                    }

                    case 3:{ 
                      System.out.println("\nIntroduceti numele a doua restaurante: ");
                      System.out.print("Restaurant 1: ");
                      String numeRestaurant1 = scanner.nextLine();
                      System.out.print("Restaurant 2: ");
                      String numeRestaurant2 = scanner.nextLine();

                      List<Restaurant> restaurant1 = client.getComparator().cautaRestaurant(numeRestaurant1);
                      List<Restaurant> restaurant2 = client.getComparator().cautaRestaurant(numeRestaurant2);

                      if (restaurant1.isEmpty() || restaurant2.isEmpty()) {
                            System.out.println("Ofertele nu pot fi comparate.");
                      }
                      else {
                        System.out.println("\nIntroduceti ID-ul a doua oferte: ");
                        System.out.print("Oferta 1: ");
                        int IDOferta1 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Oferta 2: ");
                        int IDOferta2 = scanner.nextInt();
                        scanner.nextLine();
                        Oferta o1 = client.getComparator().selecteazaOferta(IDOferta1);
                        Oferta o2 = client.getComparator().selecteazaOferta(IDOferta2);

                        if (o1 != null && o2 != null) {
                            client.getComparator().comparaOferte(restaurant1.get(0), o1, restaurant2.get(0), o2);
                        }
                      }

                      break;
                    }

                    case 4:{
                        System.out.println("\n--------------------Optiuni Filtrare:------------------------");
                        System.out.println("                    - pret                                     ");
                        System.out.println("                    - distanta                                 ");
                        System.out.println("                    - procent reducere                         ");
                        System.out.println("                    - recenzii                                 ");
                        System.out.println("-------------------------------------------------------------\n");

                        System.out.print("Introduceti criteriul de filtrare: ");
                        String criteriu = scanner.nextLine();

                        switch (criteriu) {
                            case "pret":{
                                System.out.print("Pret maxim: ");
                                float pretMax = scanner.nextFloat();
                                scanner.nextLine();

                                List<Oferta> rezultat = client.getComparator().filtrarePret(pretMax);

                                if (rezultat.isEmpty()) {
                                    System.out.println("Nu au fost gasite oferte.");
                                } else {
                                    System.out.println("Ofertele gasite cu un pret maxim " + pretMax + " :");
                                    for (Oferta o : rezultat) {
                                        if (o instanceof OfertaMeniu) {
                                            System.out.println(o.getDenumire() + " - " + client.getComparator().reducereToString(o) + " %");
                                        }
                                        else {
                                            System.out.println(o.getDenumire() + " - " + client.getComparator().priceToString(o) + "lei");
                                        }
                                     }
                                }

                                break;
                            }

                            case "distanta":{
                                System.out.print("Distanta maxima (km) : ");
                                float distMax = scanner.nextFloat();
                                scanner.nextLine();

                                List<Restaurant> rezultat = client.getComparator().filtrareDistanta(distMax);

                                if (rezultat.isEmpty()) {
                                    System.out.println("Nu au fost gasite restaurante.");
                                } else {
                                    System.out.println("Restaurantele gasite la o distanta de maxim " + distMax + " km de Politehnica:");
                                    for (Restaurant r : rezultat) {
                                        System.out.println(r.getDenumire() + " - " + r.getDistanta() + " km");
                                     }
                                }
                
                                break;
                            }

                            case "procent reducere":{
                                System.out.print("Prag minim: ");
                                int pragMin = scanner.nextInt();
                                scanner.nextLine();

                                List<Oferta> rezultat = client.getComparator().filtrareProcentReducere(pragMin);

                                if (rezultat.isEmpty()) {
                                    System.out.println("Nu au fost gasite oferte.");
                                } else {
                                    System.out.println("Ofertele gasite cu un procent de reducere de minim " + pragMin + " %:");
                                    for (Oferta o : rezultat) {
                                        System.out.println(o.getDenumire() + " - " + client.getComparator().reducereToString(o) + " % ");
                                    }
                                }

                                break;
                            }

                            case "recenzii":{
                                System.out.print("Nota minima: ");
                                float notaMin = scanner.nextFloat();
                                scanner.nextLine();

                                List<Restaurant> rezultat = client.getComparator().filtrareRecenzii(notaMin);

                                if (rezultat.isEmpty()) {
                                    System.out.println("Nu au fost gasite restaurante.");
                                } else {
                                    System.out.println("Restaurantele gasite cu nota medie minim " + notaMin + " :");
                                    for (Restaurant r : rezultat) {
                                        System.out.println(r.getDenumire() + " - " + r.getNotaMedie());
                                    }
                                }

                                break;
                            }

                            default:{
                                System.out.println("Optiune invalida");
                            }
                        }

                        break;
                    }

                    case 5:{
                        continuaProgram = false;
                        break;
                    }

                    default:{
                        System.out.println("Optiune invalida.");
                    }
                }
                
            }
            }
            else if (utilizator.getRol().equalsIgnoreCase("manager")) {
                ManagerRestaurant manager = new ManagerRestaurant(utilizator.getId(), utilizator.getEmail(), utilizator.getNumeUtilizator(), utilizator.getParola(), utilizator.getRol(), restaurante.get(0));
                boolean continuaProgram = true;

                while (continuaProgram) {
                System.out.println("\n--------------------Optiuni Disponibile:------------------------");
                System.out.println("                     1. Adauga oferta                             ");
                System.out.println("                     2. Elimina oferta                            ");
                System.out.println("                     3. Actualizeaza program                      ");
                System.out.println("                     4. Actualizeaza pret                         ");
                System.out.println("                     5. Modifica meniu                            ");
                System.out.println("                     6. Deconectare                               ");
                System.out.println("-----------------------------------------------------------------\n");

                System.out.print("\nAlegeti o optiune: ");
                int optiune = scanner.nextInt();
                scanner.nextLine();

                //TODO
                switch (optiune) {
                    case 1:{
                        manager.adaugareOferta();
                        break; 
                    }

                    case 2:{
                        manager.eliminaOferta();
                        break;
                    }

                    case 3:{
                        manager.actualizeazaProgram();
                        break;
                    }

                    case 4:{
                        manager.actualizeazaPret();
                        break;
                    }

                    case 5:{
                        manager.modificaMeniu();
                        break;
                    }

                    case 6:{
                        continuaProgram = false;
                        break;
                    }

                    default:{
                        System.out.println("Optiune invalida.");
                    }
                }
                }
            }
            else if (utilizator.getRol().equalsIgnoreCase("administrator")) {
                Administrator admin = new Administrator(utilizator.getId(), utilizator.getEmail(), utilizator.getNumeUtilizator(), utilizator.getParola(), utilizator.getRol());
                boolean continuaProgram = true;

                admin.asignareComparator(comparator);

                while (continuaProgram) {
                System.out.println("\n--------------------Optiuni Disponibile:------------------------");
                System.out.println("                     1. Adauga restaurant                         ");
                System.out.println("                     2. Sterge restaurant                         ");
                System.out.println("                     3. Genereaza statistici despre restaurante   ");
                System.out.println("                     4. Deconectare                               ");
                System.out.println("-----------------------------------------------------------------\n");

                System.out.print("\nAlegeti o optiune: ");
                int optiune = scanner.nextInt();
                scanner.nextLine();

                switch (optiune) {
                    case 1:{
                        System.out.println("\nIntroduceti datele noului restaurant:");
                        System.out.println("Denumire: ");
                        String den = scanner.nextLine();
                        System.out.println("Adresa: ");
                        String adr = scanner.nextLine();
                        System.out.println("Distanta: ");
                        float dist = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ora deschidere: ");
                        float oraD = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Ora inchidere: ");
                        float oraI = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.println("Nota medie: ");
                        float nota = scanner.nextFloat();
                        scanner.nextLine();
                        int id = admin.getComparator().getRestaurante().size() + 1;
                        Restaurant restaurantNou = new Restaurant(id, den, adr, dist, oraD, oraI, nota, SpecificRestaurant.FastFood, id);
                        admin.adaugaRestaurant(restaurantNou);
                        break;
                    }

                    case 2:{
                        System.out.println("\nIntroduceti ID-ul restaurantului eliminat:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        boolean esteEliminat = admin.stergeRestaurant(id);
                        if (esteEliminat) {
                            System.out.println("Restaurantul cu ID-ul " + id +  " a fost eliminat cu succes.");
                        }
                        else {
                            System.out.println("Operatia de eliminare a esuat.");
                        }
                        break;
                    }

                    case 3:{
                        admin.genereazaStatistici();
                        break;
                    }

                    case 4:{
                        continuaProgram = false;
                        break;
                    }

                    default:{
                        System.out.println("Optiune invalida.");
                    }
                }
            }
            }
        }
        else {
            System.out.println("\nAutentificare esuata!\n");
            System.out.println("Nume utilizator sau parola incorecta.");
        }

        // Logout
        utilizator.deconectare();

        scanner.close();
    }

    // Metode helper
    private static ArrayList<Produs> creeazaListaProduse(Produs... produse) {
        ArrayList<Produs> listaProduse = new ArrayList<>();

        for (Produs p : produse) {
            listaProduse.add(p);
        }
        return listaProduse;
    }

    private static ArrayList<Oferta> creeazaListaOferte(Oferta... oferte) {
        ArrayList<Oferta> listaOferte = new ArrayList<>();

        for (Oferta o : oferte) {
            listaOferte.add(o);
        }
        return listaOferte;
    }

}