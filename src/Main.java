import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Velkommen til svømmehals-programmet!");

        Main main = new Main();
        main.run();
    }

    public void run() {

        // Testfafsrasra

        // Util metoder
        PrisUdregner pris = new PrisUdregner();
        FilHandtering fil = new FilHandtering();
        BrugerHandler bruger = new BrugerHandler();




        // Stævne oprettelse
        // Stævne s1 = new Stævne("EM i butterfly", "Lygten 37", 123);

        // Bruger oprettelse
        /*
        KonkurrenceMedlem k1 = new KonkurrenceMedlem(21, "Flemming", true, true, "Butterfly", 100);
        KonkurrenceMedlem k2 = new KonkurrenceMedlem(15, "Lars", true, false, "Freestyle", 125);
        KonkurrenceMedlem k3 = new KonkurrenceMedlem(7, "Ib", true, false, "Freestyle",143);

        Motionist m1 = new Motionist(80, "Lotte",false, false);
        Motionist m2 = new Motionist(60, "Søren", true, true);
        Motionist m3 = new Motionist(44, "Else", true, false);
        Motionist m4 = new Motionist(50, "Henrik", false, true);
        */


        // Opret og tilføj til List (array)
        List<Motionist> motionister = new ArrayList();
        List<KonkurrenceMedlem> konkurrencemedlemmer = new ArrayList<>();

        bruger.opretMotionist(motionister, konkurrencemedlemmer);


        /*
        motionister.add(m1);
        motionister.add(m2);
        motionister.add(m3);
        motionister.add(m4);
        */
        /*
        konkurrencemedlemmer.add(k1);
        konkurrencemedlemmer.add(k2);
        konkurrencemedlemmer.add(k3);
        */

        fil.læsFil(motionister, konkurrencemedlemmer);
        fil.skrivFil(motionister, konkurrencemedlemmer);

        // Loop for alle motionister - Unsorted
        System.out.println("Motionister:");
        for (Motionist m : motionister) {
            System.out.println(m.getId() +" " +m.getNavn() +" " +m.getAge() +" " +pris.getPris(m.isAktiv(), m.getAge()) +" DKK");
        }

        System.out.println("- - -");
        System.out.println("KonkurrenceMedlemmer");
        for (KonkurrenceMedlem k : konkurrencemedlemmer) {
            System.out.println(k.getId() +" " +k.getNavn() +" " +k.getAge() +" " +pris.getPris(k.isAktiv(), k.getAge()) +" DKK " +k.getSwimType()+" "+k.getSwimTid() +" "+ k.getTræner());
        }
        // Sort
        // Collections.sort(motionister);

        /*
        // Loop for alle motionister - Sorted
        for (Motionist m : motionister) {
            // print

        }
        */
    }
}