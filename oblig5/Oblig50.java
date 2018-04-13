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

        //Sjekker at aapning fungerer:
        if (l.getLab().get(0).get(5) instanceof Aapning){
          System.out.println("lab[0][5] er en aapning.");
        }

        //Sjekker at det blir satt inn naboer:
        System.out.println(l.getLab().get(0).get(5).hentNabo('s').tilTegn());
    }
}
