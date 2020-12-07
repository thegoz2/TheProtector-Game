import javax.swing.*;
import javax.swing.JComponent.*;

public class Model   {

    public  int Combo = 1;
    public int Score = 0;


    public int getScore() {
        return Score;
    }

    public int InCorrect(Player p,Monster m) {

        if (getScore () <= 0 || getScore ()<= 100) {
            this.Combo = 1;
            p.Attacked (m);
            return this.Score=0;

        } else {
            this.Combo = 1;
            p.Attacked (m);
            return this.Score = getScore () - 100 ;


        }

    }
    public int Correct(Player p,Monster m){

        this.Score=getScore ()+(100*this.Combo);
        this.Combo += 1;
        m.Attacked (p);
        return Score;
    }

}



