import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

/**
 * Tato třída testuje výpočet celkové ceny faktury. Ověřuje, jestli metoda spocitejCelkovaCena funguje spránvě.
 */
public class FakturaTest {

    private Faktura faktura;

    /**
     * Vytvoří novou fakturu a nastaví ji před každým testem. Používá testovacího klienta a stávající datum.
     */
    @BeforeEach
    public void setUp() {
        Klient klient = new Klient("Jan", "Novak", "Praha 1", "12345678", "777666555", "jan.novak@seznam.cz");
        faktura = new Faktura("F001", klient, new Date(), new Date(), "vystavitel@seznam.cz");
    }

    /**
     * Tato metoda testuje výpočet celkové ceny faktury.
     */
    @Test
    public void testSpocitejCelkovaCena() {

        PolozkaFaktury p1 = new PolozkaFaktury("Ponozky", 2, 50.0);
        PolozkaFaktury p2 = new PolozkaFaktury("Pantofle", 1, 500.0);

        faktura.pridatPolozku(p1);
        faktura.pridatPolozku(p2);

        double vysledek = faktura.spocitejCelkovaCena();

        System.out.println("Očekávaná cena: 600.0 Kč");
        System.out.println("Skutečná cena: " + vysledek + " Kč");

        assertEquals(600.0, vysledek, "Celková cena není správně spočítaná.");
    }
}

