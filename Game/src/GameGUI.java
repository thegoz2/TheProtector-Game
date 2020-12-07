import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.*;

//ของจริง
public class GameGUI implements ActionListener, WindowListener {
    private JFrame frame;
    private JPanel topPanel, textPanel, buttonPanel, tandsPanel;
    private JLabel scoreLabel, monsterHPLabel;
    private JButton bt1, bt2, bt3, bt4;
    private JTextField tf1, tf2;
    private Image img = Toolkit.getDefaultToolkit().getImage("D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\Background.png");
    private ArrayProblems arrayProblems= new ArrayProblems();
    private int quiz = 0;
    private int num = 1;

    private Font font;
    private CountTime time;
    private Thread t;
    private MonsterCard monsterPanel;

    public GameGUI() {
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

        //Set Array


        //Set Frame
        frame = new JFrame("The Protecter");

        //Set CardLayout

        //Set Font
        font = new Font("TH SarabunPSK", 1, 30);

        //SetJFrame
        frame = new JFrame("The Protecter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(1200, 1000);

        //SetTextPanel
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setOpaque(false);
        //SetTopPanel
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 25, 50));


        //Time&Score Panel
        //Set T&SPanel
        tandsPanel = new JPanel(new BorderLayout(1, 3));
        tandsPanel.setOpaque(false);
        //SetTime
        time = new CountTime();
        //Thread
        t = new Thread(time);
        t.start();
        //Set Monster HP and My HP
        monsterHPLabel = new JLabel("Monster's HP : 2");
        scoreLabel = new JLabel("Score : 0");
        monsterHPLabel.setFont(font);
        scoreLabel.setFont(font);
        monsterHPLabel.setForeground(Color.WHITE);
        scoreLabel.setForeground(Color.WHITE);
        monsterHPLabel.setHorizontalAlignment(JLabel.CENTER);
        monsterHPLabel.setVerticalAlignment(JLabel.CENTER);
        //Add All to Time&Score Panel
        tandsPanel.add(time, BorderLayout.WEST);
        tandsPanel.add(monsterHPLabel, BorderLayout.CENTER);
        tandsPanel.add(scoreLabel, BorderLayout.EAST);

        //TextField
        tf1 = new JTextField("Problems : "+arrayProblems.arrayQuiz[quiz][0]);
        tf2 = new JTextField("Your HP : ");
        tf1.setFont(font);
        tf2.setFont(font);
        tf1.setEditable(false);
        tf2.setEditable(false);
        //addTextArea to TextPanel
        textPanel.add(tf1, BorderLayout.CENTER);
        textPanel.add(tf2, BorderLayout.WEST);

        //ButtonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        //Button
        bt1 = new JButton(arrayProblems.arrayQuiz[quiz][1]);
        bt2 = new JButton(arrayProblems.arrayQuiz[quiz][2]);
        bt3 = new JButton(arrayProblems.arrayQuiz[quiz][3]);
        bt4 = new JButton(arrayProblems.arrayQuiz[quiz][4]);
        bt1.setFont(font);
        bt2.setFont(font);
        bt3.setFont(font);
        bt4.setFont(font);
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

        //Set MonsterPanel
        monsterPanel = new MonsterCard();
        //addCardPanel&TextPanel to TopPanel
        topPanel.add(tandsPanel, BorderLayout.NORTH);
        topPanel.add(monsterPanel.monCardPanel, BorderLayout.CENTER);
        topPanel.add(textPanel, BorderLayout.SOUTH);
        //addCTopPanel&ButtonPanel to JFrame
        frame.add(topPanel);
        frame.add(buttonPanel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if(click.getSource().equals(bt1)) {
            if(arrayProblems.arrayQuiz[quiz][1].equals(arrayProblems.arrayQuiz[quiz][5]) && quiz < 14){
                quiz++;
                num++;
                monsterPanel.c.show(monsterPanel.monCardPanel, num+"");
                tf1.setText(arrayProblems.arrayQuiz[quiz][0]);
                bt1.setText(arrayProblems.arrayQuiz[quiz][1]);
                bt2.setText(arrayProblems.arrayQuiz[quiz][2]);
                bt3.setText(arrayProblems.arrayQuiz[quiz][3]);
                bt4.setText(arrayProblems.arrayQuiz[quiz][4]);
                System.out.println(quiz);
            }

        }
        else if(click.getSource().equals(bt2)) {
            if(arrayProblems.arrayQuiz[quiz][2].equals(arrayProblems.arrayQuiz[quiz][5]) && quiz < 14){
                quiz++;
                monsterPanel.c.show(monsterPanel.monCardPanel, "4");
                num = 4;
                tf1.setText(arrayProblems.arrayQuiz[quiz][0]);
                bt1.setText(arrayProblems.arrayQuiz[quiz][1]);
                bt2.setText(arrayProblems.arrayQuiz[quiz][2]);
                bt3.setText(arrayProblems.arrayQuiz[quiz][3]);
                bt4.setText(arrayProblems.arrayQuiz[quiz][4]);
                System.out.println(quiz);
            }

        }
        else if(click.getSource().equals(bt3)) {
            if(arrayProblems.arrayQuiz[quiz][3].equals(arrayProblems.arrayQuiz[quiz][5]) && quiz < 14){
                quiz++;
                monsterPanel.c.show(monsterPanel.monCardPanel, "5");
                num = 5;
                tf1.setText(arrayProblems.arrayQuiz[quiz][0]);
                bt1.setText(arrayProblems.arrayQuiz[quiz][1]);
                bt2.setText(arrayProblems.arrayQuiz[quiz][2]);
                bt3.setText(arrayProblems.arrayQuiz[quiz][3]);
                bt4.setText(arrayProblems.arrayQuiz[quiz][4]);
                System.out.println(quiz);
            }

        }
        else if(click.getSource().equals(bt4)) {
            if(arrayProblems.arrayQuiz[quiz][4].equals(arrayProblems.arrayQuiz[quiz][5]) && quiz < 14){
                quiz++;
                monsterPanel.c.last(monsterPanel.monCardPanel);
                num = 6;
                tf1.setText(arrayProblems.arrayQuiz[quiz][0]);
                bt1.setText(arrayProblems.arrayQuiz[quiz][1]);
                bt2.setText(arrayProblems.arrayQuiz[quiz][2]);
                bt3.setText(arrayProblems.arrayQuiz[quiz][3]);
                bt4.setText(arrayProblems.arrayQuiz[quiz][4]);
                System.out.println(quiz);
            }

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    public static void main(String[] args) {
        new GameGUI();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
