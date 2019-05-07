import java.util.*;

public class Login {
    public void login (List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer) {
        System.out.println("Velkommen til Delfin Systemet!");
        System.out.println("Indtast dit kodeord for at fortsætte:");
        Menu menu = new Menu();



        Scanner scLogin = new Scanner(System.in);
        String loginValg = "0";


        if (loginValg == null) {
            return loginValg;
        }
        switch (loginValg) {
            case "Formand":
                //Kald på F Menu
                menu.fMenu(motionister, konkurrencemedlemmer);
                break;
            case "Træner":
                //Kald på T menu
                menu.tMenu();

                break;
            case "Kasser":
                //Kald på K menu
                menu.kMenu();
                break;
            default:
                System.out.println("Det indtastede er ugyldigt. Prøv igen.");
                break;
            //TO DO: Loop - så default leder tilbage til, at man kan taste koden.
            //TO DO: Man har kun 3 forsøg til at skrive koden.
        }//slut på switch*/
    }//slut på metoden
}//slut på Login klassen
