import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class MonsterCard{
    private JFrame frame;
    public  Timer timer = new Timer ();
    private JLabel mon1, mon2, mon3, mon4, mon5, boss;
    private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;

    public JPanel monCardPanel, monPanel1, monPanel2, monPanel3, monPanel4, monPanel5, monPanel6;
    public CardLayout c;

    public MonsterCard(){
        c = new CardLayout();

        monCardPanel = new JPanel(c);
        //Set Frame
        frame = new JFrame();
        frame.setSize(1000, 850);

        //Set Monster Panel
        monPanel1 = new JPanel();
        monPanel1.setOpaque(false);
        monPanel2 = new JPanel();
        monPanel2.setOpaque(false);
        monPanel3 = new JPanel();
        monPanel3.setOpaque(false);
        monPanel4 = new JPanel();
        monPanel4.setOpaque(false);
        monPanel5 = new JPanel();
        monPanel5.setOpaque(false);
        monPanel6 = new JPanel();
        monPanel6.setOpaque(false);

        //Icon Monster
        icon1 = new ImageIcon((getClass().getResource("Tico.gif")));
        icon2 = new ImageIcon((getClass().getResource("Puddle.gif")));
        icon3 = new ImageIcon((getClass().getResource("Pickle.gif")));
        icon4 = new ImageIcon((getClass().getResource("Luna.gif")));
        icon5 = new ImageIcon((getClass().getResource("Compromise.gif")));
        icon6 = new ImageIcon((getClass().getResource("Val'zak.gif")));

        //Set Label
        mon1 = new JLabel(icon1);
        mon2 = new JLabel(icon2);
        mon3 = new JLabel(icon3);
        mon4 = new JLabel(icon4);
        mon5 = new JLabel(icon5);
        boss = new JLabel(icon6);

        //Add Label to Panel
        monPanel1.add(mon1);
        monPanel2.add(mon2);
        monPanel3.add(mon3);
        monPanel4.add(mon4);
        monPanel5.add(mon5);
        monPanel6.add(boss);

        //Add Panel to CardPanel
        monCardPanel.add(monPanel1, "1");
        monCardPanel.add(monPanel2, "2");
        monCardPanel.add(monPanel3, "3");
        monCardPanel.add(monPanel4, "4");
        monCardPanel.add(monPanel5, "5");
        monCardPanel.add(monPanel6, "6");

        monCardPanel.setBackground(new Color(0, 25, 50));//เปลี่ยนสีมอน


    }

    public void HitEffect(){
        monCardPanel.setBackground (Color.red);
        monCardPanel.setBackground (Color.red);
        timer.schedule(new TimerTask (){//delay คำสั่งทำในโค๊ตหลังเวลาผ่านไป
        @Override

        public void run() {

            monCardPanel.setBackground (new Color(0, 25, 50));
            monCardPanel.setBackground (new Color(0, 25, 50));
        }
        },100);



    }

}