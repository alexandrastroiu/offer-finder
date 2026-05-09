package clase;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ManagerRestaurant extends Utilizator
{
    private Restaurant restaurant;
    // Relatie de asociatie intre clasele manager si comparator
    private Comparator comparator;
    private  int restaurantID;

    // constructori
    public ManagerRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ManagerRestaurant() {
        super();
    }

    public ManagerRestaurant(int id, String email, String numeUtilizator, String parola, String rol, Restaurant restaurant, int idRst) {
        super(id, email, numeUtilizator, parola, rol);
        this.restaurant = restaurant;
        this.restaurantID = idRst;
    }

    // getters si setters

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    // metode

    // adauga oferta
    public void adaugareOferta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce fel de oferta doriti sa introduceti?");
        System.out.println("Introduceti o optiune (1, 2 sau 3)");
        System.out.println("1. Reducere pentru tot meniul");
        System.out.println("2. Reducere pentru un produs anume");
        System.out.println("3. Oferta combo");
        int optiune = scanner.nextInt();
        List<Restaurant> restauranteTemp = this.comparator.getRestaurante();
        switch (optiune) {
            case 1:
                System.out.println("Ce procentaj de reducere doriti?");
                int procentaj = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ce denumire doriti sa aiba oferta?");
                String denumire = scanner.nextLine();
                OfertaMeniu ofertaMeniu = new OfertaMeniu(this.restaurant.getOferteValide().size(), denumire, procentaj, restaurant.getMeniu());
                this.restaurant.adaugareOferta(ofertaMeniu);
                break;

            case 2:
                System.out.println("Ce procentaj de reducere doriti?");
                int reducere = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Carui produs doriti sa ii atribuiti reducerea? (Introduceti numarul corespunzator)");
                this.restaurant.getMeniu().afisareMeniu();
                int idProd = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.println("Ce denumire doriti sa aiba oferta?");
                String numeOfertaProdus = scanner.nextLine();
                OfertaProdus ofertaProdus = new OfertaProdus(this.restaurant.getOferteValide().size(), numeOfertaProdus, reducere);
                ofertaProdus.setProdus(this.restaurant.getMeniu().getProduse().get(idProd));
                this.restaurant.adaugareOferta(ofertaProdus);
                break;

            case 3:
                System.out.println("Ce pret doriti sa aiba oferta de tip combo?");
                float pret = scanner.nextFloat();
                scanner.nextLine();
                System.out.println("Ce denumire doriti sa aiba oferta?");
                String numeOfertaCombo = scanner.nextLine();
                OfertaCombo ofertaCombo = new OfertaCombo(this.restaurant.getOferteValide().size(), numeOfertaCombo, pret);
                System.out.println("Cate produse doriti sa aiba oferta de tip combo?");
                int nrProd = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Adaugati produsele: ");
                this.restaurant.getMeniu().afisareMeniu();
                for(int i = 0; i < nrProd; i ++) {
                    System.out.println("Ce produs doriti sa adaugati in oferta de tip combo? (Introduceti numarul corespunzator)");
                    int idP = scanner.nextInt() - 1;
                    ofertaCombo.adaugareProdus(this.restaurant.getMeniu().getProduse().get(idP));
                }
                this.restaurant.adaugareOferta(ofertaCombo);
                break;

            default :
                System.out.println("Nu ati introdus o optiune valida (1, 2 sau 3). Reluati procesul.");
                break;

        }
    }

    // elimina oferta
    public void eliminaOferta() {
        Scanner scanner = new Scanner(System.in);
        this.restaurant.afisareOferte();
        System.out.println("Introduceti denumirea ofertei pe care doriti sa o eliminati");
        String nume = scanner.nextLine();
        if(this.restaurant.getOferteValide().stream().filter(oferta -> (oferta.getDenumire().equals(nume))).findAny().orElse(null) != null) {
            this.restaurant.eleminareOfertaNume(nume);
            System.out.println("Oferta " + nume + " nu mai este valida");
        }
        else {
            System.out.println("Nu exista aceasta oferta. Reluati procesul");
        }
    }

    // actualizare oferta
    public void actualizareOferta() {
        Scanner scanner = new Scanner(System.in);
        this.restaurant.afisareOferte();
        System.out.println("Introduceti denumirea ofertei pe care doriti sa o actualizati");
        String nume = scanner.nextLine();

        Optional<Oferta> found = this.restaurant.getOferteValide().stream()
                .filter(oferta -> oferta.getDenumire().equalsIgnoreCase(nume))
                .findFirst();

        if(found.isPresent()) {
            Oferta o = found.get();
            int ID = o.getId();
            if(o instanceof OfertaProdus) {
                System.out.println("Puteti modifica procentajul de reducere pentru oferta de tip produs");
                System.out.println("Ce procentaj de reducere doriti?");
                int procentaj = scanner.nextInt();
                scanner.nextLine();
                OfertaProdus ofertaProdus = new OfertaProdus(ID, o.getDenumire(), procentaj);
                ofertaProdus.setProdus(((OfertaProdus) o).getProdus());
                this.restaurant.eleminareOfertaNume(o.getDenumire());
                this.restaurant.adaugareOferta(ofertaProdus);
            }
            else if(o instanceof OfertaCombo) {
                System.out.println("Puteti modifica pretul si produsele participante pentru oferta de tip combo");
                System.out.println("Introduceti o optiune (1, 2 sau 3)");
                System.out.println("1. Modificare pret");
                System.out.println("2. Modificare lista de produse");
                int optiune = scanner.nextInt();
                scanner.nextLine();
                if(optiune == 1) {
                    System.out.println("Ce pret doriti sa aiba oferta de tip combo?");
                    float pret = scanner.nextFloat();
                    OfertaCombo ofertaCombo = new OfertaCombo(ID, o.getDenumire(), ((OfertaCombo) o).getPretCombo());
                    ofertaCombo.setProduseParticipante(((OfertaCombo) o).getProduseParticipante());
                    this.restaurant.eleminareOfertaNume(o.getDenumire());
                    this.restaurant.adaugareOferta(ofertaCombo);
                }
                else if(optiune == 2) {
                    System.out.println("Cate produse doriti sa aiba oferta de tip combo?");
                    int nrProd = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Adaugati produsele: ");
                    this.restaurant.getMeniu().afisareMeniu();
                    OfertaCombo ofertaCombo = new OfertaCombo(ID, o.getDenumire(), ((OfertaCombo) o).getPretCombo());
                    for(int i = 0; i < nrProd; i ++) {
                        System.out.println("Ce produs doriti sa adaugati in oferta de tip combo? (Introduceti numarul corespunzator)");
                        int idP = scanner.nextInt() - 1;
                        ofertaCombo.adaugareProdus(this.restaurant.getMeniu().getProduse().get(idP));
                    }
                    this.restaurant.eleminareOfertaNume(o.getDenumire());
                    this.restaurant.adaugareOferta(ofertaCombo);
                }
                else {
                    System.out.println("Nu exista aceasta oferta. Reluati procesul");
                }
            }
            else if(o instanceof OfertaMeniu) {
                System.out.println("Puteti modifica procentajul de reducere pentru oferta de tip meniu");
                System.out.println("Ce procentaj de reducere doriti?");
                int procentaj = scanner.nextInt();
                scanner.nextLine();
                OfertaMeniu ofertaMeniu = new OfertaMeniu(ID, o.getDenumire(), procentaj, restaurant.getMeniu());
                this.restaurant.eleminareOfertaNume(o.getDenumire());
                this.restaurant.adaugareOferta(ofertaMeniu);
            }
            System.out.println("Oferta " + nume + " a fost actualizata");
        }
        else {
            System.out.println("Nu exista aceasta oferta. Reluati procesul");
        }
    }

    // actualizeaza program
    public void actualizeazaProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Program actual: " + this.restaurant.getOraDeschidere() + "." + this.restaurant.getOraInchidere());
        System.out.println("Introduceti numarul corespunzator optiunii dvs. (ex.: 1, 2)");
        System.out.println("1. Actualizare ora deschidere");
        System.out.println("2. Actualizare ora inchidere");
        int optiune = scanner.nextInt();
        System.out.println("Introduceti noul program (format: ora.minut)");
        float ora = scanner.nextFloat();
        List<Restaurant> restauranteTemp = this.comparator.getRestaurante();
        if(optiune == 1) {
            this.restaurant.setOraDeschidere(ora);
        }
        else if(optiune == 2) {
            this.restaurant.setOraInchidere(ora);
        }
        else {
            System.out.println("Nu exista aceasta optiune. Reluati procesul");
        }
    }

    // actualizeaza pret
    public void actualizeazaPret() {
        List<Restaurant> restauranteTemp = this.comparator.getRestaurante();
        Scanner scanner = new Scanner(System.in);
        this.restaurant.getMeniu().afisareMeniu();
        System.out.println("Introduceti numarul corespunzator produsului al carui pret doriti sa il modificati");
        int nr = scanner.nextInt() - 1;
        if(nr >= this.restaurant.getMeniu().getProduse().size() || nr < 0) {
            System.out.println("Numar necorespunzator");
            return;
        }
        System.out.println("Nume produs " + this.restaurant.getMeniu().getProduse().get(nr).getDenumire() +
                           " pret vechi: " + this.restaurant.getMeniu().getProduse().get(nr).getPret());
        System.out.println("Introduceti noul pret: ");
        float pretNou = scanner.nextFloat();
        this.restaurant.getMeniu().getProduse().get(nr).setPret(pretNou);
        System.out.println("Nume produs " + this.restaurant.getMeniu().getProduse().get(nr).getDenumire() +
                           " pret nou: " + this.restaurant.getMeniu().getProduse().get(nr).getPret());
    }

    // modifica meniu
    public void modificaMeniu() {
        List<Restaurant> restauranteTemp = this.comparator.getRestaurante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul corespunzator optiunii dvs.");
        System.out.println("1. Adaugare produs");
        System.out.println("2. Eliminare produs");
        int optiune = scanner.nextInt();
        scanner.nextLine();
        if(optiune == 1) {
            System.out.println("Introduceti denumirea noului produs");
            String nume = scanner.nextLine();
            System.out.println("Introduceti pretul noului produs");
            float pret = scanner.nextFloat();
            System.out.println("Introduceti caloriile noului produs");
            float calorii = scanner.nextFloat();
            System.out.println("Introduceti o scurta descriere a noului produs");
            scanner.nextLine();
            String descriere = scanner.nextLine();
            Produs produsNou = new Produs(this.restaurant.getMeniu().getProduse().size(), nume, pret, descriere, calorii);
            this.restaurant.getMeniu().adaugaProdus(produsNou);
            System.out.println("Produsul a fost adaugat");
        }
        else if(optiune == 2 && this.restaurant.getMeniu().getProduse().size() > 0) {
            this.restaurant.getMeniu().afisareMeniu();
            System.out.println("Introduceti numarul corespunzator produsului pe care doriti sa il eliminati");
            int prod = scanner.nextInt() - 1;
            Produs p = this.restaurant.getMeniu().getProduse().get(prod);
            this.restaurant.getMeniu().eliminaProdusId(p.getId());
            System.out.println("Produsul a fost elimiat");
        }
        else {
            System.out.println("Nu exista aceasta optiune. Reluati procesul");
        }
        for (int i = 0; i < restauranteTemp.size(); i++) {
            if (restauranteTemp.get(i).getId() == this.restaurant.getId()) {
                restauranteTemp.set(i, this.restaurant);
                break;
            }
        }
        this.comparator.setRestaurante(restauranteTemp);
    }

}
