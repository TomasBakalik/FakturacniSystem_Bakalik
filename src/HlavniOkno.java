import javax.swing.*;
import java.awt.*;

/**
 * Tato třída reprezentuje hlavní okno programu.
 * Uživatel si zde může vybrat, jestli chce vystavit fakturu, zaregistrovat se nebo přihlásit.
 */
public class HlavniOkno extends JFrame {

    private JButton tlacitkoVystavit;
    private JButton tlacitkoRegistrovat;
    private JButton tlacitkoPrihlasit;
    private SpravceFaktur spravceFaktur;

    public HlavniOkno(){
        this.spravceFaktur = new SpravceFaktur();
        nastavOkno();
        setVisible(true);
    }

    /**
     * Nastaví vlastnosti hlavního okna, pozadí, tlačítka a jejich akce.
     * Kliknutí na tlačítka vede do dalších částí aplikace podle výběru možnosti (otevírají další okna).
     */
    public void nastavOkno(){
        setTitle("Fakturační Systém");
        setSize(1200,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        ImageIcon pozadiObrazek = new ImageIcon(getClass().getResource("/pozadi.jpg"));

        JLabel pozadi = new JLabel(pozadiObrazek);
        pozadi.setLayout(new BorderLayout());

        tlacitkoVystavit = vytvorTlacitko("Vystavit fakturu", new Color(59, 89, 152));
        tlacitkoRegistrovat = vytvorTlacitko("Registrovat", new Color(72, 133, 237));
        tlacitkoPrihlasit = vytvorTlacitko("Příhlásit se", new Color(0, 153, 51));

        JPanel panelTlacitek = new JPanel();
        panelTlacitek.setOpaque(false);
        panelTlacitek.setLayout(new GridLayout(3,1, 0, 20));
        panelTlacitek.add(tlacitkoVystavit);
        panelTlacitek.add(tlacitkoRegistrovat);
        panelTlacitek.add(tlacitkoPrihlasit);

        JPanel panelStred = new JPanel(new GridBagLayout());
        panelStred.setOpaque(false);
        panelStred.setBorder(BorderFactory.createEmptyBorder(20,100,20,100));
        panelStred.add(panelTlacitek);

        pozadi.add(panelStred, BorderLayout.CENTER);
        setContentPane(pozadi);

        tlacitkoVystavit.addActionListener(e -> new FormularFaktura(spravceFaktur));
        tlacitkoRegistrovat.addActionListener(e -> new RegistraceOkno());
        tlacitkoPrihlasit.addActionListener(e -> new PrihlaseniOkno(spravceFaktur));

    }

    /**
     * Vytvoří tlačítko se zadaným textem a barvou pozadí.
     * Tlačítko má jednotný styl a velikost.
     * @param text Text, který se zobrazí na tlačítku.
     * @param barvaPozadi Barva, kterou bude mít tlačítko.
     * @return Vrací vytvořené tlačítko.
     */
    public JButton vytvorTlacitko(String text, Color barvaPozadi){
        JButton tlacitko = new JButton(text);
        tlacitko.setPreferredSize(new Dimension(250, 50));
        tlacitko.setFont(new Font("Arial", Font.BOLD, 20));
        tlacitko.setForeground(Color.WHITE);
        tlacitko.setBackground(barvaPozadi);
        tlacitko.setFocusPainted(false);
        return tlacitko;
    }
}
