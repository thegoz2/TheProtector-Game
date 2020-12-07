import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class CardLayoutFrame extends JFrame implements ActionListener{
    private GameMenu gameMenu;
    private GameGUI gameGUI;
    private GameOver gameOver;
    private JFrame allFrame;
    private JButton next;
    private ImageIcon howToPlayIcon;
    private JLabel howToPlayLabel;
    private Font font;



    public JPanel gui, menu, over, howToPlayPanel;
    public JPanel allCardFrame;
    public CardLayout cFrame;
    public Container container;

    public CardLayoutFrame(){
        //Set Title
        this.setTitle("The Protector");

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
        font = new Font("TH SarabunPSK", Font.PLAIN, 30);

        //Set CardLayout
        cFrame = new CardLayout();

        container = getContentPane();
        container.setLayout(cFrame);

        //Set All Class (Panel)
        gameMenu = new GameMenu();
        gameOver = new GameOver();

        //Set Icon
        howToPlayIcon = new ImageIcon((getClass().getResource("Story&Howtoplay.png")));
        //Set Label
        howToPlayLabel = new JLabel(howToPlayIcon);
        //Set Panel
        howToPlayPanel = new JPanel(new BorderLayout());
        howToPlayPanel.add(howToPlayLabel, BorderLayout.CENTER);
        //Set Button
        next = new JButton("Next >>>");
        next.setFont(font);
        next.addActionListener(this);
        howToPlayPanel.add(next, BorderLayout.SOUTH);

        //Set Another Class Button
        //* GameMenu Class *
        gameMenu.startButton.addActionListener(this);
        gameMenu.exitButton.addActionListener(this);
        //* Game Over Class *
        gameOver.menuButton.addActionListener(this);


        //Add All Panel to Card Frame
        container.add("a", gameMenu);
        container.add("b", howToPlayPanel);
        container.add("c", gameOver);

        container.setVisible(true);
    }

    public static void main(String[] args) {
        CardLayoutFrame ct = new CardLayoutFrame();
        ct.setSize(1200, 1000);
        ct.setVisible(true);
        ct.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String audioFilePath = "D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\8-Bit-Universe-Ghost-Fight-from-Undertale.wav";
        AudioPlayerExample1 player = new AudioPlayerExample1();
        player.play(audioFilePath);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        CardLayoutFrame ct = new CardLayoutFrame();
        if(click.getSource().equals(next)){
            cFrame.next(container);
        }

        //GameMenu Button
        else if(click.getSource().equals(gameMenu.startButton)){
            cFrame.next(container);
        }
        else if(click.getSource().equals(gameMenu.exitButton)){
            ct.dispose();
            System.out.println("Close");
        }

        //GameOver Button
        else if (click.getSource().equals(gameOver.menuButton)){
            cFrame.next(container);
        }
    }
}
