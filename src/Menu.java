import java.util.*;

public class Menu {
    BrugerHandler bruger = new BrugerHandler();
    //FilHandtering fil = new FilHandtering();
    // Alternativt bare en retur-værdi, som bruges i main

    public void fMenu(List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer){
        Scanner scFMenu = new Scanner(System.in);
        int fMenuValg;

        System.out.println("Velkommen til håndtering af medlemmer.\n");
        System.out.println("Tryk 1 for at oprette nyt medlem ");
        System.out.println("Tryk 2 for at rette medlemsoplysninger ");
        System.out.println("Tryk 3 for at slette medlemmer");
        System.out.println("Tryk 4 for at udskrive alle medlemmer ");
        fMenuValg = scFMenu.nextInt();

        switch (fMenuValg) {
            case 1:
                System.out.println("Nu kan du oprette nye medlemmer");
                bruger.opretBruger(motionister, konkurrencemedlemmer);
                break;
            case 2:
                System.out.println("Nu kan du rette medlemsoplysninger");
                bruger.opdaterBruger(konkurrencemedlemmer);
                break;
            case 3:
                System.out.println("Nu kan du slette medlem");
                bruger.sletBruger(motionister,konkurrencemedlemmer);
                //slet medlem metode
                break;
            case 4:
                System.out.println("Her kan du se en oversigt over alle medlemmer");
                bruger.printLister(motionister,konkurrencemedlemmer);
                break;
            default:
                System.out.println("Det indtastede er ugyldigt. Prøv igen.");
        }//slut på switch
    }//slut på fMenu metode

        public void tMenu () {
            System.out.println("Velkommen til håndtering af svømmeresultater!");
            System.out.println("Tryk 1 for at registrere svømmeresultat.\n");
            System.out.println("Tryk 2 for at se oversigt over svømmeresultater.\n");
            Scanner scTMenu = new Scanner(System.in);
            int valgTMenu = Scanner.nextInt();
            switch (valgTMenu){
            case 1:
                System.out.println("Nu kan du registrere svømmeresultater.");
                //svømmeresultat()
                break;

            case 2:
                System.out.println("Nu kan du se oversigt over svømmeresultater.");
                System.out.println("");
                break;

                default:
                    System.out.println("Det indtastede er ugyldigt. Prøv igen.");
            }//slut på switch
        } //slut på tMenu metode

        public void kMenu () {
            System.out.println("Velkommen til oversigten af medlemmer i resistance");
            //Liste visning over medlemmer i resistance
        } //slut på kMenu metode
}//slut på Menu class

