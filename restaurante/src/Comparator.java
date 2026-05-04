import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {

    private int idOferta1;
    private int idOferta2;


    public Comparator() {
    }

    // Constructor cu parametri
    public Comparator(int idOferta1, int idOferta2) {
        this.idOferta1 = idOferta1;
        this.idOferta2 = idOferta2;
    }


    public int getIdOferta1() {
        return idOferta1;
    }

    public void setIdOferta1(int idOferta1) {
        this.idOferta1 = idOferta1;
    }

    public int getIdOferta2() {
        return idOferta2;
    }

    public void setIdOferta2(int idOferta2) {
        this.idOferta2 = idOferta2;
    }


    public void filtrareDistanta() {

        System.out.println("Filtrare dupa distanta executata.");
    }

    public List<Oferta> filtrareProcentReducere(List<Oferta> oferte, int pragMinim) {

        return oferte.stream()
                .filter(o -> {
                    if (o instanceof OfertaMeniu) return ((OfertaMeniu) o).getReducere() >= pragMinim;
                    if (o instanceof OfertaProdus) return ((OfertaProdus) o).getReducere() >= pragMinim;
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<Restaurant> filtrareRecenzii(List<Restaurant> restaurante, float notaMinima) {

        return restaurante.stream()
                .filter(r -> r.getNotaMedie() >= notaMinima)
                .collect(Collectors.toList());
    }

    public void filtrarePret() {

        System.out.println("Filtrare dupa pret executata.");
    }


    public int comparaOferte(Oferta o1, Oferta o2) {

        this.idOferta1 = o1.getId();
        this.idOferta2 = o2.getId();


        return Integer.compare(this.idOferta1, this.idOferta2);
    }

    public Oferta selecteazaOferta(List<Oferta> oferte, int idCautat) {

        for (Oferta o : oferte) {
            if (o.getId() == idCautat) {
                return o;
            }
        }
        return null;
    }

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

    // Filtreaza oferte
    public List<Oferta> filtreazaOferte(List<Oferta> oferte, String criteriu, float prag) {
        if (criteriu.equalsIgnoreCase("pret")) {
            return this.filtrarePret();
        }
        else if (criteriu.equalsIgnoreCase("distanta")) {
            return this.filtrareDistanta();
        }
        else if (criteriu.equalsIgnoreCase("procent reducere")) {
            return this.filtrareProcentReducere(oferte, prag);
        }
        else if (criteriu.equalsIgnoreCase("recenzii")) {
            return this.filtrareRecenzii();
        }
    }

}