import java.util.List;
import java.util.stream.Collectors;

// Relatie de generalizare intre clasele Administrator si Utilizator (mostenire)
public class Administrator extends Utilizator{
    // Relatie de asociatie intre clasele administrator si comparator
    private Comparator comparator;

    // Constructor default
    public Administrator() {
        super();
    }

    // Constructor cu parametri
    public Administrator(int id, String email, String numeUtilizator, String parola, String rol) {
        super(id, email, numeUtilizator, parola, rol);
    }

    // Metode

    // Creeaza legatura cu un obeict de tip comparator
    public void asignareComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    // Getter
    public Comparator getComparator() {
        return comparator;
    }

    // Adauga restaurant
    public void adaugaRestaurant(Restaurant restaurant) {
        List<Restaurant> restaurante = this.comparator.getRestaurante();

        if (restaurant != null) {
            restaurante.add(restaurant);
            this.comparator.setRestaurante(restaurante);
        }
    }

    // Sterge restaurant in functie de id
    public boolean stergeRestaurant(int idRestaurant) {
        List<Restaurant> restaurante = this.comparator.getRestaurante();

        for (int i = 0; i < restaurante.size(); i++) {
            if (restaurante.get(i).getId() == idRestaurant) {
                restaurante.remove(i);
                this.comparator.setRestaurante(restaurante);
                return true;
            }
        }
        return false;
    }

    // Actualizeaza datele unui restaurant
    public boolean modificaRestaurant(int idRestaurant,
                                      String denumireNoua, String adresaNoua,
                                      float oraDeschidereNoua, float oraInchidereNoua,
                                      SpecificRestaurant tipNou, Meniu meniu, List<Oferta> oferte) {
        List<Restaurant> restaurante = this.comparator.getRestaurante();

        for (Restaurant r : restaurante) {
            if (r.getId() == idRestaurant) {
                r.setDenumire(denumireNoua);
                r.setAdresaRestaurant(adresaNoua);
                r.setOraDeschidere(oraDeschidereNoua);
                r.setOraInchidere(oraInchidereNoua);
                r.setTip(tipNou);
                r.setMeniu(meniu);
                r.setOferteValide(oferte);
                return true;
            }
        }
        return false;
    }

    // Genereaza statistici despre restaurante
    public void genereazaStatistici() {
        List<Restaurant> restaurante = this.comparator.getRestaurante();
        
        System.out.println("Numar total restaurante: " + restaurante.size());

        System.out.println("\nRestaurante disponibile: ");
        for (Restaurant r : restaurante) {
            System.out.println("Restaurant: " + r.getDenumire() + " | Nota medie: " + r.getNotaMedie());
        }

        System.out.println("\nTop 10 restaurante dupa nota:");
        List<Restaurant> topRestaurante = getTopRestaurante();
        for (int i = 0; i < topRestaurante.size(); i++) {
            System.out.println((i + 1) + ". " + topRestaurante.get(i).getDenumire() + " | " + topRestaurante.get(i).getNotaMedie());
        }
    }

    // Returneaza lista cu top 10 restaurante dupa nota
    public List<Restaurant> getTopRestaurante() {
        List<Restaurant> restaurante = this.comparator.getRestaurante();

        return restaurante.stream().sorted(java.util.Comparator.comparing(Restaurant::getNotaMedie).reversed()).limit(10).collect(Collectors.toList());
    }

}