import java.lang.*;
public class  Player {
    private int Hp;
    private int atk;
    private String name;


    public Player(int hp) {
        this.Hp = hp;

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
        int j = m.getHp ();
        int k = m.getAtk ();
        if (j - k >= 0) {
            return this.Hp = Hp - k;
        } else {
            return this.Hp = 0;
        }

    }
}
