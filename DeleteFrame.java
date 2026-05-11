
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DeleteFrame
extends JFrame {
    public JPanel P = new JPanel(null);
    public JButton b = new JButton("Back");
    public JButton del = new JButton("Delete");
    public JTextArea t = new JTextArea();
    public JLabel L1 = new JLabel("Main Muscle:");
    public JLabel L2 = new JLabel("Name Of The Exercise:");
    public JTextArea name = new JTextArea();
    public static String[] muscles = new String[]{"", "Biceps", "Triceps", "Chest", "Back", "Shoulders"};
    public JComboBox MuscleCombo = new JComboBox<String>(muscles);
    private DeleteFrame instance = this;

    public DeleteFrame() {
        this.setResizable(false);
        this.setTitle("Delete exercises");
        this.setBounds(200, 100, 500, 200);
        this.setDefaultCloseOperation(3);
        this.add(this.P);
        this.del.setBounds(385, 30, 75, 40);
        this.P.add(this.del);
        this.L1.setBounds(40, 30, 200, 20);
        this.P.add(this.L1);
        this.L2.setBounds(155, 30, 200, 20);
        this.P.add(this.L2);
        this.name.setBounds(155, 50, 200, 20);
        this.P.add(this.name);
        this.MuscleCombo.setBounds(40, 50, 85, 20);
        this.P.add(this.MuscleCombo);
        this.t.setBounds(40, 80, 200, 20);
        Color bg = new Color(237, 237, 237);
        this.t.setBackground(bg);
        this.P.add(this.t);
        this.P.add(this.b);
        int bx = this.getWidth() - 125;
        int by = this.getHeight() - 70;
        this.b.setBounds(bx, by, 70, 30);
        this.del.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (DeleteFrame.this.MuscleCombo.getSelectedItem() == "Biceps") {
                    workout.data.biceps = DeleteFrame.this.delete(workout.data.biceps, DeleteFrame.this.name.getText());
                }
                if (DeleteFrame.this.MuscleCombo.getSelectedItem() == "Triceps") {
                    workout.data.triceps = DeleteFrame.this.delete(workout.data.triceps, DeleteFrame.this.name.getText());
                }
                if (DeleteFrame.this.MuscleCombo.getSelectedItem() == "Chest") {
                    workout.data.chest = DeleteFrame.this.delete(workout.data.chest, DeleteFrame.this.name.getText());
                }
                if (DeleteFrame.this.MuscleCombo.getSelectedItem() == "Back") {
                    workout.data.back = DeleteFrame.this.delete(workout.data.back, DeleteFrame.this.name.getText());
                }
                if (DeleteFrame.this.MuscleCombo.getSelectedItem() == "Shoulders") {
                    workout.data.shoulders = DeleteFrame.this.delete(workout.data.shoulders, DeleteFrame.this.name.getText());
                }
                workout.saveDataToFile(workout.data, "data.txt");
            }
        });
        this.b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                DeleteFrame.this.instance.setVisible(false);
                workout.a.setLocation(DeleteFrame.this.instance.getLocation());
                DeleteFrame.this.instance.dispose();
                workout.a.setVisible(true);
            }
        });
    }

    public String[] delete(String[] Dmuscle, String name) {
        boolean flag = false;
        int index = 0;
        int i = 0;
        while (i < Dmuscle.length) {
            if (Dmuscle[i].equalsIgnoreCase(name)) {
                index = i;
                flag = true;
            }
            ++i;
        }
        String[] arr = new String[Dmuscle.length - 1];
        int newIndex = 0;
        if (flag) {
            int j = 0;
            while (j < Dmuscle.length) {
                if (j != index) {
                    arr[newIndex] = Dmuscle[j];
                    ++newIndex;
                } else {
                    this.t.setText("The exercise was removed.");
                    this.MuscleCombo.setSelectedIndex(0);
                    this.instance.name.setText("");
                }
                ++j;
            }
            return arr;
        }
        this.t.setText("The exercise does not exist.");
        return Dmuscle;
    }
}

