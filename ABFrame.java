
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ABFrame
extends JFrame {
    public JPanel P = new JPanel(null);
    public JTextArea t = new JTextArea();
    public JButton b = new JButton("Back");
    public Random rnd = new Random();
    private ABFrame instance = this;

    public ABFrame() {
        this.setTitle("AB Program");
        this.setDefaultCloseOperation(3);
        this.setBounds(200, 100, 500, 750);
        this.add(this.P);
        this.setResizable(false);
        this.t.setBounds(50, 50, 400, 600);
        this.P.add(this.t);
        this.P.add(this.b);
        int bx = this.getWidth() - 125;
        int by = this.getHeight() - 70;
        this.b.setBounds(bx, by, 70, 30);
        this.b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                ABFrame.this.instance.setVisible(false);
                workout.a.setLocation(ABFrame.this.instance.getLocation());
                ABFrame.this.instance.dispose();
                workout.a.setVisible(true);
            }
        });
    }

    public void manual(String[] muscle, int num, String name) {
        if (num > muscle.length) {
            System.err.println("there aren't enough exercises, sorry...");
            return;
        }
        this.t.append("\n");
        this.t.append(name);
        int[] arr = new int[num];
        int k = 0;
        while (k < num) {
            arr[k] = this.rnd.nextInt(muscle.length);
            ++k;
        }
        int i = 0;
        while (i < num) {
            int j = 0;
            while (j < num) {
                if (arr[i] == arr[j] && i != j) {
                    arr[j] = this.rnd.nextInt(muscle.length);
                    i = 0;
                }
                ++j;
            }
            ++i;
        }
        int m = 0;
        while (m < num) {
            this.t.append(String.valueOf(m + 1) + ") " + muscle[arr[m]] + "\n");
            ++m;
        }
    }

    public void newT() {
        this.t.setText("");
        this.t.append("---A---\n");
        this.manual(workout.data.chest, 5, "Chest:\n");
        this.manual(workout.data.back, 5, "Back:\n");
        this.t.append("\n");
        this.t.append("---B---\n");
        this.manual(workout.data.biceps, 4, "Biceps:\n");
        this.manual(workout.data.shoulders, 3, "Shoulders:\n");
        this.manual(workout.data.triceps, 4, "Triceps:\n");
    }
}

