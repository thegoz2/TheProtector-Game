import javax.swing.*;
import javax.swing.JComponent.*;

public class FuncScore {

    public  int Combo = 1;
    public int Score = 0;
    public int getScore() {
        return Score;
    }
    public int DecreaseScore(Player p,Monster m) {
        if (getScore () <= 0 || getScore ()<= 100) {//เช็คไม่ให้ติดลบ
            this.Combo = 1; //ทำลายการเพิ่มคะแนนที่ได้รับจากการตอบถูกต่อเนื่อง
            p.Attacked (m);
            return this.Score=0;

        } else //ถ้าไม่ติดลบ
            {
            this.Combo = 1;
            p.Attacked (m);
            return this.Score = getScore () - 100 ;
        }
    }
    public int IncreaseScore(Player p,Monster m){
        this.Score=getScore ()+(100*this.Combo);
        this.Combo += 1; //เพิ่มคะแนนที่ได้รับจากการตอบถูกต่อเนื่อง
        m.Attacked (p);
        return Score;
    }
}



