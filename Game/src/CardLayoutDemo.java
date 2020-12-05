import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//โค้ดไว้สำหรับลองทำเฉยๆ
public class CardLayoutDemo extends MonsterCard implements ActionListener {
    private JFrame frame;
    private CardLayout c1, frameC1;
    private JPanel switchPanel, framePanel1, framePanel2, topPanel, cardPanel, textPanel, panel1, panel2, panel3, panel4, buttonPanel, tandsPanel;
    private JLabel lb1, lb2, lb3, lb4, scoreLabel, monsterHPLabel;
    private JButton bt1, bt2, bt3, bt4, btSwitch, btSwitchBack;
    private JTextField tf1, tf2;
    private ImageIcon icon1, icon2, icon3, icon4;
    private CountTime time, time2;
    private Thread t, t2;
    private Font font;

    private MonsterCard monsterPanel;

    public CardLayoutDemo()
    {
        //Set Class
        monsterPanel = new MonsterCard();

        //SetJFrame
        frame = new JFrame("The Protector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 850);

        //SetFrameCard
        frameC1 = new CardLayout();
        //SetSwitchPanel
        switchPanel = new JPanel();
        switchPanel.setLayout(frameC1);

        //SetFramePanel
        framePanel1 = new JPanel(new GridLayout(2, 1));
        framePanel2 = new JPanel(new BorderLayout());

        //Button5
        btSwitchBack = new JButton("Switch Back");
        btSwitchBack.addActionListener(this);
        framePanel2.add(btSwitchBack, BorderLayout.WEST);
        //Thread2
        time2 = new CountTime();
        t2 = new Thread(time2);
        framePanel2.add(time2, BorderLayout.CENTER);

        //SetCardPanel
        c1 = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(c1);
        //SetTextPanel
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        //SetTopPanel
        topPanel = new JPanel(new BorderLayout());

        //Time&Score Panel
        //Set T&SPanel
        tandsPanel = new JPanel(new BorderLayout(1, 3));
        //SetTime
        time = new CountTime();
        //Thread
        t = new Thread(time);
        t.start();
        //Set Monster HP and My HP
        font = new Font ( "Helvetica", Font.PLAIN, 30 );
        monsterHPLabel = new JLabel("Monster's HP : 2");
        scoreLabel = new JLabel("Score : 0");
        monsterHPLabel.setFont(font);
        scoreLabel.setFont(font);
        monsterHPLabel.setHorizontalAlignment(JLabel.CENTER);
        monsterHPLabel.setVerticalAlignment(JLabel.CENTER);
        //Add All to Time&Score Panel
        tandsPanel.add(time, BorderLayout.WEST);
        tandsPanel.add(monsterHPLabel, BorderLayout.CENTER);
        tandsPanel.add(scoreLabel, BorderLayout.EAST);

        //TextField
        tf1 = new JTextField("Problems : ");
        tf2 = new JTextField("Life : ");
        tf1.setEditable(false);
        tf2.setEditable(false);
        //addTextArea to TextPanel
        textPanel.add(tf1, BorderLayout.CENTER);
        textPanel.add(tf2, BorderLayout.WEST);

        //Icon
        icon1 = new ImageIcon((getClass().getResource("kul.png")));
        icon2 = new ImageIcon((getClass().getResource("safi.png")));
        icon3 = new ImageIcon((getClass().getResource("ala.png")));
        icon4 = new ImageIcon((getClass().getResource("fata.png")));
        //Label
        lb1 = new JLabel(icon1);
        lb2 = new JLabel(icon2);
        lb3 = new JLabel(icon3);
        lb4 = new JLabel(icon4);
        //addLabel to Panel
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel1.add(lb1);
        panel2.add(lb2);
        panel3.add(lb3);
        panel4.add(lb4);
        //addPanel to CardPanel
        cardPanel.add(panel1, "1");
        cardPanel.add(panel2, "2");
        cardPanel.add(panel3, "3");
        cardPanel.add(panel4, "4");

        //ButtonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        //Button
        bt1 = new JButton("Button 1");
        bt2 = new JButton("Button 2");
        bt3 = new JButton("Button 3");
        bt4 = new JButton("Button 4");
        //addActionListener to Button
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        //addButton to ButtonPanel
        buttonPanel.add(bt1);
        buttonPanel.add(bt2);
        buttonPanel.add(bt3);
        buttonPanel.add(bt4);

        //SwitchButton
        btSwitch = new JButton("Switch Button");
        btSwitch.addActionListener(this);

        //addCardPanel&TextPanel to TopPanel
        topPanel.add(tandsPanel, BorderLayout.NORTH);
        topPanel.add(monCardPanel, BorderLayout.CENTER);
        topPanel.add(textPanel, BorderLayout.SOUTH);
        topPanel.add(btSwitch, BorderLayout.EAST);
        //addCTopPanel&ButtonPanel to JFrame
        framePanel1.add(topPanel);
        framePanel1.add(buttonPanel);

        switchPanel.add(framePanel1, "1");
        switchPanel.add(framePanel2, "2");

        frame.add(switchPanel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent click) {
        if(click.getSource().equals(bt1)) {
            c.first(monCardPanel);

        }
        else if(click.getSource().equals(bt2)) {
            c.show(monCardPanel, "2");

        }
        else if(click.getSource().equals(bt3)) {
            c.show(monCardPanel, "3");

        }
        else if(click.getSource().equals(bt4)) {
            c.last(monCardPanel);

        }
        else if(click.getSource().equals(btSwitch)) {
            frameC1.last(switchPanel);
            t = new Thread(time2);
            t.start();
        }
        else if(click.getSource().equals(btSwitchBack)) {
            frameC1.first(switchPanel);
        }
    }

    // Main Method
    public static void main(String[] args)
    {
        new CardLayoutDemo();
    }

}
