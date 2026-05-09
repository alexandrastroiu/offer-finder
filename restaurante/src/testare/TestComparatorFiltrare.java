package testare;

import clase.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TestComparatorFiltrare {
    @Test
    public void testFiltrareDistanta() {
        Restaurant r1 = new Restaurant(1, "Dodo Pizza","Bulevardul Iuliu Maniu 7", 0.3f, 10.0f, 23.0f, 4.5f, SpecificRestaurant.FastFood, 1);
        Restaurant r2 = new Restaurant(2, "Trattoria Locale", "Bulevardul Iuliu Maniu 8", 0.85f, 10.0f, 23.0f, 4.5f, SpecificRestaurant.Italienesc, 2);
        Restaurant r3 = new Restaurant(3, "Sushi Terra", "Bulevardul General Paul Teodorescu", 0.6f, 10.0f, 23.0f, 4.4f, SpecificRestaurant.FastFood, 3);
        Restaurant r4 = new Restaurant(4, "Treevi Pizza", "Bulevardul Iuliu Maniu 7", 0.2f, 10.0f, 22.0f, 3.8f, SpecificRestaurant.Italienesc, 4);
        Restaurant r5 = new Restaurant(5, "PUB 18", "Splaiul Independenței 290", 1.5f, 12.0f, 24.0f, 4.4f, SpecificRestaurant.FastFood, 5);

        Comparator comparator = new Comparator();

        List<Restaurant> rezultat = comparator.filtrareDistanta(1.0f);

        // Testarea cazului in care lista de restaurante a comparatorului este goala
        assertTrue(rezultat.isEmpty());

        comparator.setRestaurante(List.of(r1, r2, r3, r4, r5));

        rezultat = comparator.filtrareDistanta(0.0f);

        // Testarea cazului in care niciun restaurant din lista de restaurante a comparatorului nu respecta criteriul de filtrare
        assertTrue(rezultat.isEmpty());

        rezultat = comparator.filtrareDistanta(1.0f);

        // Testarea cazului in care returneaza restaurantele aflate la o distanta maxima de 1 km
        assertEquals(4, rezultat.size());
        assertTrue(rezultat.contains(r1));
        assertTrue(rezultat.contains(r2));
        assertTrue(rezultat.contains(r3));
        assertTrue(rezultat.contains(r4));
        assertFalse(rezultat.contains(r5));

        rezultat = comparator.filtrareDistanta(0.6f);

        // Testarea cazului in care un restaurant are aceeasi distanta cu distanta maxima acceptata
        assertEquals(3, rezultat.size());
        assertTrue(rezultat.contains(r1));
        assertTrue(rezultat.contains(r3));
        assertTrue(rezultat.contains(r4));
        assertFalse(rezultat.contains(r5));
        assertFalse(rezultat.contains(r2));

        rezultat = comparator.filtrareDistanta(0.21f);

        // Testarea cazului in care un restaurant are distanta foarte apropiata de distanta maxima acceptata
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(r4));
        assertFalse(rezultat.contains(r1));
        assertFalse(rezultat.contains(r2));
        assertFalse(rezultat.contains(r3));
        assertFalse(rezultat.contains(r5));
    }

    @Test
    public void testFiltrareRecenzii() {
        Restaurant r1 = new Restaurant(1, "Dodo Pizza","Bulevardul Iuliu Maniu 7", 0.3f, 10.0f, 23.0f, 4.5f, SpecificRestaurant.FastFood, 1);
        Restaurant r2 = new Restaurant(2, "Trattoria Locale", "Bulevardul Iuliu Maniu 8", 0.85f, 10.0f, 23.0f, 4.5f, SpecificRestaurant.Italienesc, 2);
        Restaurant r3 = new Restaurant(8, "Trattoria Roma", "Drumul Taberei 26", 1.8f, 11.0f, 23.0f, 4.4f, SpecificRestaurant.Italienesc, 8);
        Restaurant r4 = new Restaurant(9, "Restaurant Vanity", "Splaiul Independentei 315", 1.4f, 11.0f, 24.0f, 4.5f, SpecificRestaurant.Romanesc, 9);
        Restaurant r5 = new Restaurant(11, "Starbucks", "Bulevardul General Paul Teodorescu 4", 0.45f, 8.0f, 22.3f, 4.3f, SpecificRestaurant.Patiserie, 11);

        Comparator comparator = new Comparator();

        List<Restaurant> rezultat = comparator.filtrareRecenzii(4.0f);

        // Testarea cazului in care lista de restaurante a comparatorului este goala
        assertTrue(rezultat.isEmpty());

        comparator.setRestaurante(List.of(r1, r2, r3, r4, r5));

        rezultat = comparator.filtrareRecenzii(5.0f);

        // Testarea cazului in care niciun restaurant din lista de restaurante a comparatorului nu respecta criteriul de filtrare
        assertTrue(rezultat.isEmpty());

        rezultat = comparator.filtrareRecenzii(4.5f);

        // Testarea cazului de egalitate cu criteriul de filtrare (nota medie este egala cu nota minima acceptata)
        assertEquals(3, rezultat.size());
        assertTrue(rezultat.contains(r1));
        assertTrue(rezultat.contains(r2));
        assertFalse(rezultat.contains(r3));
        assertTrue(rezultat.contains(r4));
        assertFalse(rezultat.contains(r5));

        rezultat = comparator.filtrareRecenzii(4.31f);

        // Testarea cazului in care un restaurant are nota medie foarte apropiata de nota minima acceptata
        assertEquals(4, rezultat.size());
        assertTrue(rezultat.contains(r1));
        assertTrue(rezultat.contains(r2));
        assertTrue(rezultat.contains(r3));
        assertTrue(rezultat.contains(r4));
        assertFalse(rezultat.contains(r5));
    }

    @Test
    public void testFiltrareProcentReducere() {
        Comparator comparator = new Comparator();

        Restaurant r1 = new Restaurant(11, "Starbucks", "Bulevardul General Paul Teodorescu 4", 0.45f, 8.0f, 22.3f, 4.3f, SpecificRestaurant.Patiserie, 11);
        Restaurant r2 = new Restaurant(2, "Trattoria Locale", "Bulevardul Iuliu Maniu 8", 0.85f, 10.0f, 23.0f, 4.5f, SpecificRestaurant.Italienesc, 2);
        Restaurant r3 = new Restaurant(3, "Sushi Terra", "Bulevardul General Paul Teodorescu", 0.6f, 10.0f, 23.0f, 4.4f, SpecificRestaurant.FastFood, 3);

        r1.getMeniu().setProduse(List.of(new Produs(29, "Croissant", 15 , "", 320), new Produs(30, "Cafea Americano", 19 , "", 150), new Produs(31, "Cafea Capuccino", 27 , "", 150), new Produs(32, "Cafea Latte", 31 , "", 170)));
        r2.getMeniu().setProduse(List.of(new Produs(5, "Paste Carbonara", 39 , "", 670), new Produs(6, "Pizza Margherita", 35, "", 550), new Produs(7, "Paste Bolognese", 43, "", 680), new Produs(8, "Pizza Prosciutto", 46, "", 680)));
        r3.getMeniu().setProduse(List.of(new Produs(9, "Somon", 55 , "", 450), new Produs(10, "Creveti", 60 , "", 460), new Produs(11, "Noodles cu fructe de mare", 46, "",500 ), new Produs(12, "Noodles creveti", 55, "", 520)));

        OfertaProdus ofertaProdus1 =  new OfertaProdus(16, "Oferta Capuccino", 10);
        Produs produsOferta1 = r1.getProdusById(31);
        if ( produsOferta1 != null){
            ofertaProdus1.setProdus(produsOferta1);
        }

        OfertaProdus ofertaProdus2 = new OfertaProdus(17, "Oferta Latte", 7);
        Produs produsOferta2 = r1.getProdusById(32);
        if (produsOferta2 != null) {
            ofertaProdus2.setProdus(produsOferta2);
        }

        OfertaMeniu ofertaMeniu1 = new OfertaMeniu(4, "Reducere Meniu", 10, r2.getMeniu());
        OfertaMeniu ofertaMeniu2 = new OfertaMeniu(6, "Reducere Meniu", 5, r3.getMeniu());

        r1.setOferteValide(List.of(new OfertaCombo(15, "Combo Cafea + Croissant", 25), ofertaProdus1, ofertaProdus2));
        r2.setOferteValide(List.of(new OfertaCombo(2, "Combo Pizza", 52), new OfertaCombo(3, "Combo Pizza + Paste", 60), ofertaMeniu1));
        r3.setOferteValide(List.of(new OfertaCombo(5, "Combo Noodles", 44), ofertaMeniu2));

        List<Oferta> rezultat = comparator.filtrareProcentReducere(2);

        // Testarea cazului in care lista de oferte a comparatorului este goala
        assertTrue(rezultat.isEmpty());

        comparator.setRestaurante(List.of(r1, r2, r3));

        rezultat = comparator.filtrareProcentReducere(20);

        // Testarea cazului in care nicio oferta din lista de oferte a comparatorului nu respecta criteriul de filtrare
        assertTrue(rezultat.isEmpty());

        rezultat = comparator.filtrareProcentReducere(10);

        // Testarea cazului de egalitate cu criteriul de filtrare (procentul de reducere este egal cu procentul minim acceptata)
        assertEquals(2, rezultat.size());
        assertTrue(rezultat.contains(ofertaProdus1));
        assertTrue(rezultat.contains(ofertaMeniu1));
        assertFalse(rezultat.contains(ofertaProdus2));
        assertFalse(rezultat.contains(ofertaMeniu2));

        rezultat = comparator.filtrareProcentReducere(0);

        // Testarea cazului in care toate ofertele de tip oferta produs si oferta meniu respecta criteriul de filtrare
        assertEquals(4, rezultat.size());
        assertTrue(rezultat.contains(ofertaProdus1));
        assertTrue(rezultat.contains(ofertaMeniu1));
        assertTrue(rezultat.contains(ofertaProdus2));
        assertTrue(rezultat.contains(ofertaMeniu2));
    }

    @Test
    public void testFiltrarePret() {
        Comparator comparator = new Comparator();

        Restaurant r1 = new Restaurant(11, "Starbucks", "Bulevardul General Paul Teodorescu 4", 0.45f, 8.0f, 22.3f, 4.3f, SpecificRestaurant.Patiserie, 11);
        Restaurant r2 = new Restaurant(2, "Trattoria Locale", "Bulevardul Iuliu Maniu 8", 0.85f, 10.0f, 23.0f, 4.5f, SpecificRestaurant.Italienesc, 2);

        r1.getMeniu().setProduse(List.of(new Produs(29, "Croissant", 15 , "", 320), new Produs(30, "Cafea Americano", 19 , "", 150), new Produs(31, "Cafea Capuccino", 27 , "", 150), new Produs(32, "Cafea Latte", 31 , "", 170)));
        r2.getMeniu().setProduse(List.of(new Produs(5, "Paste Carbonara", 39 , "", 670), new Produs(6, "Pizza Margherita", 35, "", 550), new Produs(7, "Paste Bolognese", 43, "", 680), new Produs(8, "Pizza Prosciutto", 46, "", 680)));

        OfertaProdus ofertaProdus1 =  new OfertaProdus(16, "Oferta Capuccino", 10);
        Produs produsOferta1 = r1.getProdusById(31);
        if ( produsOferta1 != null){
            ofertaProdus1.setProdus(produsOferta1);
        }

        OfertaProdus ofertaProdus2 = new OfertaProdus(17, "Oferta Latte", 7);
        Produs produsOferta2 = r1.getProdusById(32);
        if (produsOferta2 != null) {
            ofertaProdus2.setProdus(produsOferta2);
        }

        OfertaMeniu ofertaMeniu1 = new OfertaMeniu(4, "Reducere Meniu", 10, r2.getMeniu());
        OfertaCombo ofertaCombo1 = new OfertaCombo(15, "Combo Cafea + Croissant", 25);

        r1.setOferteValide(List.of(ofertaCombo1, ofertaProdus1, ofertaProdus2));
        r2.setOferteValide(List.of(new OfertaCombo(2, "Combo Pizza", 52), new OfertaCombo(3, "Combo Pizza + Paste", 60), ofertaMeniu1));

        List<Oferta> rezultat = comparator.filtrarePret(2.0f);

        // Testarea cazului in care lista de oferte a comparatorului este goala
        assertTrue(rezultat.isEmpty());

        comparator.setRestaurante(List.of(r1, r2));

        rezultat = comparator.filtrarePret(0.0f);

        // Testarea cazului in care nicio oferta din lista de oferte a comparatorului nu respecta criteriul de filtrare
        assertTrue(rezultat.isEmpty());

        rezultat = comparator.filtrarePret(35.0f);

        // Testarea cazului in care pretul maxim este 35
        assertEquals(4, rezultat.size());
        assertTrue(rezultat.contains(ofertaProdus1));
        assertTrue(rezultat.contains(ofertaProdus2));
        assertTrue(rezultat.contains(ofertaMeniu1));
        assertTrue(rezultat.contains(ofertaCombo1));

        rezultat = comparator.filtrarePret(100.0f);

        // Testarea cazului in care toate ofertele respecta criteriul de filtrare dupa pret
        assertEquals(6, rezultat.size());
    }
}
