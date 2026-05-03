import java.util.ArrayList;
import java.util.List;

// Relatie de generalizare intre clasele Client si Utilizator (mostenire)
public class Client extends Utilizator{
    // Relatie de asociatie intre clasele comparator si client
    private Comparator comparator;

    // Constructor default
    public Client() {
        super();
    }

    // Constructor cu parametri
    public Client(int id, String email, String numeUtilizator, String parola, String rol) {
        super(id, email, numeUtilizator, parola, rol);
    }

    // Metode
    // Cauta un produs in functie de nume
    public List<Produs> cautaProdus(List <Produs> produse, String numeProdus) {
        List<Produs> produseDisponibile = new ArrayList<>();

        for (Produs produs : produse) {
            String numeProdusCurent = produs.getDenumire();
            if (numeProdusCurent.equalsIgnoreCase(numeProdus)) {
                produseDisponibile.add(produs);
            }
        }
        return produseDisponibile;
    }

    // Cauta un restaurant in functie de nume
    public List<Restaurant> cautaRestaurant(List <Restaurant> restaurante, String numeRestaurant) {
        List<Restaurant> restauranteDisponibile = new ArrayList<>();

        for (Restaurant restaurant : restaurante) {
            String numeRestaurantCurent = restaurant.getDenumire();
            if (numeRestaurantCurent.equalsIgnoreCase(numeRestaurant)) {
                restauranteDisponibile.add(restaurant);
            }
        }
        return  restauranteDisponibile;
    }

    // Creeaza legatura cu un obiect de tip Comparator (asociatie)
    public void asignareComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    // Compara doua oferte
    public int comparaOferte(Oferta oferta1, Oferta oferta2) {
        return this.comparator.comparaOferte(oferta1, oferta2);
    }

    // Filtreaza oferte
    public List<Oferta> filtreazaOferte(List<Oferta> oferte, String criteriu, float prag) {
        if (criteriu.equalsIgnoreCase("pret")) {
            return this.comparator.filtrarePret();
        }
        else if (criteriu.equalsIgnoreCase("distanta")) {
            return this.comparator.filtrareDistanta();
        }
        else if (criteriu.equalsIgnoreCase("procent reducere")) {
            return this.comparator.filtrareProcentReducere(oferte, prag);
        }
        else if (criteriu.equalsIgnoreCase("recenzii")) {
            return this.comparator.filtrareRecenzii();
        }
    }
}