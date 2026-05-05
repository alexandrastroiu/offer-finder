import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {

    private List<Oferta> listaOferte;

    // Constructori
    public Comparator() {
        this.listaOferte = new ArrayList<>();
    }

    public Comparator(List<Oferta> listaOferte) {
        this.listaOferte = listaOferte;
    }

    // Getters si Setters
    public List<Oferta> getListaOferte() {
        return listaOferte;
    }

    public void setListaOferte(List<Oferta> listaOferte) {
        this.listaOferte = listaOferte;
    }



    //  Filtrare dupa distanta
    public List<Restaurant> filtrareDistanta(List<Restaurant> restaurante, float distantaMax) {
        return restaurante.stream()
                .filter(r -> r.getDistanta() <= distantaMax)
                .collect(Collectors.toList());
    }

    //  Filtrare dupa recenzii
    public List<Restaurant> filtrareRecenzii(List<Restaurant> restaurante, float notaMinima) {
        return restaurante.stream()
                .filter(r -> r.getNotaMedie() >= notaMinima)
                .collect(Collectors.toList());
    }

    //  Filtrare dupa procent de reducere
    public List<Oferta> filtrareProcentReducere(List<Oferta> oferte, int pragMinim) {
        return oferte.stream()
                .filter(o -> {
                    if (o instanceof OfertaMeniu) return ((OfertaMeniu) o).getReducere() >= pragMinim;
                    if (o instanceof OfertaProdus) return ((OfertaProdus) o).getReducere() >= pragMinim;
                    return false;
                })
                .collect(Collectors.toList());
    }

    //  Filtrare dupa pret
    public List<Oferta> filtrarePret(List<Oferta> oferte, float pretMax) {
        return oferte.stream()
                .filter(o -> {
                    if (o instanceof OfertaCombo) return ((OfertaCombo) o).getPretCombo() <= pretMax;
                    return true;
                })
                .collect(Collectors.toList());
    }


    // algoritmul de comparare

    public List<Oferta> comparaOferte(List<Restaurant> restauranteDisponibile, float distantaMax, float notaMinima, int procentMinim, float pretMax) {

        List<Restaurant> restauranteApropiate = filtrareDistanta(restauranteDisponibile, distantaMax);

        List<Restaurant> restauranteBune = filtrareRecenzii(restauranteApropiate, notaMinima);

        List<Oferta> oferteExtrase = restauranteBune.stream()
                .flatMap(r -> r.getOferteValide().stream())
                .collect(Collectors.toList());


        List<Oferta> oferteCuReducere = filtrareProcentReducere(oferteExtrase, procentMinim);


        return filtrarePret(oferteCuReducere, pretMax);
    }




    public Oferta selecteazaOferta(int idCautat) {
        for (Oferta o : this.listaOferte) {
            if (o.getId() == idCautat) {
                return o;
            }
        }
        return null;
    }

    public List<Produs> cautaProdus(List<Produs> produse, String numeProdus) {
        List<Produs> produseDisponibile = new ArrayList<>();
        for (Produs produs : produse) {
            if (produs.getDenumire().equalsIgnoreCase(numeProdus)) {
                produseDisponibile.add(produs);
            }
        }
        return produseDisponibile;
    }

    public List<Restaurant> cautaRestaurant(List<Restaurant> restaurante, String numeRestaurant) {
        List<Restaurant> restauranteDisponibile = new ArrayList<>();
        for (Restaurant restaurant : restaurante) {
            if (restaurant.getDenumire().equalsIgnoreCase(numeRestaurant)) {
                restauranteDisponibile.add(restaurant);
            }
        }
        return restauranteDisponibile;
    }
}