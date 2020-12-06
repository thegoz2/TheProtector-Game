public class CreateMonster extends Model{


//tester
    public static void main(String[] args){

       Monster bobaphet = new Monster (40,10) ;
       bobaphet.setName ("bobaphet");

        Monster ajanas = new Monster (30,10) ;
        ajanas.setName ("Ajanas");

        Player Ohme = new Player ();

        Ohme.setName("Ohme");

        Ohme.Correct(Ohme,ajanas);



Ohme.InCorrect (Ohme,ajanas);
        Ohme.InCorrect (Ohme,ajanas);
        Ohme.InCorrect (Ohme,ajanas);Ohme.InCorrect (Ohme,ajanas);
        Ohme.InCorrect (Ohme,ajanas);
        Ohme.InCorrect (Ohme,ajanas);
        Ohme.InCorrect (Ohme,ajanas);

        System.out.println (ajanas.getName ()+": "+ajanas.getHp());
        System.out.println (bobaphet.getName ()+": "+bobaphet.getHp());
        System.out.println (Ohme.getName()+" เลือด : "+Ohme.getHp()); //hp เหลือ 35

        System.out.println (Ohme.getName()+" score : "+Ohme.getScore());

    }

}

