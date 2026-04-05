public class Utilizator {
    // Atribute
    private int id;
    private String email, numeUtilizator, parola, rol;
    private boolean esteAutentificat = false;

    // Getters, Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Constructor default
    public Utilizator() {}

    // Constructor cu parametri
    public Utilizator(int id, String email, String numeUtilizator, String parola, String rol) {
       this.id = id;
       this.email = email;
       this.numeUtilizator = numeUtilizator;
       this.parola = parola;
       this.rol = rol;
    }

    public Utilizator(String email, String numeUtilizator, String parola, String rol) {
        this.email = email;
        this.numeUtilizator = numeUtilizator;
        this.parola = parola;
        this.rol = rol;
    }

    // Metode
    // Autentificare
    // Deconectare
    public void deconectare() {
        System.out.println("Deconectarea a avut loc cu succes.");
        this.esteAutentificat = false;
        this.id = 0;
        this.numeUtilizator = null;
        this.email = null;
        this.parola = null;
        this.rol = null;
    }
}
