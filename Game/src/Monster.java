import java.lang.*;
public class  Monster  {
    private int Hp;
    public String name;
    public int atk;
    public boolean dead=false;
<<<<<<< HEAD
    public int monsterchange = 0;

=======


>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.Hp = hp;
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
<<<<<<< HEAD
    public int monsternext(){
        return this.monsterchange =+ 1;
    }
=======

>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd

    public boolean monsterDead(Monster m) {
        if (m.getHp () <= 0) {
            return dead=true;
        }
        return dead=false;
    }
}