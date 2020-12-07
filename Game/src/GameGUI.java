import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager.*;

//ของจริง
<<<<<<< HEAD
public class GameGUI implements ActionListener, WindowListener {
=======

public class GameGUI   implements ActionListener, WindowListener {
    public int check=0,numMonster=0;
    private int incheck;
    public Timer timer;
    //monsterchange += 1 เปลี่ยนมอนสเตอร์
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
    private JFrame frame;
    private JPanel topPanel, textPanel, buttonPanel, tandsPanel;
    private JLabel scoreLabel, monsterHPLabel;
    private JButton bt1, bt2, bt3, bt4;
    private JTextField tf1, tf2;
<<<<<<< HEAD
    private Image img = Toolkit.getDefaultToolkit().getImage("D:\\IT KMITL ปี 2\\OOP\\ProjectGame (Multi)\\src\\Background.png");
    private ArrayProblems arrayProblems= new ArrayProblems();
    private int quiz = 0;
    private int num = 1;
=======
    private Monster TicoMonster = new Monster (20,10),pudleMonster = new Monster (20,10);
    public CreateMonster monster = new CreateMonster ();
    public int monNum = monster.getMonsterchange ();
    private Player Honey = new Player();

>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd

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


<<<<<<< HEAD
        //Set Frame
        frame = new JFrame("The Protecter");

        //Set CardLayout

        //Set Font
        font = new Font("TH SarabunPSK", 1, 30);

=======
            //อันนี้เป็น theme ของระบบ
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)  { }
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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
<<<<<<< HEAD
        monsterHPLabel = new JLabel("Monster's HP : 2");
=======
        font = new Font ( "Helvetica", Font.PLAIN, 30 );
        monsterHPLabel = new JLabel(monster.MonsterNum[monNum].getName ()+"'s HP : "+monster.MonsterNum[monNum].getHp ());
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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
<<<<<<< HEAD
        tf1 = new JTextField("Problems : "+arrayProblems.arrayQuiz[quiz][0]);
        tf2 = new JTextField("Your HP : ");
        tf1.setFont(font);
        tf2.setFont(font);
=======
        tf1 = new JTextField("Problems : "+"ทำไมแมวต้องกินปลา");
        tf2 = new JTextField("Your HP : "+Honey.getHp ()); tf1 = new JTextField("Problems : ");

>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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

<<<<<<< HEAD
        //Set MonsterPanel
        monsterPanel = new MonsterCard();
=======


>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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



    public void Choice1Incorrect(){
        c1.show(cardPanel, "2");
        bt1.setBackground (Color.red);
        Honey.InCorrect (Honey,monster.MonsterNum[monNum]); //ลดเหลือดplayer และ ลด คะแนน
        tf2.setText ("Your HP : "+Honey.getHp ());// โชว์เลือดผู้เล่น
        scoreLabel.setText ("Score : "+Honey.getScore ());// โชว์คะแนนผู้เล่น

        PlayerDead ();//player เลือดเหลือ 0 ตาย
    }
    public void Choice2Incorrect(){
        c1.show(cardPanel, "2");
        bt2.setBackground (Color.red);
        Honey.InCorrect (Honey,monster.MonsterNum[monNum]); //ลดเหลือดplayer และ ลด คะแนน
        tf2.setText ("Your HP : "+Honey.getHp ());// โชว์เลือดผู้เล่น
        scoreLabel.setText ("Score : "+Honey.getScore ());// โชว์คะแนนผู้เล่น

        PlayerDead ();//player เลือดเหลือ 0 ตาย
    }
    public void Choice3Incorrect(){
        c1.show(cardPanel, "2");
        bt3.setBackground (Color.red);
        Honey.InCorrect (Honey,monster.MonsterNum[monNum]); //ลดเหลือดplayer และ ลด คะแนน
        tf2.setText ("Your HP : "+Honey.getHp ());// โชว์เลือดผู้เล่น
        scoreLabel.setText ("Score : "+Honey.getScore ());// โชว์คะแนนผู้เล่น

        PlayerDead ();//player เลือดเหลือ 0 ตาย
    }
    public void Choice4Incorrect(){
        c1.show(cardPanel, "2");
        bt4.setBackground (Color.red);
        Honey.InCorrect (Honey,monster.MonsterNum[monNum]); //ลดเหลือดplayer และ ลด คะแนน
        tf2.setText ("Your HP : "+Honey.getHp ());// โชว์เลือดผู้เล่น
        scoreLabel.setText ("Score : "+Honey.getScore ());// โชว์คะแนนผู้เล่น

        PlayerDead ();//player เลือดเหลือ 0 ตาย
    }

<<<<<<< HEAD
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
=======

    public void Choice1Correct(){
        bt1.setBackground (Color.green);//โชว์สีเขียวเพื่อแสดงว่าถูก
        Honey.Correct (Honey,monster.MonsterNum[monNum]);//บวกคะแนน และ ลดเลือดมอน
        tf2.setText ("Your HP : "+Honey.getHp ());//แสดงเลือดplayer ล่าสุด
        monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

        timer.schedule(new TimerTask (){//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป

            @Override
            public void run() {
                c1.first(cardPanel);
                bt2.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt3.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt4.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setBackground (null);
                bt2.setBackground (null);
                bt3.setBackground (null);
                bt4.setBackground (null);
                time.resettime ();
                if(monster.MonsterNum[monNum].monsterDead (monster.MonsterNum[monNum])==true){
                    monNum +=1;
                    monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

                }

                scoreLabel.setText ("Score : "+Honey.getScore ());//แสดงคะแนนล่าสุด

            }
        },2500);
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd

    }

    public void Choice2Correct(){
        bt2.setBackground (Color.green);//โชว์สีเขียวเพื่อแสดงว่าถูก
        Honey.Correct (Honey,monster.MonsterNum[monNum]);//บวกคะแนน และ ลดเลือดมอน
        tf2.setText ("Your HP : "+Honey.getHp ());//แสดงเลือดplayer ล่าสุด
        monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

        timer.schedule(new TimerTask (){//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป

            @Override
            public void run() {
                c1.first(cardPanel);
                bt2.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt3.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt4.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setBackground (null);
                bt2.setBackground (null);
                bt3.setBackground (null);
                bt4.setBackground (null);
                time.resettime ();
                if(monster.MonsterNum[monNum].monsterDead (monster.MonsterNum[monNum])==true){
                   monNum +=1;
                    monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

                }

                scoreLabel.setText ("Score : "+Honey.getScore ());//แสดงคะแนนล่าสุด

            }
        },2500);

    }
    public void Choice3Correct(){
        bt3.setBackground (Color.green);//โชว์สีเขียวเพื่อแสดงว่าถูก
        Honey.Correct (Honey,monster.MonsterNum[monNum]);//บวกคะแนน และ ลดเลือดมอน
        tf2.setText ("Your HP : "+Honey.getHp ());//แสดงเลือดplayer ล่าสุด
        monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

        timer.schedule(new TimerTask (){//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป

            @Override
            public void run() {
                c1.first(cardPanel);
                bt2.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt3.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt4.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setBackground (null);
                bt2.setBackground (null);
                bt3.setBackground (null);
                bt4.setBackground (null);
                time.resettime ();
                if(monster.MonsterNum[monNum].monsterDead (monster.MonsterNum[monNum])==true){
                    monNum +=1;
                    monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

                }

                scoreLabel.setText ("Score : "+Honey.getScore ());//แสดงคะแนนล่าสุด

            }
        },2500);


    }
    public void Choice4Correct(){
        bt4.setBackground (Color.green);//โชว์สีเขียวเพื่อแสดงว่าถูก
        Honey.Correct (Honey,monster.MonsterNum[monNum]);//บวกคะแนน และ ลดเลือดมอน
        tf2.setText ("Your HP : "+Honey.getHp ());//แสดงเลือดplayer ล่าสุด
        monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

        timer.schedule(new TimerTask (){//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป

            @Override
            public void run() {
                c1.first(cardPanel);
                bt2.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt3.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt4.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setText("ใส่คำถามชุดต่อไปในjson[0]");
                bt1.setBackground (null);
                bt2.setBackground (null);
                bt3.setBackground (null);
                bt4.setBackground (null);
                time.resettime ();
                if(monster.MonsterNum[monNum].monsterDead (monster.MonsterNum[monNum])==true){
                    monNum +=1;
                    monsterHPLabel.setText (monster.MonsterNum[monNum].getName ()+"'s HP : "+Integer.toString(monster.MonsterNum[monNum].getHp ()));//แสดงเลือมอน

                }

                scoreLabel.setText ("Score : "+Honey.getScore ());//แสดงคะแนนล่าสุด

            }
        },2500);

    }
    public void ChooseCorrect(){ //เลือกคำตอบที่ถูกตามarray
        String ans = "q2";
        if(ans=="q1") { //เช็คคำตอบที่ถูก ข้อหนึ่งถูก
            if(incheck == 1){ //ปุ่มถูกกดจะเปลี่ยนincheck เป็น 1 เอาไว้เช็คปุ่มที่โดนกด
                Choice1Correct ();//เปลี่ยนสีปุ่ม1 และ ทำฟังชั่นตอบถูก
            }
            else if (incheck == 2) { //เช็คข้อ2 โดนกดรึป่าว
                Choice2Incorrect ();//ถ้าโดนกดจะเปลี่ยนสีปุ่มเป็นแดง
            } else if (incheck == 3) {
                Choice3Incorrect ();
            } else if (incheck == 4) {
                Choice4Incorrect ();
            }
        }
<<<<<<< HEAD
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
=======
        else if(ans == "q2"){ // ข้อ2 ถูก
            if(incheck == 2){
                Choice2Correct ();
            }
            else if (incheck == 1) {
                Choice1Incorrect ();
            } else if (incheck == 3) {
                Choice3Incorrect ();
            } else if (incheck == 4) {
                Choice4Incorrect ();
            }
        }
        else if(ans == "q3"){//ข้อ 3 ถูก
            if(incheck == 3){
                Choice3Correct ();
            }
            else if (incheck == 2) {
                Choice2Incorrect ();
            } else if (incheck == 1) {
                Choice1Incorrect ();
            } else if (incheck == 4) {
                Choice4Incorrect ();
            }
        }
        else if(ans == "q4"){ //ข้อ 4 ถูก
            if(incheck == 4){
                Choice4Correct ();
            }
            else if (incheck == 2) {
                Choice2Incorrect ();
            } else if (incheck == 3) {
                Choice3Incorrect ();
            } else if (incheck == 1) {
                Choice1Incorrect ();
            }}
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
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd

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