import java.util.List;
import java.util.Scanner;

public class BrugerHandler {
    // KonkurrenceMedlem k1 = new KonkurrenceMedlem(21, "Flemming", true, true, "Butterfly", 100);
    // Motionist m1 = new Motionist(80, "Lotte",false, false);
    Scanner scanner = new Scanner(System.in);

    public void opretBruger(List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer) {
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

    public void opdaterBruger(List<KonkurrenceMedlem>konkurrencemedlemmer)
    {
        int idValg;
        int valg;

        boolean again = true;

        printKonkurrenceListe(konkurrencemedlemmer);
        System.out.println("Her er en list over konkurrence medlemmer skriv det id du gerne vil rette");

        idValg = scanner.nextInt();
        while(again) {
            for (KonkurrenceMedlem k : konkurrencemedlemmer) {
                if (idValg == k.getId()) {
                    System.out.printf("%-12s", k.getNavn());
                    System.out.printf("%-15s", k.getSwimType());
                    System.out.printf("%-8s", k.getSwimTid());
                    System.out.println(k.getTræner());

                    System.out.println("Hvad vil du ændre");
                    System.out.println("1 Disciplin\n2 Tid\n3 Træner");

                    valg = scanner.nextInt();

                    switch (valg) {


                        case 1:
                            //Disciplin
                            System.out.print("skriv ny disciplen: ");
                            k.setSwimType(scanner.next());
                            break;

                        case 2:
                            //Tid
                            System.out.print("indsæt ny: ");
                            k.setSwimTid(scanner.nextInt());
                            break;

                        case 3:
                            //Træner
                            System.out.print("skriv træner: ");
                            k.setTræner(scanner.next());
                            break;

                        default:
                            System.out.println("Forkert valg");
                    }
                    System.out.println("vil du fortsætte?");
                    again = jaNej();
                }
            }
        }
    }

    public void sletBruger(List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer) {

        int idValg;
        int valg;
        int count = 0;

        boolean again = true;
        boolean flag = false;
        boolean godkendSlet;

        printLister(motionister, konkurrencemedlemmer);
        System.out.println("Her er en list over medlemmer skriv det id du gerne vil slette");

        idValg = scanner.nextInt();

        for (Motionist m : motionister) {
            if (idValg == m.getId()) {
                flag = true;
                // gøt noget
                System.out.println(m.getNavn());
                System.out.println("Vil du slette? j/n");
                godkendSlet = jaNej();

                if (godkendSlet) {
                    motionister.remove(m); // Brug for hjælp - Lektiecafé
                }
            }
        }
        while (!flag || count < 1) {
            for (KonkurrenceMedlem k : konkurrencemedlemmer) {
                if (idValg == k.getId()) {
                    flag = true;
                    // gør noget
                    // magen til ovenfor
                }
            }
            if (flag) {
                // success
            } else {
                System.out.println("Bruger ikke fundet!");
            }
            count++;
        }
    }

    public void printKonkurrenceListe(List<KonkurrenceMedlem> konkurrencemedlemmer) {
        System.out.println("KonkurrenceMedlemmer");
        System.out.printf("%-4s", "ID");
        System.out.printf("%-12s", "Navn");
        System.out.printf("%-8s", "Alder");
        System.out.printf("%-15s", "Disciplin");
        System.out.printf("%-8s", "Tid");
        System.out.print("Træner");
        System.out.println();

        for (KonkurrenceMedlem k : konkurrencemedlemmer) {
            System.out.printf("%-4s", k.getId());
            System.out.printf("%-12s", k.getNavn());
            System.out.printf("%-8s", k.getAge());
            System.out.printf("%-15s", k.getSwimType());
            System.out.printf("%-8s", k.getSwimTid());
            System.out.print(k.getTræner());
            System.out.println();
        }
    }
    public void printLister(List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer) {
        System.out.println("KonkurrenceMedlemmer");
        System.out.printf("%-4s", "ID");
        System.out.printf("%-12s", "Navn");
        System.out.println();

        for (Motionist m : motionister) {
            System.out.printf("%-4s", m.getId());
            System.out.printf("%-12s", m.getNavn());
            System.out.println();
        }

        for (KonkurrenceMedlem k : konkurrencemedlemmer) {
            System.out.printf("%-4s", k.getId());
            System.out.printf("%-12s", k.getNavn());
            System.out.println();
        }
    }
}



