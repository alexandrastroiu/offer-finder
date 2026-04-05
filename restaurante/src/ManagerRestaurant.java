import java.util.Scanner;

import java.util.Scanner;
public class ManagerRestaurant {
    private Restaurant restaurant;

    // constructor
    public ManagerRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // getters si setters





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
                System.out.println("Introduceti o optiune valida (1, 2 sau 3)");
                System.out.println("1. Reducere pentru tot meniul");
                System.out.println("2. Reducere pentru un produs anume");
                System.out.println("3. Oferta combo");
                break;

        }
    }

    // elimina oferta
    public void eliminaOferta() {
        Scanner scanner = new Scanner(System.in);
        this.restaurant.afisareOferte();
        System.out.println("Introduceti denumirea ofertei pe care doriti sa o eliminati");
        String nume = scanner.next();
        this.restaurant.eleminareOfertaNume(nume);
        System.out.println("Oferta " + nume + " nu mai este valida");
    }


    // actualizeaza program





    // actualizeaza pret





    // modifica meniu




}
