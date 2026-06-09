package clase;

// Relatie de generalizare intre clasele Client si Utilizator (mostenire)
public class Client extends Utilizator {
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

    // Creeaza legatura cu un obiect de tip Comparator (asociatie)
    public void asignareComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    // Getter
    public Comparator getComparator() {
        return comparator;
    }

    public void afiseazaDateClient() {
        System.out.println("\nDate Client: ");
        System.out.println("Nume Utilizator Client: " + getNumeUtilizator());
        System.out.println("ID Client: " + getId());
        System.out.println("Email: " + getEmail());
        System.out.println("Rol: " + getRol());
    }

}