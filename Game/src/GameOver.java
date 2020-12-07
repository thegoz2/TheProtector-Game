import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.UIManager.*;

//หน้าต่าง Game Over
public class GameOver extends JPanel implements ActionListener{
    public JPanel allPanel, menuPanel;
    private JLabel goLabel, scoreLabel, winOrLoseLabel;
    private Font goFont, scoreFont, menuFont;
    private CardLayoutFrame allCardFrame;
    private Image img = Toolkit.getDefaultToolkit().getImage("D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\GameOverBG1.png");

    public JButton menuButton;
    public JPanel gameOverPanel;
    public JFrame gameOverFrame;

    public GameOver(){

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

        //Set Background Panel
        this.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });

        //Set Panel
        this.setLayout(new GridLayout(3, 1));
        allPanel = new JPanel(new GridLayout(3, 1));
        menuPanel = new JPanel(new FlowLayout());
        allPanel.setOpaque(false);
        menuPanel.setOpaque(false);

        //Set Font
        goFont = new Font("TH SarabunPSK", Font.PLAIN, 100);
        scoreFont = new Font("TH SarabunPSK", Font.PLAIN, 50);
        menuFont = new Font("TH SarabunPSK", Font.PLAIN, 50);

        //Set Label
        scoreLabel = new JLabel("คะแนน : 10000", JLabel.CENTER);
        scoreLabel.setFont(scoreFont);
        scoreLabel.setForeground(Color.WHITE);
        winOrLoseLabel = new JLabel("You are winner !!", JLabel.CENTER);
        winOrLoseLabel.setFont(scoreFont);
        winOrLoseLabel.setForeground(Color.WHITE);

        //Set Button
        menuButton = new JButton("Menu");
        menuButton.setFont(menuFont);

        //Add Button to Panel
        menuPanel.add(menuButton);

        //Add all to AllPanel
        allPanel.add(scoreLabel);
        allPanel.add(winOrLoseLabel);
        allPanel.add(menuPanel);

        //Add AllPanel to Panel
        this.add(allPanel);

    }

    public static void main(String[] args) {
        new GameOver();
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
