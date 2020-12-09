import java.lang.*;
import java.security.PrivateKey.*;

public class  Player extends FuncScore {

    private int Hp=100;
    private int atk=10;
    private String name;

    public  Player(){}
    public int getScore(){
        return Score;
    }




    public int getHp() {
        return Hp;
    }

    public int getAtk() {
        return atk;
    }




    public int Attacked(Monster m) { //ผู้เล่นโดนตี
        int j = this.getHp (); //
        int k = m.getAtk () ;
        if (j - k >= 0  ) { //เช็คว่าติดลบไหม
            return this.Hp = Hp - k ;//คืนค่าhp ที่โดนตีแล้ว
        } else {
            return this.Hp = 0;
        }

    }
    //public void setName(String name) { เก็บไว้ใช้เพื่อหน้าใส่ชื่อ
    //    this.name = name;
    // }
    // public String getName() {
    //        return name;
    //    }
}