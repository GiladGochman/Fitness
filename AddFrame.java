
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddFrame
extends JFrame {
    public JPanel P = new JPanel(null);
    public JButton b = new JButton("Back");
    public static String[] muscles = new String[]{"", "Biceps", "Triceps", "Chest", "Back", "Shoulders"};
    public JComboBox MuscleCombo = new JComboBox<String>(muscles);
    public JTextArea name = new JTextArea();
    public JLabel L1 = new JLabel("Main Muscle:");
    public JLabel L2 = new JLabel("Name Of The Exercise:");
    public JButton act = new JButton("Add");
    public JTextArea L3 = new JTextArea();
    private AddFrame instance = this;

    public AddFrame() {
        this.setDefaultCloseOperation(3);
        this.setBounds(200, 100, 500, 200);
        this.setTitle("Add Exercises");
        this.add(this.P);
        this.setResizable(false);
        this.act.setBounds(385, 30, 75, 40);
        this.P.add(this.act);
        this.L1.setBounds(40, 30, 200, 20);
        this.P.add(this.L1);
        this.L2.setBounds(155, 30, 200, 20);
        this.P.add(this.L2);
        this.L3.setBounds(40, 80, 200, 20);
        Color bg = new Color(237, 237, 237);
        this.L3.setBackground(bg);
        this.P.add(this.L3);
        this.name.setBounds(155, 50, 200, 20);
        this.P.add(this.name);
        this.MuscleCombo.setBounds(40, 50, 85, 20);
        this.P.add(this.MuscleCombo);
        this.P.add(this.b);
        int bx = this.getWidth() - 125;
        int by = this.getHeight() - 70;
        this.b.setBounds(bx, by, 70, 30);
        this.act.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (AddFrame.this.MuscleCombo.getSelectedItem() == "Biceps") {
                    workout.data.biceps = AddFrame.this.Add(workout.data.biceps, AddFrame.this.name.getText());
                }
                if (AddFrame.this.MuscleCombo.getSelectedItem() == "Triceps") {
                    workout.data.triceps = AddFrame.this.Add(workout.data.triceps, AddFrame.this.name.getText());
                }
                if (AddFrame.this.MuscleCombo.getSelectedItem() == "Chest") {
                    workout.data.chest = AddFrame.this.Add(workout.data.chest, AddFrame.this.name.getText());
                }
                if (AddFrame.this.MuscleCombo.getSelectedItem() == "Back") {
                    workout.data.back = AddFrame.this.Add(workout.data.back, AddFrame.this.name.getText());
                }
                if (AddFrame.this.MuscleCombo.getSelectedItem() == "Shoulders") {
                    workout.data.shoulders = AddFrame.this.Add(workout.data.shoulders, AddFrame.this.name.getText());
                }
                workout.saveDataToFile(workout.data, "data.txt");
                AddFrame.this.MuscleCombo.setSelectedIndex(0);
                AddFrame.this.name.setText("");
            }
        });
        this.b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                AddFrame.this.instance.setVisible(false);
                workout.a.setLocation(AddFrame.this.instance.getLocation());
                AddFrame.this.instance.dispose();
                workout.a.setVisible(true);
            }
        });
    }

    private String[] Add(String[] Dmuscle, String name) {
        String[] arr = new String[Dmuscle.length + 1];
        int i = 0;
        while (i < Dmuscle.length) {
            arr[i] = Dmuscle[i];
            ++i;
        }
        arr[Dmuscle.length] = name;
        this.L3.setText("The exercise was added.");
        return arr;
    }
}

