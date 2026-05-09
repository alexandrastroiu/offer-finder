import clase.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Teste {

    @Test
    public void testFiltrareDistanta() {
        // Restaurante iconice din București cu coordonate de distanță variate
        Restaurant r1 = new Restaurant(10, "Caru' cu Bere", "Strada Stavropoleos 5", 0.15f, 11.0f, 24.0f, 4.8f, SpecificRestaurant.Romanesc, 1);
        Restaurant r2 = new Restaurant(20, "Hanu' lui Manuc", "Strada Franceză 62", 0.40f, 10.0f, 23.0f, 4.7f, SpecificRestaurant.Romanesc, 2);
        Restaurant r3 = new Restaurant(30, "Shift Pub", "Strada General Eremia Grigorescu 17", 0.95f, 12.0f, 01.0f, 4.6f, SpecificRestaurant.FastFood, 3);
        Restaurant r4 = new Restaurant(40, "Animaletto Pizza", "Strada Visarion 10", 0.65f, 11.0f, 23.0f, 4.5f, SpecificRestaurant.Italienesc, 4);
        Restaurant r5 = new Restaurant(50, "Biutiful by the Lake", "Soseaua Nordului 3", 4.2f, 12.0f, 01.0f, 4.4f, SpecificRestaurant.FastFood, 5);
        Restaurant r6 = new Restaurant(60, "Social 1", "Bulevardul Unirii 1", 0.25f, 09.0f, 22.0f, 4.3f, SpecificRestaurant.FastFood, 6);

        Comparator comparatorLogic = new Comparator();

        // Verificăm comportamentul pe listă goală (pentru robustețe)
        List<Restaurant> rezultatInitial = comparatorLogic.filtrareDistanta(1.5f);
        assertNotNull(rezultatInitial);
        assertTrue(rezultatInitial.isEmpty());

        // Populăm comparatorul
        comparatorLogic.setRestaurante(List.of(r1, r2, r3, r4, r5, r6));

        // Test: distanță imposibilă
        List<Restaurant> rezultatZero = comparatorLogic.filtrareDistanta(0.01f);
        assertTrue(rezultatZero.isEmpty());

        // Test: restaurante la maxim 1km (Ar trebui să fie 5: r1, r2, r3, r4, r6)
        List<Restaurant> rezultatStandard = comparatorLogic.filtrareDistanta(1.0f);
        assertEquals(5, rezultatStandard.size());
        assertTrue(rezultatStandard.contains(r1));
        assertTrue(rezultatStandard.contains(r3));
        assertFalse(rezultatStandard.contains(r5));

        // Test: prag exact (Boundary Condition)
        List<Restaurant> rezultatLimita = comparatorLogic.filtrareDistanta(0.65f);
        assertEquals(4, rezultatLimita.size());
        assertTrue(rezultatLimita.contains(r4));
        assertFalse(rezultatLimita.contains(r3));

        // Test: distanță foarte mică
        List<Restaurant> rezultatStrict = comparatorLogic.filtrareDistanta(0.2f);
        assertEquals(1, rezultatStrict.size());
        assertTrue(rezultatStrict.contains(r1));
    }

    @Test
    public void testFiltrareRecenzii() {
        Restaurant res1 = new Restaurant(101, "Frudisiac", "Intrarea Bitolia 4", 1.2f, 8.0f, 20.0f, 4.9f, SpecificRestaurant.Patiserie, 101);
        Restaurant res2 = new Restaurant(102, "M60", "Strada Mendeleev 2", 0.8f, 9.0f, 22.0f, 4.3f, SpecificRestaurant.Patiserie, 102);
        Restaurant res3 = new Restaurant(103, "Alt Shift", "Strada Constantin Mille 4", 0.5f, 12.0f, 02.0f, 4.7f, SpecificRestaurant.Italienesc, 103);
        Restaurant res4 = new Restaurant(104, "Pio Bistro", "Strada Puțul lui Zamfir 2", 1.5f, 09.0f, 21.0f, 4.1f, SpecificRestaurant.FastFood, 104);
        Restaurant res5 = new Restaurant(105, "Trofic", "Strada Ion Brezoianu 29", 0.3f, 08.0f, 18.0f, 4.6f, SpecificRestaurant.Patiserie, 105);

        Comparator comp = new Comparator();

        // Test listă goală
        assertTrue(comp.filtrareRecenzii(4.0f).isEmpty());

        comp.setRestaurante(List.of(res1, res2, res3, res4, res5));

        // Test rating de neatins
        assertTrue(comp.filtrareRecenzii(5.0f).isEmpty());

        // Test rating minim 4.6 (Ar trebui: res1, res3, res5)
        List<Restaurant> top = comp.filtrareRecenzii(4.6f);
        assertEquals(3, top.size());
        assertTrue(top.contains(res1));
        assertTrue(top.contains(res5));
        assertFalse(top.contains(res2));

        // Test rating minim 4.2
        List<Restaurant> medie = comp.filtrareRecenzii(4.2f);
        assertEquals(4, medie.size());
        assertFalse(medie.contains(res4));
    }

    @Test
    public void testFiltrareProcentReducere() {
        Comparator discountComp = new Comparator();

        // Definire restaurante din București
        Restaurant rA = new Restaurant(201, "French Revolution", "Calea Victoriei", 0.2f, 9, 21, 4.9f, SpecificRestaurant.Patiserie, 201);
        Restaurant rB = new Restaurant(202, "Vivo Fusion Burger", "Calea Floreasca", 1.8f, 11, 23, 4.7f, SpecificRestaurant.FastFood, 202);
        Restaurant rC = new Restaurant(203, "Stadio", "Piața Universității", 0.6f, 10, 24, 4.5f, SpecificRestaurant.FastFood, 203);

        // Definire Produse pentru rA (Ecleruri)
        Produs p1 = new Produs(1, "Ecler Pistachio", 22, "Premium", 300);
        Produs p2 = new Produs(2, "Ecler Caramel", 20, "Classic", 320);
        Produs p3 = new Produs(3, "Ecler Vanilie", 18, "Classic", 290);
        rA.getMeniu().setProduse(List.of(p1, p2, p3));

        // Definire Produse pentru rB (Burgers)
        Produs p4 = new Produs(10, "Vivo Burger", 42, "Best Seller", 650);
        Produs p5 = new Produs(11, "Italian Burger", 45, "Special", 700);
        rB.getMeniu().setProduse(List.of(p4, p5));

        // Definire Produse pentru rC
        Produs p6 = new Produs(20, "Pasta Carbonara", 38, "Lunch", 550);
        rC.getMeniu().setProduse(List.of(p6));

        // Configurare Oferte
        OfertaProdus o1 = new OfertaProdus(501, "Flash Sale Vanilie", 15); // 15%
        o1.setProdus(rA.getProdusById(3));

        OfertaProdus o2 = new OfertaProdus(502, "Promo Caramel", 10); // 10%
        o2.setProdus(rA.getProdusById(2));

        OfertaMeniu o3 = new OfertaMeniu(601, "Lunch Deal Vivo", 20, rB.getMeniu()); // 20%
        OfertaMeniu o4 = new OfertaMeniu(602, "Stadio Discount", 5, rC.getMeniu()); // 5%

        rA.setOferteValide(List.of(o1, o2));
        rB.setOferteValide(List.of(o3));
        rC.setOferteValide(List.of(o4));

        // Testare pe listă goală
        assertTrue(discountComp.filtrareProcentReducere(5).isEmpty());

        discountComp.setRestaurante(List.of(rA, rB, rC));

        // Test: reducere minimă 12% (Ar trebui: o1 și o3)
        List<Oferta> rez1 = discountComp.filtrareProcentReducere(12);
        assertEquals(2, rez1.size());
        assertTrue(rez1.contains(o1));
        assertTrue(rez1.contains(o3));

        // Test: reducere minimă 25% (Niciuna)
        assertTrue(discountComp.filtrareProcentReducere(25).isEmpty());

        // Test: toate ofertele (minim 0%)
        assertEquals(4, discountComp.filtrareProcentReducere(0).size());
    }

    @Test
    public void testFiltrarePret() {
        Comparator priceComp = new Comparator();

        Restaurant rCoffee = new Restaurant(301, "Bob Coffee Lab", "Piața Charles de Gaulle", 0.3f, 8, 19, 4.9f, SpecificRestaurant.Patiserie, 301);
        Restaurant rPizza = new Restaurant(302, "Fabrica de Bere", "Calea Victoriei", 0.9f, 12, 01, 4.3f, SpecificRestaurant.FastFood, 302);

        // Produse rCoffee
        Produs c1 = new Produs(80, "Flat White", 17, "Cafea", 150);
        Produs c2 = new Produs(81, "Cold Brew", 19, "Cafea", 50);
        rCoffee.getMeniu().setProduse(List.of(c1, c2));

        // Produse rPizza
        Produs z1 = new Produs(90, "Pizza Diavola", 44, "Main", 600);
        Produs z2 = new Produs(91, "Bere Artizanală", 22, "Drink", 400);
        rPizza.getMeniu().setProduse(List.of(z1, z2));

        // Oferte
        OfertaProdus off1 = new OfertaProdus(8001, "Coffee Promo", 10); // 17 - 1.7 = 15.3 lei
        off1.setProdus(c1);

        OfertaCombo off2 = new OfertaCombo(8002, "Morning Energy", 32); // 32 lei fix

        OfertaMeniu off3 = new OfertaMeniu(8003, "Pizza Discount", 15, rPizza.getMeniu()); // 44 - 15% = 37.4 lei

        rCoffee.setOferteValide(List.of(off1, off2));
        rPizza.setOferteValide(List.of(off3));

        // Testare listă goală
        assertTrue(priceComp.filtrarePret(50.0f).isEmpty());

        priceComp.setRestaurante(List.of(rCoffee, rPizza));

        // Test: preț maxim 20 lei (Doar off1)
        List<Oferta> ieftine = priceComp.filtrarePret(20.0f);
        assertEquals(2, ieftine.size());
        assertTrue(ieftine.contains(off1));

        // Test: preț maxim 40 lei (off1, off2, off3)
        List<Oferta> medii = priceComp.filtrarePret(40.0f);
        assertEquals(3, medii.size());
        assertTrue(medii.contains(off3));

        // Test: preț foarte mic
        assertTrue(priceComp.filtrarePret(5.0f).isEmpty());
    }
}