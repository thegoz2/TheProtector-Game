public class CreateMonster {
    public int monsterchange = 0;
   public Monster [] MonsterNum = new Monster[6];
    public CreateMonster(){

         MonsterNum[0] =  new Monster (20,10);
         MonsterNum[0].setName ("Tico");
        MonsterNum[1] =  new Monster (20,10);
        MonsterNum[1].setName ("Puddle");
        MonsterNum[2] =  new Monster (20,10);
        MonsterNum[2].setName ("Pickel");
        MonsterNum[3] =  new Monster (20,10);
        MonsterNum[3].setName ("Beluga");
        MonsterNum[4] =  new Monster (20,10);
        MonsterNum[4].setName ("Luna");
        MonsterNum[5] =  new Monster (50,10);
        MonsterNum[5].setName ("Sirawich");

    }
    public void monsternext(){ //index CreateMonster
         this.monsterchange =+ 1;
    }

    public int getMonsterchange() {
        return monsterchange;
    }
}
