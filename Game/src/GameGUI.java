import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Timer;
import java.util.TimerTask;


//ของจริง

public class GameGUI   implements ActionListener, WindowListener {
    public int check=0,numMonster=0;
    private int incheck;
    public Timer timer;
    //monsterchange += 1 เปลี่ยนมอนสเตอร์
    private JFrame frame;
    private CardLayout c1;
    private JPanel topPanel, cardPanel, textPanel, panel1, panel2, panel3, panel4, buttonPanel, tandsPanel;
    private JLabel lb1, lb2, lb3, lb4, scoreLabel, monsterHPLabel;
    private JButton bt1, bt2, bt3, bt4;
    private JTextField tf1, tf2;
    private Monster TicoMonster = new Monster (20,10),pudleMonster = new Monster (20,10);
    public CreateMonster monster = new CreateMonster ();
    public int monNum = monster.getMonsterchange ();
    private Player Honey = new Player();


    private ImageIcon icon1, icon2, icon3, icon4;
    private Font font;
    private CountTime time;
    private MonsterCard monsterPanel;
    private Thread t;

    public GameGUI() {
        try {
            //อันนี้เรียกใช้จาก Library ของ java โดย Default //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            //อันนี้เป็นของแถมมากับเจ้า Library ของ java เช่นกัน
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

            //อันนี้เป็น theme ของระบบ
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)  { }
        //SetJFrame

        frame = new JFrame("The Protecter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(1000, 1000);

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
        monsterHPLabel = new JLabel(monster.MonsterNum[monNum].getName ()+"'s HP : "+monster.MonsterNum[monNum].getHp ());
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
        tf1 = new JTextField("Problems : "+"ทำไมแมวต้องกินปลา");
        tf2 = new JTextField("Your HP : "+Honey.getHp ()); tf1 = new JTextField("Problems : ");

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



        //addCardPanel&TextPanel to TopPanel
        topPanel.add(tandsPanel, BorderLayout.NORTH);
        topPanel.add(cardPanel, BorderLayout.CENTER);
        topPanel.add(textPanel, BorderLayout.SOUTH);
        //addCTopPanel&ButtonPanel to JFrame
        frame.add(topPanel);
        frame.add(buttonPanel);
        frame.addWindowListener(this);
        frame.setVisible(true);
        timer = new Timer();




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