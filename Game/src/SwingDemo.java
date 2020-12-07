import java.awt.*;
import java.io.IOException;
import javax.swing.*;
public class SwingDemo extends JFrame {
    private JPanel panel, buttonPanel;
    private JButton bt1, bt2, bt3, bt4;
    private JLabel label1;
    private Font font, buttonFont;

    Image img = Toolkit.getDefaultToolkit().getImage("D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\MenuBG.png");
    public SwingDemo() {
        //Set Font
        font = new Font("Helvetica", Font.PLAIN, 100);
        buttonFont = new Font("Helvetica", Font.PLAIN, 50);

        panel = new JPanel();
        buttonPanel = new JPanel(new FlowLayout());

        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
        this.setLayout(new GridLayout(2, 1));

        //Set Button
        bt1 = new JButton("Button 1");
        bt1.setFont(buttonFont);
        bt1.setOpaque(false);
        bt2 = new JButton("Button 2");
        bt2.setFont(buttonFont);
        buttonPanel.add(bt1);
        buttonPanel.add(bt2);
        buttonPanel.setOpaque(false);

        //Set Label
        label1 = new JLabel("", JLabel.CENTER);
        label1.setFont(font);

        this.add(label1);
        this.add(buttonPanel);
        setSize(1200, 1000);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SwingDemo();
    }
}