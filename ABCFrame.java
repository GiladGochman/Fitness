
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ABCFrame
extends JFrame {
    public JPanel P = new JPanel(null);
    public JButton b = new JButton("Back");
    private ABCFrame instance = this;

    public ABCFrame() {
        this.setBounds(200, 100, 500, 500);
        this.setResizable(false);
        this.add(this.P);
        this.setDefaultCloseOperation(3);
        this.setTitle("ABC Program");
        this.P.add(this.b);
        int bx = this.getWidth() - 125;
        int by = this.getHeight() - 70;
        this.b.setBounds(bx, by, 70, 30);
        this.b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                ABCFrame.this.instance.setVisible(false);
                workout.a.setLocation(ABCFrame.this.instance.getLocation());
                ABCFrame.this.instance.dispose();
                workout.a.setVisible(true);
            }
        });
    }
}

