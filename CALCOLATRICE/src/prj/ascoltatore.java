package prj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ascoltatore implements ActionListener {

    private JTextField output;
    private JTextField input;

    private String operazione = "";
    private int valoreMemorizzato = 0;

    public ascoltatore(JTextField output, JTextField input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        // Se è un numero
        if (comando.matches("[0-9]")) {
            if (input.getText().equals("0")) {
                input.setText(comando);
            } else {
                input.setText(input.getText() + comando);
            }
        }

        // Se è un'operazione
        else if (comando.equals("+") || comando.equals("-") || comando.equals("x") || comando.equals("÷")) {
            operazione = comando;
            valoreMemorizzato = Integer.parseInt(input.getText());
            output.setText(valoreMemorizzato + " " + operazione);
            input.setText("0");
        }

        // Se è il pulsante C (clear)
        else if (comando.equals("C")) {
            input.setText("0");
            output.setText("0");
            valoreMemorizzato = 0;
            operazione = "";
        }

        // Se è il pulsante uguale "="
        else if (comando.equals("=")) {
            int secondoValore = Integer.parseInt(input.getText());
            int risultato = 0;

            switch (operazione) {
                case "+": risultato = valoreMemorizzato + secondoValore; break;
                case "-": risultato = valoreMemorizzato - secondoValore; break;
                case "x": risultato = valoreMemorizzato * secondoValore; break;
                case "÷":
                    if (secondoValore != 0) {
                        risultato = valoreMemorizzato / secondoValore;
                    } else {
                        output.setText("ERRORE: div/0");
                        input.setText("0");
                        return; // esce dal metodo per evitare crash
                    }
                    break;
                default:
                    return;
            }

            output.setText("" + risultato);
            input.setText("0");
            operazione = "";
            valoreMemorizzato = risultato; // per continuare a calcolare in catena
        }
    }
}
