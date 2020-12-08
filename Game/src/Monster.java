import java.lang.*;
public class  Monster  {
    private int Hp;
    public String name;
    public int atk;
    public boolean dead=false;
    public int monsterchange = 0;


    public Monster(int hp, int atk) {
        this.Hp = hp;
        this.atk = atk;

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


    public int Attacked(Player p) {
        int j = this.getHp ();
        int k = p.getAtk ();
        if (j - k >= 0) {
            return this.Hp = Hp - k;
        } else {
            return this.Hp = 0;
        }

    }


    public boolean monsterDead(Monster m) {
        if (m.getHp () <= 0) {
            return dead=true;
        }
        return dead=false;
    }
}