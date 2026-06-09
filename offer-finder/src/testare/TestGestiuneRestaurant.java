package testare;

import clase.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class TestGestiuneRestaurant {
    private Administrator admin;
    private Comparator comparator;

    @BeforeEach
    public void setUp() {
        comparator = new Comparator();
        admin = new Administrator(1, "admin@restaurant.ro", "admin_system", "hash_parola", "administrator");
        admin.asignareComparator(comparator);
    }

    @Test
    public void testAdaugareRestaurantSucces() {
        Restaurant r = new Restaurant(101, "Hanu' lui Manuc", "Strada Franceza 62", 0.1f, 9.0f, 23.5f, 4.7f, SpecificRestaurant.Romanesc, 101);

        admin.adaugaRestaurant(r);

        List<Restaurant> lista = comparator.getRestaurante();
        assertEquals(1, lista.size(), "Lista trebuie sa contina un restaurant.");
        assertEquals("Hanu' lui Manuc", lista.get(0).getDenumire());
        assertTrue(lista.contains(r));
    }

    @Test
    public void testAdaugareSuccesivaInBucla() {
        int numarRestaurante = 5;
        for (int i = 1; i <= numarRestaurante; i++) {
            Restaurant r = new Restaurant(i, "Restaurant " + i, "Adresa " + i, (float) i, 10.0f, 22.0f, 4.0f, SpecificRestaurant.Romanesc, i);
            admin.adaugaRestaurant(r);
        }

        assertEquals(numarRestaurante, comparator.getRestaurante().size());
    }

    @Test
    public void testStergereRestaurantExistent() {
        Restaurant r1 = new Restaurant(10, "Caru' cu Bere", "Stavropoleos 5", 0.2f, 11, 24, 4.8f, SpecificRestaurant.Romanesc, 10);
        admin.adaugaRestaurant(r1);

        boolean rezultat = admin.stergeRestaurant(10);

        assertTrue(rezultat, "Trebuie sa returneze true pentru un ID existent.");
        assertEquals(0, comparator.getRestaurante().size());
    }

    @Test
    public void testStergereRestaurantInexistent() {
        boolean rezultat = admin.stergeRestaurant(999);

        assertFalse(rezultat, "Trebuie sa returneze false pentru un ID care nu exista in lista.");
    }

    @Test
    public void testModificaRestaurantExistent() {
        Restaurant r1 = new Restaurant(1, "Nume Vechi", "Adresa", 1.0f, 10, 22, 4.0f, SpecificRestaurant.FastFood, 1);
        admin.adaugaRestaurant(r1);

        boolean rezultat = admin.modificaRestaurant(1, "Nume Nou", "Adresa Noua", 11.0f, 23.0f, SpecificRestaurant.Romanesc, new Meniu(1), new ArrayList<>());

        assertTrue(rezultat);
        Restaurant rModificat = comparator.getRestaurante().get(0);
        assertEquals("Nume Nou", rModificat.getDenumire());
        assertEquals(SpecificRestaurant.Romanesc, rModificat.getTip());
    }

    @Test
    public void testStergereInBuclaPanaLaListaVida() {
        admin.adaugaRestaurant(new Restaurant(1, "R1", "A1", 1, 10, 22, 4, SpecificRestaurant.FastFood, 1));
        admin.adaugaRestaurant(new Restaurant(2, "R2", "A2", 2, 10, 22, 5, SpecificRestaurant.FastFood, 2));

        List<Restaurant> deSters = new ArrayList<>(comparator.getRestaurante());
        for (Restaurant r : deSters) {
            assertTrue(admin.stergeRestaurant(r.getId()));
        }

        assertTrue(comparator.getRestaurante().isEmpty(), "Lista trebuie sa fie vida.");
    }

    @Test
    public void testLimitaInferioaraDate() {
        Restaurant rLimita = new Restaurant(0, "", "", 0.0f, 0.0f, 0.0f, 0.0f, SpecificRestaurant.FastFood, 0);
        admin.adaugaRestaurant(rLimita);

        assertNotNull(comparator.getRestaurantById(0));
        assertEquals(0.0f, comparator.getRestaurantById(0).getDistanta());
    }
}