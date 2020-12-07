import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.*;

//หน้าต่าง Menu เกม
public class GameMenu extends JPanel implements ActionListener{
    private JFrame frame;
    private JPanel allPanel, topPanel, bottomPanel, buttonPanel, startPanel, exitPanel;
    private JLabel label;
    private Font font, buttonFont;
    private CardLayoutFrame allCardFrame;
    private Image img = Toolkit.getDefaultToolkit().getImage("D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\MenuBG.png");

    public JButton startButton, exitButton;
    public JPanel gameMenuPanel;

    public GameMenu(){
        //Set Background Image
        this.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });

        //Set Look and Feel
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        //Set Font
        font = new Font( "TH SarabunPSK", Font.PLAIN, 100);
        buttonFont = new Font( "TH SarabunPSK", Font.PLAIN, 60);

        //Set Blank Label
        label = new JLabel("");
        label.setFont(font);

        //Set Panel
        this.setLayout(new GridLayout(5, 1));
        buttonPanel = new JPanel(new GridLayout(2, 1));
        startPanel = new JPanel(new FlowLayout());
        exitPanel = new JPanel(new FlowLayout());

        //Set Button
        startButton = new JButton("Start");
        startButton.setFont(buttonFont);
        startButton.setBackground(new Color(135, 160, 255));
        exitButton = new JButton("Exit");
        exitButton.setFont(buttonFont);
        startPanel.add(startButton);
        exitPanel.add(exitButton);
        startPanel.setOpaque(false);
        exitPanel.setOpaque(false);

        //Add Button to ButtonPanel
        buttonPanel.add(startPanel);
        buttonPanel.add(exitPanel);
        buttonPanel.setOpaque(false);

        //Add ButtonPanel to BottomPanel

        //Add all Panel to allPanel
        this.add(label);
        this.add(buttonPanel);

    }

    public static void main(String[] args) {
        new GameMenu();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent click) {

    }

}
