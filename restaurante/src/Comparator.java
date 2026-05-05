import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Comparator {


    private List<Restaurant> restaurante;
    private List<Oferta> listaOferte;

    public Comparator() {
        this.restaurante = new ArrayList<>();
        this.listaOferte = new ArrayList<>();
    }

    public Comparator(List<Restaurant> restaurante) {
        this.restaurante = restaurante;
        this.listaOferte = extraeToateOfertele(restaurante);
    }


    public List<Restaurant> getRestaurante() { return restaurante; }

    public void setRestaurante(List<Restaurant> restaurante) {
        this.restaurante = restaurante;
        this.listaOferte = extraeToateOfertele(restaurante); // CRITIC: Actualizam si ofertele!
    }

    public List<Oferta> getListaOferte() { return listaOferte; }

    public void setListaOferte(List<Oferta> listaOferte) { this.listaOferte = listaOferte; }
}


    public List<Restaurant> filtrareDistanta(List<Restaurant> lista, float distantaMax) {
        return lista.stream()
                .filter(r -> r.getDistanta() <= distantaMax)
                .collect(Collectors.toList());
    }

    public List<Restaurant> filtrareRecenzii(List<Restaurant> lista, float notaMinima) {
        return lista.stream()
                .filter(r -> r.getNotaMedie() >= notaMinima)
                .collect(Collectors.toList());
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

    public List<Oferta> filtrarePret(List<Oferta> oferte, float pretMax) {
        return oferte.stream()
                .filter(o -> o.getPret() <= pretMax)
                .collect(Collectors.toList());
    }


    public List<Restaurant> cautaRestaurant(String nume) {
        return restaurante.stream()
                .filter(r -> r.getDenumire().equalsIgnoreCase(nume))
                .collect(Collectors.toList());
    }

    public List<Produs> cautaProdus(String numeProdus) {
        List<Produs> gasite = new ArrayList<>();
        for (Restaurant r : restaurante) {
            for (Produs p : r.getListaProduse()) {
                if (p.getDenumire().equalsIgnoreCase(numeProdus)) gasite.add(p);
            }
        }
        return gasite;
    }

    public Oferta selecteazaOferta(int id) {
        for (Oferta o : this.listaOferte) {
            if (o.getId() == id) return o;
        }
        return null;
    }


    public List<Oferta> comparaOferte(float distantaMax, float notaMin, int reducereMin, float pretMax) {
        List<Restaurant> rApropiate = filtrareDistanta(this.restaurante, distantaMax);
        List<Restaurant> rBune = filtrareRecenzii(rApropiate, notaMin);
        List<Oferta> oferteColectate = extraeToateOfertele(rBune);
        List<Oferta> oferteReduse = filtrareProcentReducere(oferteColectate, reducereMin);
        return filtrarePret(oferteReduse, pretMax);
    }


    private List<Oferta> extraeToateOfertele(List<Restaurant> listaRestaurante) {
        List<Oferta> toate = new ArrayList<>();
        if (listaRestaurante == null) return toate;
        for (Restaurant r : listaRestaurante) {
            if (r.getOferteMeniu() != null) toate.addAll(r.getOferteMeniu());
            if (r.getOferteProduse() != null) toate.addAll(r.getOferteProduse());
        }
        return toate;
    }


