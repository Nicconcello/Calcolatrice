package prj;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainf {

    public static void main(String[] args) {
        JFrame finestra = new JFrame("CALCOLATRICE");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setSize(300, 400);
        finestra.setLocationRelativeTo(null);
        finestra.setLayout(new BorderLayout(10, 10));

        // --- Campi di testo ---
        JTextField output = new JTextField("0", 20);
        JTextField input = new JTextField("0", 20);
        output.setEditable(false);
        input.setEditable(false);

        JPanel pannelloDisplay = new JPanel(new GridLayout(2, 1));
        pannelloDisplay.add(output);
        pannelloDisplay.add(input);
        finestra.add(pannelloDisplay, BorderLayout.NORTH);

        // --- Pannello dei numeri (a destra) ---
        JPanel pannelloNumeri = new JPanel(new GridLayout(4, 3, 5, 5));
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton beq = new JButton("=");

        pannelloNumeri.add(b7);
        pannelloNumeri.add(b8);
        pannelloNumeri.add(b9);
        pannelloNumeri.add(b4);
        pannelloNumeri.add(b5);
        pannelloNumeri.add(b6);
        pannelloNumeri.add(b1);
        pannelloNumeri.add(b2);
        pannelloNumeri.add(b3);
        pannelloNumeri.add(new JPanel()); // spazio vuoto
        pannelloNumeri.add(b0);
        pannelloNumeri.add(beq);

        finestra.add(pannelloNumeri, BorderLayout.CENTER);

        // --- Pannello delle operazioni (a sinistra) ---
        JPanel pannelloOperazioni = new JPanel(new GridLayout(5, 1, 5, 5));
        JButton bso = new JButton("+");
        JButton bst = new JButton("-");
        JButton bm = new JButton("x");
        JButton bd = new JButton("÷");
        JButton bc = new JButton("C");

        pannelloOperazioni.add(bso);
        pannelloOperazioni.add(bst);
        pannelloOperazioni.add(bm);
        pannelloOperazioni.add(bd);
        pannelloOperazioni.add(bc);

        finestra.add(pannelloOperazioni, BorderLayout.WEST);

        // --- Ascoltatore ---
        ascoltatore l = new ascoltatore(output, input);
        JButton[] bottoni = { b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bso, bst, bm, bd, bc, beq };
        for (JButton b : bottoni) {
            b.addActionListener(l);
        }

        // --- Mostra finestra ---
        finestra.setVisible(true);
    }
}
