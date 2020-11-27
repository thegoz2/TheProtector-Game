public class  Monster {
    private int Hp;
    protected int atk = 1;

    public Monster(int hp) {

    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        this.Hp = hp;
    }

    public int Attack() {
        return this.Hp = getHp () - atk;
    }
}
