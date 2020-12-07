import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CountTime extends JLabel implements Runnable{
    public int num = 10;

    public CountTime(){
        int sec = num;
        Font font = new Font ( "TH SarabunPSK", Font.PLAIN, 30 );
        this.setFont(font);
        this.setText("Time : "+sec+"");
        this.setForeground(Color.WHITE);
    }

    public void run(){
        try{
            while(num >= 0){
                int sec = num;
                Font font = new Font ( "TH SarabunPSK", Font.PLAIN, 30 );
                this.setFont(font);
                this.setText("Time : "+sec+"");
                Thread.sleep(1000);
                System.out.println("sec : "+sec+" num : "+num);
                num--;

            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public boolean checkingTime(){
        if(num == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
