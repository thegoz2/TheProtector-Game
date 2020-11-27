public class CreateMonster {



    public static void main(String[] args){

       Monster bobaphet = new Monster (40) ;
       bobaphet.setName ("bobaphet");
        bobaphet.setAtk (3);
        Monster ajanas = new Monster (30) ;
        ajanas.setName ("Ajanas");
        ajanas.setAtk (12);
        Player Ohme = new Player (20);
        Ohme.setAtk (4);
        Ohme.setName("Ohme");
        Ohme.Attacked (bobaphet);
        Ohme.Attacked (ajanas);
        bobaphet.Attacked (Ohme);


        System.out.println (ajanas.getName ()+": "+ajanas.getHp());
        System.out.println (bobaphet.getName ()+": "+bobaphet.getHp());
        System.out.println (Ohme.getName()+": "+Ohme.getHp());
    }

}

