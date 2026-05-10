package testare;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clase.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ManagerRestaurantTest {

    private Restaurant restaurant;
    private ManagerRestaurant manager;
    private Comparator comparator;
    private final InputStream systemIn = System.in;

    @BeforeEach
    void setUp() {
        restaurant = new Restaurant(
                1,
                "Dodo Pizza",
                "Bulevardul Iuliu Maniu 7",
                0.3f,
                10.0f,
                23.0f,
                4.5f,
                SpecificRestaurant.FastFood,
                1
        );
        restaurant.getMeniu().setProduse(Main.creeazaListaProduse(
                new Produs(1, "Pizza Quatro Formaggi", 30, "", 850),
                new Produs(2, "Pizza Margherita", 25, "", 600),
                new Produs(3, "Pizza Prosciutto", 33 , "", 670),
                new Produs(4, "Paste", 38 , "", 65)
        ));
        comparator = new Comparator();
        comparator.addRestaurant(restaurant);
        manager = new ManagerRestaurant(3, "dan54@gmail.com" , "dan", "manager@123", "manager", restaurant, restaurant.getId());
        manager.setComparator(comparator);
    }

    @AfterEach
    void restoreSystemInput() {
        System.setIn(systemIn);
    }

    // metoda pt a simula input de la tastatura
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void adaugareOfertaMeniu() {
        List<Float> preturiOriginale = new ArrayList<>();
        for (Produs p : restaurant.getMeniu().getProduse()) {
            preturiOriginale.add(p.getPret());
        }

        provideInput("1\n20\nReducere Meniu\n");
        manager.adaugareOferta();

        assertEquals(1, restaurant.getOferteValide().size());
        assertTrue(restaurant.getOferteValide().get(0) instanceof OfertaMeniu);
        assertEquals("Reducere Meniu", restaurant.getOferteValide().get(0).getDenumire());

        List<Produs> produseActuale = restaurant.getMeniu().getProduse();

        for (int i = 0; i < produseActuale.size(); i++) {
            float pretInitial = preturiOriginale.get(i);
            float pretDupaReducere = produseActuale.get(i).getPret();
            float pretRedusExpected = pretInitial - (20.0f / 100.0f) * pretInitial;
            assertEquals(pretRedusExpected, pretDupaReducere);
        }
    }

    @Test
    void adaugareOfertaMeniuProcentImposibil() {
        float pretInainte = restaurant.getMeniu().getProduse().get(0).getPret();

        // adaugare oferta cu procent imposibil
        provideInput("1\n110\n");

        // verificari
        assertDoesNotThrow(() -> manager.adaugareOferta());
        assertEquals(0, restaurant.getOferteValide().size());

        // verificare pret identic
        float pretDupa = restaurant.getMeniu().getProduse().get(0).getPret();
        assertEquals(pretInainte, pretDupa, "Preturile nu ar trebui sa se modifice pentru o oferta invalida!");
    }

    @Test
    void adaugareOfertaProdus() {
        // input de la tastatura: optiunea 2 = oferta produs, procent = 10, produs = 4 (Paste), nume oferta = Reducere Paste
        provideInput("2\n10\n4\nReducere Paste\n");
        manager.adaugareOferta();
        assertEquals(1, restaurant.getOferteValide().size());
        assertTrue(restaurant.getOferteValide().get(0) instanceof OfertaProdus);
        assertEquals("Reducere Paste", restaurant.getOferteValide().get(0).getDenumire());
        // verificare salvare pret redus
        float pretRedus = restaurant.getMeniu().getProduse().stream().filter(p -> p.getDenumire().equals("Paste")).collect(Collectors.toList()).getFirst().getPret();
        float pretRedusExpected = 38.0f - (10.0f / 100) * 38.0f;
        assertEquals(pretRedusExpected, pretRedus);
    }

    @Test
    void adaugareOfertaCombo() {
        // input de la tastatura: optiunea 3 = oferta combo, pret = 45, produse = 2 (pizza quatro si pizza margherita), nume oferta = Oferta Combo
        provideInput("3\n45\nOferta Combo\n2\n1\n2\n");
        manager.adaugareOferta();
        assertEquals(1, restaurant.getOferteValide().size());
        assertTrue(restaurant.getOferteValide().get(0) instanceof OfertaCombo);
        assertEquals("Oferta Combo", restaurant.getOferteValide().get(0).getDenumire());
        // verificare salvare pret
        OfertaCombo ofertaCombo = (OfertaCombo) restaurant.getOferteValide().get(0);
        assertEquals(45, ofertaCombo.getPretCombo());
        // verificare salvare produse
        assertEquals(restaurant.getMeniu().getProduse().get(0), ofertaCombo.getProduseParticipante().get(0));
        assertEquals(restaurant.getMeniu().getProduse().get(1), ofertaCombo.getProduseParticipante().get(1));
    }

    @Test
    void eliminaOfertaCombo() {
        // adaugare oferta combo pentru a o sterge
        provideInput("3\n45\nOferta Combo\n2\n1\n2\n");
        manager.adaugareOferta();

        // stergere oferta
        provideInput("Oferta Combo\n");
        manager.eliminaOferta();
        assertEquals(0, restaurant.getOferteValide().size());
    }

    @Test
    void eliminaOfertaMeniu() {
        // adaugare oferta pentru a o sterge
        List<Float> preturiOriginale = new ArrayList<>();
        for (Produs p : restaurant.getMeniu().getProduse()) {
            preturiOriginale.add(p.getPret());
        }

        provideInput("1\n20\nReducere Meniu\n");
        manager.adaugareOferta();

        // stergere oferta meniu
        provideInput("Reducere Meniu\n");
        manager.eliminaOferta();
        assertEquals(0, restaurant.getOferteValide().size());

        // verificare revenire la pretul original
        List<Produs> produseActuale = restaurant.getMeniu().getProduse();

        for (int i = 0; i < produseActuale.size(); i++) {
            float pretInitial = preturiOriginale.get(i);
            float pretDupaOferta = produseActuale.get(i).getPret();
            assertEquals(pretInitial, pretDupaOferta);
        }
    }

    @Test
    void eliminaOfertaProdus() {
        // adaugare oferta pentru a o sterge
        float pretInitial = restaurant.getMeniu().getProduse().get(3).getPret();
        provideInput("2\n10\n4\nReducere Paste\n");
        manager.adaugareOferta();

        // stergere oferta meniu
        provideInput("Reducere Paste\n");
        manager.eliminaOferta();
        assertEquals(0, restaurant.getOferteValide().size());

        // verificare revenire la pretul original
        float pretDupaOferta = restaurant.getMeniu().getProduse().stream().filter(p -> p.getDenumire().equals("Paste")).collect(Collectors.toList()).getFirst().getPret();
        assertEquals(pretInitial, pretDupaOferta);
    }

    @Test
    void eliminaOfertaListaNula() {
        // verificare lista goala
        assertTrue(restaurant.getOferteValide().isEmpty());
        // eliminare oferta inexistenta
        provideInput("OfertaInexistenta\n");
        assertDoesNotThrow(() -> manager.eliminaOferta());
        assertEquals(0, restaurant.getOferteValide().size());
    }

    @Test
    void eliminaOfertaInexistenta() {
        provideInput("2\n10\n4\nReducere Paste\n");
        manager.adaugareOferta();
        // eliminare oferta inexistenta
        provideInput("OfertaInexistenta\n");
        assertDoesNotThrow(() -> manager.eliminaOferta());
        assertEquals(1, restaurant.getOferteValide().size());
    }

    @Test
    void actualizareOfertaMeniu() {
        float pretInitial = restaurant.getMeniu().getProduse().get(0).getPret();
        // adaugare oferta
        OfertaMeniu initiala = new OfertaMeniu(1, "Reducere Meniu", 10, restaurant.getMeniu());
        restaurant.adaugareOferta(initiala);

        // actualizare oferta reducere = 30%
        provideInput("Reducere Meniu\n30\n");
        manager.actualizareOferta();

        // verificare procent actualizat
        assertEquals(1, restaurant.getOferteValide().size());
        OfertaMeniu actualizata = (OfertaMeniu) restaurant.getOferteValide().get(0);
        assertEquals(30, actualizata.getReducere());

        // verificare actualizare pret pentru primul produs
        float pretDupaUpdate = restaurant.getMeniu().getProduse().get(0).getPret();
        float pretDupaUpdateExpected = pretInitial - (30.0f / 100.0f) * pretInitial;
        assertEquals(pretDupaUpdateExpected, pretDupaUpdate);
    }

    @Test
    void actualizareOfertaProdus() {
        float pretInitial = restaurant.getMeniu().getProduse().get(3).getPret();
        // adaugare oferta
        provideInput("2\n10\n4\nReducere Paste\n");
        manager.adaugareOferta();

        // actualizare oferta reducere = 30%
        provideInput("Reducere Paste\n30\n");
        manager.actualizareOferta();

        // verificare procent actualizat
        assertEquals(1, restaurant.getOferteValide().size());
        OfertaProdus actualizata = (OfertaProdus) restaurant.getOferteValide().get(0);
        assertEquals(30, actualizata.getReducere());

        // verificare actualizare pret
        float pretDupaUpdate = restaurant.getMeniu().getProduse().get(3).getPret();
        float pretDupaUpdateExpected = pretInitial - (30.0f / 100.0f) * pretInitial;
        assertEquals(pretDupaUpdateExpected, pretDupaUpdate);
    }

    @Test
    void actualizareOfertaCombo() {
        // adaugare oferta
        provideInput("3\n45\nOferta Combo\n2\n1\n2\n");
        manager.adaugareOferta();

        // actualizare oferta optiune 1 = actualizare pret
        provideInput("Oferta Combo\n1\n40\n");
        manager.actualizareOferta();

        // verificare pret actualizat
        assertEquals(1, restaurant.getOferteValide().size());
        OfertaCombo actualizata = (OfertaCombo) restaurant.getOferteValide().get(0);
        assertEquals(40, actualizata.getPretCombo());

        // actualizare oferta optiune 2 = actualizare produse
        provideInput("Oferta Combo\n2\n2\n2\n3");
        manager.actualizareOferta();

        assertEquals(1, restaurant.getOferteValide().size());
        OfertaCombo actualizata2 = (OfertaCombo) restaurant.getOferteValide().get(0);

        assertEquals("Pizza Margherita", actualizata2.getProduseParticipante().get(0).getDenumire());
        assertEquals("Pizza Prosciutto", actualizata2.getProduseParticipante().get(1).getDenumire());
    }

    @Test
    void actualizareOfertaInexistenta() {
        // adaugare oferta
        provideInput("3\n45\nOferta Combo\n2\n1\n2\n");
        manager.adaugareOferta();

        // actualizare oferta inexistanta
        provideInput("Oferta Como\n");

        // verificare
        assertDoesNotThrow(() -> manager.actualizareOferta());
        assertEquals(1, restaurant.getOferteValide().size());
    }
}