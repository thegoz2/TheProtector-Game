import javax.swing.*;
import javax.swing.JComponent.*;

public class Model extends JComponent {

    public  int Combo = 1;
    public int Score = 0;


    public int getScore() {
        return Score;
    }

    public int InCorrect() {

        if (getScore () <= 0 || getScore ()<= 100) {
            this.Combo = 1;

             return this.Score=0;

        } else {
            this.Combo = 1;
             return this.Score = getScore () - 100 ;


        }

    }
        public int Correct(){

             this.Score=getScore ()+(100*this.Combo);
            this.Combo += 1;
            return Score;
        }

    }


