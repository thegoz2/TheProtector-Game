import javax.swing.*;
import java.awt.*;
public class Background {
    public JLabel background;
    public JFrame fr;
    public ImageIcon img ;
    public JPanel panel;

    public Background(){
        panel = new JPanel ();
        fr = new JFrame ("BackgroundDemo");
        fr.setLayout (new BorderLayout ());

        img = new ImageIcon (getClass ().getResource("bg.jpg"));
        background = new JLabel ("",img,JLabel.CENTER);
        fr.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        background.setBounds (0,0,482,365);
        panel.add(background);
        fr.add(panel,BorderLayout.CENTER);
        fr.setSize (482,365);
        fr.setVisible(true);


    }
    public static void main(String[] args){
        new Background ();
    }

}

