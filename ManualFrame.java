
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ManualFrame
extends JFrame {
    public JPanel P = new JPanel(null);
    public JButton b = new JButton("Back");
    public JTextArea t = new JTextArea();
    public JScrollPane tsp;
    public JPanel P2 = new JPanel(new BorderLayout());
    public String[] muscles = new String[]{"", "Biceps", "Triceps", "Chest", "Back", "Shoulders"};
    public JComboBox MuscleCombo = new JComboBox<String>(this.muscles);
    public JLabel L1 = new JLabel("Main Muscle:");
    public JLabel L2 = new JLabel("Number Of Exercises:");
    public int index;
    public JComboBox num;
    public String[] nums;
    public JButton act = new JButton("Add");
    public Random rnd = new Random();
    private ManualFrame instance = this;

    public ManualFrame() {
        this.setBounds(200, 100, 500, 800);
        this.setTitle("Make Your Own Program");
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.add(this.P);
        this.t.setBounds(0, 0, 400, 500);
        this.P2.setBounds(50, 200, 400, 500);
        this.P.add(this.P2);
        this.MuscleCombo.setBounds(50, 50, 85, 20);
        this.P.add(this.MuscleCombo);
        this.L1.setBounds(50, 30, 200, 20);
        this.P.add(this.L1);
        this.L2.setBounds(185, 30, 200, 20);
        this.P.add(this.L2);
        this.act.setBounds(385, 30, 65, 40);
        this.P.add(this.act);
        this.tsp = new JScrollPane(this.t, 22, 32);
        this.P2.add((Component)this.tsp, "Center");
        this.P.add(this.b);
        int bx = this.getWidth() - 125;
        int by = this.getHeight() - 70;
        this.b.setBounds(bx, by, 70, 30);
        this.act.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Biceps") {
                    ManualFrame.this.manual(workout.data.biceps, ManualFrame.this.num.getSelectedIndex() + 1, (String)ManualFrame.this.MuscleCombo.getSelectedItem());
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Triceps") {
                    ManualFrame.this.manual(workout.data.triceps, ManualFrame.this.num.getSelectedIndex() + 1, (String)ManualFrame.this.MuscleCombo.getSelectedItem());
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Chest") {
                    ManualFrame.this.manual(workout.data.chest, ManualFrame.this.num.getSelectedIndex() + 1, (String)ManualFrame.this.MuscleCombo.getSelectedItem());
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Back") {
                    ManualFrame.this.manual(workout.data.back, ManualFrame.this.num.getSelectedIndex() + 1, (String)ManualFrame.this.MuscleCombo.getSelectedItem());
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Shoulders") {
                    ManualFrame.this.manual(workout.data.shoulders, ManualFrame.this.num.getSelectedIndex() + 1, (String)ManualFrame.this.MuscleCombo.getSelectedItem());
                }
            }
        });
        this.MuscleCombo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Biceps") {
                    ManualFrame.this.setMuscleCombo(workout.data.biceps);
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Triceps") {
                    ManualFrame.this.setMuscleCombo(workout.data.triceps);
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Chest") {
                    ManualFrame.this.setMuscleCombo(workout.data.chest);
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Back") {
                    ManualFrame.this.setMuscleCombo(workout.data.back);
                }
                if (ManualFrame.this.MuscleCombo.getSelectedItem() == "Shoulders") {
                    ManualFrame.this.setMuscleCombo(workout.data.shoulders);
                }
            }
        });
        this.b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                ManualFrame.this.setVisible(false);
                workout.a.setLocation(ManualFrame.this.instance.getLocation());
                ManualFrame.this.dispose();
                workout.a.setVisible(true);
            }
        });
    }

    public void setMuscleCombo(String[] Dmuscle) {
        if (this.index != 0) {
            ManualFrame f = new ManualFrame();
            f.setLocation(this.instance.getLocation());
            f.setVisible(true);
            f.t.setText(this.t.getText());
            f.MuscleCombo.setSelectedIndex(this.MuscleCombo.getSelectedIndex());
            this.dispose();
        }
        this.index = Dmuscle.length;
        String[] nums = new String[this.index];
        int i = 0;
        while (i < this.index) {
            nums[i] = "" + (i + 1);
            ++i;
        }
        this.num = new JComboBox<String>(nums);
        this.num.setBounds(185, 50, 150, 20);
        this.P.add(this.num);
    }

    public void manual(String[] muscle, int num, String name) {
        this.t.append("\n");
        this.t.append(String.valueOf(name) + ":");
        this.t.append("\n");
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
}

