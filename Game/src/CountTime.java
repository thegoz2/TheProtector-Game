import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CountTime extends JLabel implements Runnable{
    public int num = 10;

    public CountTime(){
        int sec = num;
        Font font = new Font ( "Helvetica", Font.PLAIN, 30 );
        this.setFont(font);
        this.setText("Time : "+sec+"");
    }

    public void run(){
        try{
            while(num >= 0){
                int sec = num;
                Font font = new Font ( "Helvetica", Font.PLAIN, 30 );
                this.setFont(font);
                this.setText("Time : "+sec+"");
                Thread.sleep(1000);
                num--;
                System.out.println("Sec : " +sec+ " Num : " +num);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
