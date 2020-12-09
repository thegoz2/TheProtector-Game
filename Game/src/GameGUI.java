import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.*;
import java.util.Timer;
import java.util.TimerTask;

//ของจริง


public class GameGUI  implements ActionListener, WindowListener {

    private int incheck;
    public Timer timer = new Timer();
    private JFrame frame;
    private JPanel topPanel, textPanel, buttonPanel, tandsPanel;
    private JLabel scoreLabel, monsterHPLabel;
    private JButton bt1, bt2, bt3, bt4;
    private JTextField tf1, tf2;
    private Image img = Toolkit.getDefaultToolkit().getImage("D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\Background.png");
    private ArrayProblems arrayProblems= new ArrayProblems();
    private int quiz = 0;
    public CreateMonster monster = new CreateMonster ();
    public int monNum = 0;
    private Player Honey = new Player();
    private int nextMon = 1;


    private Font font;
    private CountTime time;
    private Thread t;
    private MonsterCard monsterPanel ;



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

        monsterHPLabel = new JLabel(monster.MonsterNum[monNum].getName ()+"'s HP : "+monster.MonsterNum[monNum].getHp ());
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
        tf2 = new JTextField("Your HP : "+Honey.getHp ());
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
    public void PlayerDead(){//เช็ค player เลือด 0ไหม
        if(Honey.getHp () == 0) {
            System.out.println ("Game over");
        }
    }



//choice
    public void ChoiceIncorrect(){


        Honey.DecreaseScore (Honey,monster.MonsterNum[monNum]); //ลดเหลือดplayer และ ลด คะแนน
        tf2.setText ("Your HP : "+Honey.getHp ());// โชว์เลือดผู้เล่น
        scoreLabel.setText ("Score : "+Honey.getScore ());// โชว์คะแนนผู้เล่น
        monsterPanel.HitEffect ();//effectโดนตี
        PlayerDead ();//player เลือดเหลือ 0 ตาย
    }

    public void ChoiceCorrect(){
        quiz ++; //เปลี่ยนคำถามไลังจากตอบถูก
        Honey.IncreaseScore (Honey,monster.MonsterNum[monNum]);//บวกคะแนน และ ลดเลือดมอน ทำparametor เพื่อเชื่อเช็ค ให้มอนเตอร์ตีกันได้
        tf2.setText ("Your HP : "+Honey.getHp ());//แสดงเลือดplayer ล่าสุด
        monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน
        timer.schedule(new TimerTask (){//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป
            @Override
            public void run() {
                tf1.setText(arrayProblems.arrayQuiz[quiz][0]); //เปลี่ยนคำถามหลังจากตอบถูก
                bt1.setText(arrayProblems.arrayQuiz[quiz][1]);
                bt2.setText(arrayProblems.arrayQuiz[quiz][2]);
                bt3.setText(arrayProblems.arrayQuiz[quiz][3]);
                bt4.setText(arrayProblems.arrayQuiz[quiz][4]);
                bt1.setBackground (null);
                bt2.setBackground (null);
                bt3.setBackground (null);
                bt4.setBackground (null);
                time.resettime ();//นับเวลาใหม่หลังจากตอบถูก
                if(monster.MonsterNum[monNum].monsterDead (monster.MonsterNum[monNum])==true){ //เช็คว่าตายไหม ถ้าตาย จะเปลี่ยนมอน
                    monNum +=1; //เปลี่ยนindex mon ก็คือเปลี่ยนstatus monster เป็นตัวถัดไป
                    nextMon++;//เปลี่ยนรูปมอนเตอร์
                    monsterPanel.c.show(monsterPanel.monCardPanel, nextMon+"");//เปลี่ยนรูปมอนเตอร์
                    monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือดมอนหลังโดนตี

                }
                scoreLabel.setText ("Score : "+Honey.getScore ());//แสดงคะแนนล่าสุด

            }
        },2500);

    }

public void UnBlcokBotton1() {//ห้ามกดปุ่ม 2 3 4
    bt2.setEnabled (false);
    bt3.setEnabled (false);
    bt4.setEnabled (false);
    timer.schedule (new TimerTask () {//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป
        @Override
        public void run() {
            bt2.setEnabled (true);
            bt3.setEnabled (true);
            bt4.setEnabled (true);

        }
    }, 2500);
}
    public void UnBlcokBotton2() {
        bt1.setEnabled (false);
        bt3.setEnabled (false);
        bt4.setEnabled (false);
        timer.schedule (new TimerTask () {//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป
            @Override
            public void run() {
                bt1.setEnabled (true);
                bt3.setEnabled (true);
                bt4.setEnabled (true);
            }
        }, 2500);
    }
    public void UnBlcokBotton3() {
        bt2.setEnabled (false);
        bt1.setEnabled (false);
        bt4.setEnabled (false);
        timer.schedule (new TimerTask () {//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป
            @Override
            public void run() {
                bt2.setEnabled (true);
                bt1.setEnabled (true);
                bt4.setEnabled (true);
            }
        }, 2500);
    }
    public void UnBlcokBotton4() {
        bt2.setEnabled (false);
        bt3.setEnabled (false);
        bt1.setEnabled (false);
        timer.schedule (new TimerTask () {//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป
            @Override
            public void run() {
                bt2.setEnabled (true);
                bt3.setEnabled (true);
                bt1.setEnabled (true);
            }
        }, 2500);
    }

    public void ChooseCorrect(){ //เลือกคำตอบที่ถูกตามarray
        String ans = arrayProblems.arrayQuiz[quiz][5];
        if(ans.equals("a1")) { //เช็คคำตอบที่ถูก ข้อหนึ่งถูก
            if(incheck == 1){ //ปุ่มถูกกดจะเปลี่ยนincheck เป็น 1 เอาไว้เช็คปุ่มที่โดนกด
                bt1.setBackground (Color.green);//โชว์สีเขียวเพื่อแสดงว่าถูก
                ChoiceCorrect ();//เปลี่ยนสีปุ่ม1 และ ทำฟังชั่นตอบถูก
                UnBlcokBotton1 ();//ห้ามกดปุ้มอื่นนอกจากปุ่มแรก
            }
            else if (incheck == 2) { //เช็คข้อ2 โดนกดรึป่าว
                bt2.setBackground (Color.red);
                ChoiceIncorrect ();//ถ้าโดนกดจะเปลี่ยนสีปุ่มเป็นแดง
            } else if (incheck == 3) {
                bt3.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 4) {
                bt4.setBackground (Color.red);
                ChoiceIncorrect ();
            }
        }
        else if(ans.equals("a2")){ // ข้อ2 ถูก
            if(incheck == 2){
                bt2.setBackground (Color.green);
                ChoiceCorrect ();
                UnBlcokBotton2 ();
            }
            else if (incheck == 1) {
                bt1.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 3) {
                bt3.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 4) {
                bt4.setBackground (Color.red);
                ChoiceIncorrect ();
            }
        }
        else if(ans.equals("a3")){//ข้อ 3 ถูก
            if(incheck == 3){
                bt3.setBackground (Color.green);
                ChoiceCorrect ();
                UnBlcokBotton3 ();
            }
            else if (incheck == 2) {
                bt2.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 1) {
                bt1.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 4) {
                bt4.setBackground (Color.red);
                ChoiceIncorrect ();
            }
        }
        else if(ans.equals("a4")){ //ข้อ 4 ถูก
            if(incheck == 4){
                bt4.setBackground (Color.green);
                ChoiceCorrect ();
                UnBlcokBotton4 ();
            }
            else if (incheck == 2) {
                bt2.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 3) {
                bt3.setBackground (Color.red);
                ChoiceIncorrect ();
            } else if (incheck == 1) {
                bt1.setBackground (Color.red);
                ChoiceIncorrect ();
            }
        }
    }

    @Override
    public  void actionPerformed(ActionEvent click)  {
        if(click.getSource().equals(bt1)) {
            incheck = 1;
            ChooseCorrect();
        }
        else if(click.getSource().equals(bt2)) {
            incheck = 2;
            ChooseCorrect();
        }
        else if(click.getSource().equals(bt3)) {
            incheck = 3 ;
            ChooseCorrect();
        }
        else if(click.getSource().equals(bt4)) {
            incheck = 4;
            ChooseCorrect();
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