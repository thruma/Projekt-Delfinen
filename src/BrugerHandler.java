import java.util.List;
import java.util.Scanner;

public class BrugerHandler {
    // KonkurrenceMedlem k1 = new KonkurrenceMedlem(21, "Flemming", true, true, "Butterfly", 100);
    // Motionist m1 = new Motionist(80, "Lotte",false, false);
    Scanner scanner = new Scanner(System.in);

    public void opretMotionist(List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer) {
        System.out.println("Du er ved at lave brugere!");

        int brugerType;
        boolean again = true;

        int age;
        String navn;
        boolean aktiv;
        boolean restance;
        String swinType;
        int swimTid;
        String træner = "Thomas";

        while (again) {
            System.out.println("Hvilken type svømmer 1/2");
            System.out.println("1 for motionist, 2 for konkurrencemedlem");
            brugerType = scanner.nextInt();


            System.out.print("age: ");
            age = scanner.nextInt();
            System.out.print("navn: ");
            navn = scanner.next();

            System.out.print("aktiv Ja/Nej: ");
            aktiv = jaNej();

            System.out.print("restance Ja/Nej: ");
            restance = jaNej();

            if (brugerType == 1) {
                Motionist motionistListe = new Motionist(age, navn, aktiv, restance);
                motionister.add(motionistListe);
            } else if (brugerType == 2) {
                KonkurrenceMedlem konkurrenceMedlemListe = new KonkurrenceMedlem(age, navn, aktiv, restance, "", 0,  "Thomas");
                konkurrencemedlemmer.add(konkurrenceMedlemListe);
            } else {
                System.out.println("Forkert type");
            }


            System.out.println("Vil du fortsætte? Ja/Nej");
            again = jaNej();
        }
    }

    public boolean jaNej() {
        boolean returnValue;
        String jaNej;
        char jn;

        do {
            jaNej = scanner.next().toLowerCase();
            jn = jaNej.charAt(0);
        } while (jn != 'j' && jn != 'n');

        if (jn == 'j') {
            returnValue = true;
        } else if (jn == 'n') {
            returnValue = false;
        } else {
            System.out.println("Forkert input, prøv igen!");
            returnValue = false;
        }
        return returnValue;
    }

    /*
    public int brugerOpretMenu() {
        Scanner scanner = new Scanner(System.in);
        int valg = scanner.nextInt();


        switch (valg) {
            case 1:
                // Motionist

                break;

            case 2:
                // Konkurrence

                break;

            default:
                System.out.println("Du har dummet dig, idiot!");
                break;
        }
    */
    public void opdaterBruger()
    {

    }
}
