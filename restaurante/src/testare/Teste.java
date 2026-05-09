package testare;

import clase.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    private Administrator admin;
    private Comparator comparator;

    @BeforeEach
    public void setUp() {
        // Inițializăm mediul de test înainte de fiecare metodă
        comparator = new Comparator();
        admin = new Administrator(1, "admin@test.ro", "admin_test", "parola", "administrator");
        admin.asignareComparator(comparator);
    }

    @Test
    public void testAdaugaRestaurant() {
        // Pregătim un restaurant nou
        Restaurant rNou = new Restaurant(100, "Restaurant Test", "Strada Test nr. 1", 2.5f, 10.0f, 22.0f, 4.5f, SpecificRestaurant.Romanesc, 100);

        // Acțiune
        admin.adaugaRestaurant(rNou);

        // Verificare
        List<Restaurant> lista = comparator.getRestaurante();
        assertEquals(1, lista.size(), "Lista ar trebui să conțină un restaurant după adăugare.");
        assertEquals("Restaurant Test", lista.get(0).getDenumire());
        assertTrue(lista.contains(rNou), "Restaurantul adăugat ar trebui să se afle în lista comparatorului.");
    }

    @Test
    public void testStergeRestaurantExistent() {
        // Adăugăm un restaurant pentru a-l șterge
        Restaurant r1 = new Restaurant(1, "De Sters", "Adresa", 1.0f, 10.0f, 20.0f, 4.0f, SpecificRestaurant.FastFood, 1);
        admin.adaugaRestaurant(r1);

        // Acțiune: ștergem restaurantul cu ID-ul 1
        boolean rezultat = admin.stergeRestaurant(1);

        // Verificare
        assertTrue(rezultat, "Metoda ar trebui să returneze true la ștergerea unui ID existent.");
        assertEquals(0, comparator.getRestaurante().size(), "Lista ar trebui să fie goală după ștergere.");
    }

    @Test
    public void testStergeRestaurantInexistent() {
        // Încercăm să ștergem ceva dintr-o listă goală sau un ID care nu există
        boolean rezultat = admin.stergeRestaurant(999);

        // Verificare
        assertFalse(rezultat, "Metoda ar trebui să returneze false pentru un ID care nu există.");
    }

    @Test
    public void testGetTopRestaurante() {
        // Adăugăm restaurante cu note diferite
        Restaurant rSlab = new Restaurant(1, "Slab", "Adresa", 1.0f, 10.0f, 20.0f, 2.0f, SpecificRestaurant.FastFood, 1);
        Restaurant rBun = new Restaurant(2, "Bun", "Adresa", 1.0f, 10.0f, 20.0f, 4.9f, SpecificRestaurant.Italienesc, 2);
        Restaurant rMediu = new Restaurant(3, "Mediu", "Adresa", 1.0f, 10.0f, 20.0f, 3.5f, SpecificRestaurant.Romanesc, 3);

        admin.adaugaRestaurant(rSlab);
        admin.adaugaRestaurant(rBun);
        admin.adaugaRestaurant(rMediu);

        // Acțiune
        List<Restaurant> top = admin.getTopRestaurante();

        // Verificări
        assertEquals(3, top.size());
        assertEquals("Bun", top.get(0).getDenumire(), "Primul restaurant în top ar trebui să fie cel cu nota cea mai mare.");
        assertEquals(4.9f, top.get(0).getNotaMedie());
        assertEquals("Slab", top.get(2).getDenumire(), "Ultimul în top ar trebui să fie cel cu nota cea mai mică.");
    }
}