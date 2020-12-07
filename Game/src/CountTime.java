import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CountTime extends JLabel implements Runnable{
    public int num = 20;
    public int sec ;



    public CountTime(){

        this.setForeground(Color.WHITE);
        this.sec = num;
        Font font = new Font ( "TH SarabunPSK", Font.PLAIN, 30 );
        this.setFont(font);
        this.setText("Time : "+sec+"");
        this.setText(sec+"");

    }
    public int resettime(){//reset เวลา
        return num = 21;


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

                System.out.println("Sec : " +sec+ " Num : " +num);
                if(num == 0){//เวลาหมดแพ้ง่ะ
                    System.out.println ("GameOver");

                }

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
