import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Oblig50 {
    public static void main(String[] args) {
        String filnavn = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk av programmet: "
                               +"java Oblig5 <labyrintfil>");
            return;
        }
        File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }
        //Printer ut labyrint:
        System.out.printf(l.toString());

        //Rute ny = l.getLab().get(0).get(5);

        //l.getLab().get(2).get(1).gaa(l.getLab().get(3).get(1));
        //System.out.println(l.getLab().get(5).get(0).ref_labyrint);
        l.finnUtveiFra(1,2);
        System.out.println(l.utveier);

        //Sjekker at det blir satt inn naboer:
        //System.out.println(l.getLab().get(0).get(5).hentNabo('s').tilTegn());

    }
}
