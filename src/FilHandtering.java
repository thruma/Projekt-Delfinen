import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FilHandtering {

    // Tager imod 2 lister og skriver dem til "Output.txt"
    // Skal helst kunne gøre det hele i en fil
    public void skrivFil(List<Motionist> motionister, List<KonkurrenceMedlem> konkurrencemedlemmer)
    {
        PrisUdregner pris = new PrisUdregner();
        try
        {
            FileWriter fw1 = new FileWriter("Motionist.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);


            // Skriver alle objekter fra motionister-listen til filen "Output.txt"
            for (Motionist m : motionister) {
                // bw.write("Jens\n");
                bw1.write(m.getAge() +"\t" +m.getNavn() +"\t" +m.isAktiv() + "\t" +m.isRestance() +"\n");
            }


            // Afslutter BufferReader
            bw1.close();

            FileWriter fw2 = new FileWriter("KonkurrenceMedlem.txt");
            BufferedWriter bw2 = new BufferedWriter(fw2);

            for (KonkurrenceMedlem k : konkurrencemedlemmer) {
                bw2.write(k.getAge() +"\t" +k.getNavn() +"\t" +k.isAktiv() + "\t" +k.isRestance() +"\t" +k.getSwimType()+"\t" +k.getSwimTid()+ "\t" +k.getTræner() +"\n");
            }

            bw2.close();
            // Vi prøver at få den til at splitte op på "###", så vi kan gøre det hele i en fil
            /*
            bw.write("###\n");
            for (KonkurrenceMedlem k : konkurrencemedlemmer) {
                // bw.write("Jens\n");
                bw.write(k.getAge() +"\t" +k.getNavn()  +"\t" +k.isAktiv() + "\t" +k.isRestance() +"\t" +k.getSwimType() + "\t" + k.getSwimTid()+"\n");
            }
            */


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR!");
        }
    }

    public void læsFil(List<Motionist> motionister,List<KonkurrenceMedlem>konkurrencemedlemmer) {
        String mFileLoc = "Motionist.txt";
        String kFileLoc = "KonkurrenceMedlem.txt";

        int age;
        String navn;
        boolean aktiv;
        boolean restance;
        String swimType;
        int swimTid;
        String træner;

        try {
            Scanner scanner1 = new Scanner(new File(mFileLoc));
            Scanner scanner2 = new Scanner(new File(kFileLoc));

            while (scanner1.hasNextLine()) {

                // Skaber et midlertidigt objekt, som vi splitter på tab, så vi kan fordele vores data i listen
                Object[] insertTo = scanner1.nextLine().split("\t");

                // Bruger vores midlertidige objekt til at positionere vores data samt type
                age = Integer.parseInt(insertTo[0].toString());
                navn = insertTo[1].toString();
                aktiv = Boolean.parseBoolean(insertTo[2].toString());
                restance = Boolean.parseBoolean(insertTo[3].toString());

                // En ny liste der bruges til at skrive ind i vores Motionist-liste
                Motionist motionistListe = new Motionist(age, navn, aktiv, restance);
                motionister.add(motionistListe);
            }

            while (scanner2.hasNextLine()){
                // Skaber et midlertidigt objekt, som vi splitter på tab, så vi kan fordele vores data i listen
                Object[] insertTo = scanner2.nextLine().split("\t");

                // Bruger vores midlertidige objekt til at positionere vores data samt type
                age = Integer.parseInt(insertTo[0].toString());
                navn = insertTo[1].toString();
                aktiv = Boolean.parseBoolean(insertTo[2].toString());
                restance = Boolean.parseBoolean(insertTo[3].toString());
                swimType = insertTo[4].toString();
                swimTid = Integer.parseInt(insertTo[5].toString());
                træner = insertTo[6].toString();

                KonkurrenceMedlem konkurrenceListe = new KonkurrenceMedlem(age, navn, aktiv, restance, swimType, swimTid, træner);
                konkurrencemedlemmer.add(konkurrenceListe);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }


}

// To-do:
// Find ud af hvordan man splitter på ###