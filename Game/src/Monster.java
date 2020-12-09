import java.lang.*;
public class  Monster  {
    private int Hp;
    public String name;
    public int atk;
    public boolean dead=false;



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


    public int Attacked(Player p) { //ฟังชั่นไว้ตี  overload จากคลาสplayer
        int j = this.getHp ();
        int k = p.getAtk (); //รับพลังโจมตี player
        if (j - k >= 0) {       //ถ้าไม่ติดลบจะลดเลือดปกติทีละ10
            return this.Hp = Hp - k;
        } else {
            return this.Hp = 0;//ถ้าติดลบจะทำให้เลือดเป็น 0
        }

    }


    public boolean monsterDead(Monster m) { //ตรวจสอบว่ามอนตายไหม
        if (m.getHp () <= 0) {// เลือดน้อยกว่า0 หรือเท่ากับ 0
            return dead=true; //จะให้สถานะว่ามอนตายแล้วเป็นจริง
        }
        return dead=false; //จะให้สถานะว่ามอนยังไม่ตาย
    }
}