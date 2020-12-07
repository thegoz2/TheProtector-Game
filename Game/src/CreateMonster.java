public class CreateMonster {
<<<<<<< HEAD


    public  void CreateMonster(){
        Monster [] MonsterNum = new Monster[6];
=======
    public int monsterchange = 0;
   public Monster [] MonsterNum = new Monster[6];
    public CreateMonster(){

>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
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
<<<<<<< HEAD
    }
=======

    }
    public void monsternext(){ //index CreateMonster
         this.monsterchange =+ 1;
    }

    public int getMonsterchange() {
        return monsterchange;
    }
>>>>>>> 0215b076dc65719eaff31ebccff65290e73ef7fd
}
