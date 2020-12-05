import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


//หน้าต่าง Menu เกม
public class GameMenu {
    private JFrame frame;
    private JPanel topPanel, bottomPanel, buttonPanel, startPanel, exitPanel;
    private JLabel gameName;
    private JButton startButton, exitButton;
    private Font font, buttonFont;

    public GameMenu(){
        //Set Frame
        frame = new JFrame("The Protector");
        frame.setLayout(new GridLayout(2, 1));

        //Set Font
        font = new Font( "Helvetica", Font.PLAIN, 100);
        buttonFont = new Font( "Helvetica", Font.PLAIN, 50);

        //Set Panel
        topPanel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(4, 1));
        startPanel = new JPanel(new FlowLayout());
        exitPanel = new JPanel(new FlowLayout());

        //SetLabel
        gameName = new JLabel("The Protector");
        gameName.setFont(font);
        gameName.setHorizontalAlignment(JLabel.CENTER);
        gameName.setVerticalAlignment(JLabel.CENTER);
        //Add Label to Panel
        topPanel.add(gameName, BorderLayout.CENTER);

        //Set Button
        startButton = new JButton("Start");
        startButton.setFont(buttonFont);
        exitButton = new JButton("Exit");
        exitButton.setFont(buttonFont);
        //Add Button to Panel
        startPanel.add(startButton);
        exitPanel.add(exitButton);
        buttonPanel.add(startPanel);
        buttonPanel.add(exitPanel);

        //Add ButtonPanel to BottomPanel
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        //Add Panel to Frame
        frame.add(topPanel);
        frame.add(bottomPanel);

        frame.setSize(1000, 850);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameMenu();
    }
}
