import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

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
    // Consideram ca datele utilizatorilor se afla intr-un fisier de tip CSV
    public boolean autentificare(String usernameIntrodus, String parolaIntrodusa, String fisier) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fisier));
            String linie;

            // Citeste linie cu linie din fisierul CSV
            while ((linie = br.readLine()) != null) {
                String[] dateUtilizator = linie.split(",");
                if (dateUtilizator.length == 5) {
                    int idUtilizator = Integer.parseInt(dateUtilizator[0]);
                    String emailUtilizator = dateUtilizator[1];
                    String username = dateUtilizator[2];
                    String parolaHash = dateUtilizator[3];
                    String rolUtilizator = dateUtilizator[4];
                    String parolaHashIntrodusa = "";

                    try {
                        MessageDigest message = MessageDigest.getInstance("SHA-256");
                        byte[] hashBytes = message.digest(parolaIntrodusa.getBytes(StandardCharsets.UTF_8));
                        StringBuilder sb = new StringBuilder();

                        for (byte b : hashBytes) {
                            sb.append(String.format("%02x", b));
                        }

                        parolaHashIntrodusa = sb.toString();
                    } catch (NoSuchAlgorithmException e) {
                        System.out.println("Eroare la hash-uirea parolei introduse.");
                        br.close();
                        return false;
                    }

                    if (username.equals(usernameIntrodus) && parolaHash.equals(parolaHashIntrodusa)) {
                        this.id = idUtilizator;
                        this.email = emailUtilizator;
                        this.numeUtilizator = username;
                        this.parola = parolaHash;
                        this.rol = rolUtilizator;
                        this.esteAutentificat = true;
                        br.close();
                        return true;
                    }
                }
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println("A avut loc o eroare in timpul autentificarii.");
        }
        return false;
    }

    // Deconectare
    public void deconectare() {
        System.out.println("\nDeconectarea a avut loc cu succes.");
        this.esteAutentificat = false;
        this.id = 0;
        this.numeUtilizator = null;
        this.email = null;
        this.parola = null;
        this.rol = null;
    }
}
