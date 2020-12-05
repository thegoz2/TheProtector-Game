public class CreateMonster extends Model{


//tester
    public static void main(String[] args){

       Monster bobaphet = new Monster (40) ;
       bobaphet.setName ("bobaphet");
        bobaphet.setAtk (3);
        Monster ajanas = new Monster (30) ;
        ajanas.setName ("Ajanas");
        ajanas.setAtk (12);
        Player Ohme = new Player ();
        Ohme.setAtk (4);
        Ohme.setName("Ohme");
        Ohme.Attacked (bobaphet);//Ohme ถูกตีด้วย bobaphet 50-3
        Ohme.Attacked (ajanas);//47-15
        bobaphet.Attacked (Ohme);
        Ohme.Correct();

        Ohme.Correct();



        System.out.println (ajanas.getName ()+": "+ajanas.getHp());
        System.out.println (bobaphet.getName ()+": "+bobaphet.getHp());
        System.out.println (Ohme.getName()+" เลือด : "+Ohme.getHp()); //hp เหลือ 35

        System.out.println (Ohme.getName()+" score : "+Ohme.getScore());

    }

}

