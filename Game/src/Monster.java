import java.lang.*;
public class  Monster {
    private int Hp;
    public String name;
    public  int atk ;

    public Monster(int hp) {
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

    public  int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setHp(int hp) {
        this.Hp = hp;
    }

    public int Attacked(Player p) {
       int j = p.getHp ();
       int k = p.getAtk ();
       if(j-k>=0){
           return this.Hp = Hp-k;
       }
        else{
            return this.Hp = 0;
       }

    }
}
