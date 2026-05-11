
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame
extends JFrame {
    public JButton AB = new JButton("AB Program");
    public JButton ABC = new JButton("ABC Program");
    public JButton ADD = new JButton("Add an exercise");
    public JButton DEL = new JButton("Delete an exercise");
    public JButton MAN = new JButton("Manual Program");
    public JPanel P = new JPanel(null);
    private MainFrame instance = this;

    public MainFrame() {
        this.setTitle("Workout!");
        this.setDefaultCloseOperation(3);
        this.setBounds(200, 100, 500, 500);
        this.setVisible(true);
        this.add(this.P);
        this.setResizable(false);
        this.P.add(this.AB);
        this.AB.setBounds(175, 50, 150, 50);
        this.AB.setVisible(true);
        this.P.add(this.ABC);
        this.ABC.setBounds(175, 120, 150, 50);
        this.ABC.setVisible(true);
        this.P.add(this.ADD);
        this.ADD.setBounds(175, 190, 150, 50);
        this.ADD.setVisible(true);
        this.P.add(this.DEL);
        this.DEL.setBounds(175, 260, 150, 50);
        this.DEL.setVisible(true);
        this.P.add(this.MAN);
        this.MAN.setBounds(175, 330, 150, 50);
        this.MAN.setVisible(true);
        this.AB.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                workout.a.setVisible(false);
                ABFrame f = new ABFrame();
                f.setLocation(MainFrame.this.instance.getLocation());
                f.setVisible(true);
                f.newT();
            }
        });
        this.ABC.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                workout.a.setVisible(false);
                ABCFrame f = new ABCFrame();
                f.setLocation(MainFrame.this.instance.getLocation());
                f.setVisible(true);
            }
        });
        this.DEL.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                workout.a.setVisible(false);
                DeleteFrame f = new DeleteFrame();
                f.setLocation(MainFrame.this.instance.getLocation());
                f.setVisible(true);
            }
        });
        this.MAN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                workout.a.setVisible(false);
                ManualFrame f = new ManualFrame();
                f.setLocation(MainFrame.this.instance.getLocation());
                f.setVisible(true);
            }
        });
        this.ADD.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                workout.a.setVisible(false);
                AddFrame f = new AddFrame();
                f.setLocation(MainFrame.this.instance.getLocation());
                f.setVisible(true);
            }
        });
    }
}

