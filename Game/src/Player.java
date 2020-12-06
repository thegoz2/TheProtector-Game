import java.lang.*;
import java.security.PrivateKey.*;

public class  Player extends Model implements haveStatus{

    private int Hp=50;
    private int atk=10;
    private String name;

public  Player(){}
    public int getScore(){
        return Score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return Hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int Atk) {
        this.atk = Atk;
    }

    public void setHp(int hp) {
        this.Hp = hp;
    }


    public int Attacked(Monster m) {
        int j = this.getHp ();
        int k = m.getAtk () ;
        if (j - k >= 0  ) {
            return this.Hp = Hp - k ;
        } else {
            return this.Hp = 0;
        }

    }
}
