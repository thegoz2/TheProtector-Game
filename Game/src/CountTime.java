import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class CountTime extends JLabel implements Runnable{
    public int num = 20;
    public int sec ;



    public CountTime(){
<<<<<<< HEAD
        int sec = num;
        Font font = new Font ( "TH SarabunPSK", Font.PLAIN, 30 );
        this.setFont(font);
        this.setText("Time : "+sec+"");
        this.setForeground(Color.WHITE);
=======
        this.sec = num;
        Font font = new Font ( "Helvetica", Font.PLAIN, 30 );
        this.setFont(font);
        this.setText("Time : "+sec+"");
        this.setText(sec+"");

    }
    public int resettime(){//reset เวลา
        return num = 21;

>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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
<<<<<<< HEAD

=======
                System.out.println("Sec : " +sec+ " Num : " +num);
                if(num == 0){//เวลาหมดแพ้ง่ะ
                    System.out.println ("GameOver");

                }
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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
