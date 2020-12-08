import javax.swing.*;
import java.awt.*;


public class Tester extends JFrame{

    public Tester(String title) throws HeadlessException {
        super(title);
        InitialElements();
    }

    private void InitialElements(){
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // This one does not work
        // getContentPane().setBackground(new Color(70, 80, 70));

    }

    public void paint(Graphics draw){
        //Here you can perform any drawing like an oval...
        draw.fillOval(40, 40, 60, 50);

        getContentPane().setBackground(new Color(70,80,70));
    }
    public static void main(String[] args) {
        new Tester("s");
    }
}
