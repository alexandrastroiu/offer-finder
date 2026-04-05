import java.util.Scanner;

import java.util.Scanner;
public class ManagerRestaurant
// extends Utilizator
{
    private Restaurant restaurant;

    // constructori
    public ManagerRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

//    public ManagerRestaurant() {
//        super();
//    }
//
//    public ManagerRestaurant(int id, String email, String numeUtilizator, String parola, String rol, Restaurant restaurant) {
//        super(id, email, numeUtilizator, parola, rol);
//        this.restaurant = restaurant;
//    }


    // getters si setters

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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
        switch (optiune) {
            case 1:
                System.out.println("Ce procentaj de reducere doriti?");
                int procentaj = scanner.nextInt();
                System.out.println("Ce denumire doriti sa aiba oferta?");
                String denumire = scanner.next();
                OfertaMeniu ofertaMeniu = new OfertaMeniu(this.restaurant.getOferteValide().size(), denumire, procentaj);
                this.restaurant.adaugareOferta(ofertaMeniu);
                break;

            case 2:
                System.out.println("Ce procentaj de reducere doriti?");
                int reducere = scanner.nextInt();
                System.out.println("Carui produs doriti sa ii atribuiti reducerea? (Introduceti numarul corespunzator)");
                this.restaurant.getMeniu().afisareMeniu();
                int idProd = scanner.nextInt() - 1;
                System.out.println("Ce denumire doriti sa aiba oferta?");
                String numeOfertaProdus = scanner.next();
                OfertaProdus ofertaProdus = new OfertaProdus(this.restaurant.getOferteValide().size(), numeOfertaProdus, reducere);
                ofertaProdus.setProdus(this.restaurant.getMeniu().getProduse().get(idProd));
                this.restaurant.adaugareOferta(ofertaProdus);
                break;

            case 3:
                System.out.println("Ce pret doriti sa aiba oferta de tip combo?");
                float pret = scanner.nextFloat();
                System.out.println("Ce denumire doriti sa aiba oferta?");
                String numeOfertaCombo = scanner.next();
                OfertaCombo ofertaCombo = new OfertaCombo(this.restaurant.getOferteValide().size(), numeOfertaCombo, pret);
                System.out.println("Cate produse doriti sa aiba oferta de tip combo?");
                int nrProd = scanner.nextInt();
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
        String nume = scanner.next();
        if(this.restaurant.getOferteValide().stream().filter(oferta -> (oferta.getDenumire().equals(nume))).findAny().orElse(null) != null) {
            this.restaurant.eleminareOfertaNume(nume);
            System.out.println("Oferta " + nume + " nu mai este valida");
        }
        else {
            System.out.println("Nu exista aceasta oferta. Reluati procesul");
        }
    }

    // actualizeaza program
    public void actualizeazaProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul corespunzator optiunii dvs. (ex.: 1, 2)");
        System.out.println("1. Actualizare ora deschidere");
        System.out.println("2. Actualizare ora inchidere");
        int optiune = scanner.nextInt();
        System.out.println("Introduceti noul program (format: ora.minut)");
        float ora = scanner.nextFloat();
        if(optiune == 1) {
            this.restaurant.setOraDeshidere(ora);
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
        Scanner scanner = new Scanner(System.in);
        this.restaurant.getMeniu().afisareMeniu();
        System.out.println("Introduceti numarul corespunzator produsului al carui pret doriti sa il modificati");
        int prodId = scanner.nextInt() - 1;
        System.out.println("Nume produs " + this.restaurant.getMeniu().getProduse().get(prodId).getDenumire() +
                           " pret vechi: " + this.restaurant.getMeniu().getProduse().get(prodId).getPret());
        System.out.println("Introduceti noul pret: ");
        float pretNou = scanner.nextFloat();
        this.restaurant.getMeniu().getProduse().get(prodId).setPret(pretNou);
        System.out.println("Nume produs " + this.restaurant.getMeniu().getProduse().get(prodId).getDenumire() +
                           " pret nou: " + this.restaurant.getMeniu().getProduse().get(prodId).getPret());
    }

    // modifica meniu




}
