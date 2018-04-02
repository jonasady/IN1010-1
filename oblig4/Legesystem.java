import java.util.Scanner;

public class Legesystem{
  static Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
  static Liste<Fastlege> legeListe = new Lenkeliste<Fastlege>();//SortertLenkeliste<Fastlege>();
  static Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
  static Liste<Resept> reseptListe = new Lenkeliste<Resept>();

  public static void leggTilLege(String navn, int avtalenummer){
    Fastlege x = new Fastlege(navn,avtalenummer); /*0 hvis det ikke er en fastlege.*/
    for (Fastlege p : legeListe){
      if (p.compareTo(x)==0){
        System.out.println("Det finnes allerede en lege med dette navnet.");
        return;
      }
    }
    legeListe.leggTil(x);
  }

  public static void leggTilPasient(String navn, String fodselsnr){
    Pasient x = new Pasient(navn,fodselsnr);
    for (Pasient p : pasientListe){
      if (p.hentNavn()==x.hentNavn()){
        System.out.println("Det finnes allerede en pasient med dette navnet.");
        return;
      }
    }
    pasientListe.leggTil(x);
  }

  public static void leggTilResept(int type,int legemiddelnr,int legenr,int pasientID,int reit){
    Resept x;
    Fastlege lege = legeListe.hent(legenr);
    Legemiddel lm = legemiddelListe.hent(legemiddelnr);

    if (lege.hentAvtalenummer()==0){
      System.out.println("Dette er en lege uten gyldig avtalenummer.");
      return;
    }

    if (type == 1){
      x = new BlaaResept(lm,lege,pasientID,reit);
    } else if (type == 2){
      x = new PResept(lm,lege,pasientID);
    } else if (type == 3){
      x = new MilitaerResept(lm,lege,pasientID,reit);
    } else {
      x = null;
    }

    for (Resept r : reseptListe){
      if ((r.hentLegemiddel()==x.hentLegemiddel()) && (r.hentPasientId()==x.hentPasientId())){
        System.out.println("Det finnes allerede en resept for denne pasienten for dette legemiddelet.");
        return;
      }
    }
    reseptListe.leggTil(x);
    lege.skrivResept(x);
    pasientListe.hent(pasientID).leggPaa(x);
  }

  public static void leggTilLegemiddel(String navn, double startpris, double virkestoff, int type, int styrke){
    Legemiddel x;

    if (type == 1){
      x = new LegemiddelA(navn,startpris,virkestoff,styrke);
    } else if (type == 2){
      x = new LegemiddelB(navn,startpris,virkestoff,styrke);
    } else if (type == 3){
      x = new LegemiddelC(navn,startpris,virkestoff);
    } else {
      x = null;
    }

    for (Legemiddel lm : legemiddelListe){
      if (lm.hentNavn()==x.hentNavn()){
        System.out.println("Det finnes allerede et legemiddel med dette navnet.");
        return;
      }
    }
    legemiddelListe.leggTil(x);
  }

  static void valg1(){
    /*Skriver ut pasientenes navn:*/
    for (Pasient p : pasientListe){
      System.out.println(p.hentNavn());
    }
    for (Fastlege p : legeListe){
      System.out.println(p.hentNavn());
    }
    for (Legemiddel p : legemiddelListe){
      System.out.println(p.hentNavn());
    }
    for (Resept p : reseptListe){
      System.out.println("Pasient-ID: " + p.hentPasientId() + "\nUtskrivende lege: " + p.hentLege() + "\nLegemiddel: " + p.hentLegemiddel());
    }
  }

  static void valg2(){
    char avslutt = 'n';
    String input;
    String navn;
    int nummer;
    int type;
    int pasientnr;
    int legenr;
    String fodselsnr;
    int legemiddelnr;
    int reit;
    int valg = 0;
    Scanner scan = new Scanner(System.in);

    while (avslutt !='j'){
      System.out.println("Vennligst velg en av disse valgmulighetene:"
        + "\n1. Legg til en lege."
        + "\n2. Legg til en pasient."
        + "\n3. Legg til et legemiddel."
        + "\n4. Legg til en resept.");
      valg = scan.nextInt();

      switch (valg){
        case 1:
          System.out.println("Skriv inn legens navn: ");
          navn = scan.next();
          System.out.println("Skriv inn legens avtalenummer (0 hvis legen ikke har kommuneavtale): ");
          nummer = scan.nextInt();
          leggTilLege(navn,nummer);
          break;
        case 2:
          System.out.println("Skriv inn pasientens navn: ");
          navn = scan.next();
          System.out.println("Skriv inn pasientens fodselsnr: ");
          fodselsnr = scan.next();
          leggTilPasient(navn,fodselsnr);
          break;
        case 3:
          double startpris;
          double virkestoff;
          int styrke = 0;
          System.out.println("Skriv inn legemiddelets navn: ");
          navn = scan.next();

          System.out.println("Hva er startpris? ");
          startpris = scan.nextDouble();

          System.out.println("Hva er mengden virkestoff? ");
          virkestoff = scan.nextDouble();

          System.out.println("Hva slags type legemiddel er det? "
            + "\n1. Narkotisk"
            + "\n2. Vanedannende"
            + "\n3. Annet");
          type = scan.nextInt();

          if (type ==1 || type ==2){
            System.out.println("Hva er styrken? ");
            styrke = scan.nextInt();
          }

          leggTilLegemiddel(navn, startpris, virkestoff, type, styrke);
          break;

        case 4:
          System.out.println("Hva slags type resept er det? "
            + "\n1. Blaa resept"
            + "\n2. Prevensjon"
            + "\n3. Militaer");
          type = scan.nextInt();

          System.out.println("Hvilket nummer i denne listen av leger skal skrive ut resept?  Begynn paa 0. ");
          for (Fastlege p : legeListe){
            System.out.println(p.hentNavn());
          }
          legenr = scan.nextInt();

          System.out.println("Hva er pasientID-en? ");
          pasientnr = scan.nextInt();

          System.out.println("Hvor mange ganger skal resepten kunne brukes? ");
          reit = scan.nextInt();

          System.out.println("Hvilket nummer i listen av legemidler skal det skrives resept paa? Begynn paa 0. ");
          for (Legemiddel lm : legemiddelListe){
            System.out.println(lm.hentNavn());
          }
          legemiddelnr = scan.nextInt();

          leggTilResept(type,legemiddelnr,legenr,pasientnr,reit);
          break;
        default:
          System.out.println("Det er ikke et gyldig valg.");
      }
      System.out.println("Vil du ut av 'Opprett og legg til'-menyen? j for ja og n for nei. ");
      input = scan.next().toLowerCase();
      avslutt = input.charAt(0);
    }
  }

  static void valg3(){
    char avslutt = 'n';
    String input;
    int valg = 0;
    Scanner scan = new Scanner(System.in);

    while (avslutt !='j'){
      System.out.println("Hvilken pasient vil du se resepter for?");
      for (Pasient p : pasientListe){
        System.out.println(p.hentID()+":"+p.hentNavn()+"(fnr"+p.hentFodselsnr()+")");
      }
      valg = scan.nextInt();
      System.out.println("Valgt pasient: "+pasientListe.hent(valg).hentNavn()+" (fnr "+pasientListe.hent(valg).hentFodselsnr()+")");

      System.out.println("Hvilken resept vil du bruke?");
      for (Resept r : reseptListe){
        System.out.println(r.hentId()+":"+r.hentLegemiddel()+" ("+r.hentReit()+" reit)");
      }
      valg = scan.nextInt();
      reseptListe.hent(valg).bruk();
      System.out.println("Brukte resept paa "+reseptListe.hent(valg).hentLegemiddel()+". Antall gjenvaerende reit: "+reseptListe.hent(valg).hentReit());

      System.out.println("Vil du ut av menyen for bruk av resepter? j for ja og n for nei. ");
      input = scan.next().toLowerCase();
      avslutt = input.charAt(0);
    }
  }

  static void valg4(){
    char avslutt = 'n';
    String input;
    int valg = 0;
    Scanner scan = new Scanner(System.in);

    while (avslutt !='j'){
      System.out.println("Vennligst velg en av disse valgmulighetene:"
        + "\n1. Totalt antall utskrevne resepter paa vanedannende legemidler."
        + "\n2. Antall vanedannende resepter utskrevne til militaere."
        + "\n3. Liste over leger som har skrevet ut resept paa narkotiske legemidler og antall slike resepter per lege."
        + "\n4. Liste over pasienter med minst en gyldig resept paa narkotiske legemidler, og antall slike resepter per pasient.");
      valg = scan.nextInt();

      switch (valg){
        case 1:
          int vResept = 0;
          for (Resept r : reseptListe){
            if (r.hentHeleLegemiddel() instanceof LegemiddelB){
              vResept++;
            }
          }
          System.out.println("Totalt antall utskrevne resepter av vanedannende legemidler: "+vResept);
          break;
        case 2:
          int mResept = 0;
          for (Resept r : reseptListe){
            if ((r instanceof MilitaerResept) && (r.hentHeleLegemiddel() instanceof LegemiddelB)){
              mResept++;
            }
          }
          System.out.println("Antall vanedannende resepter skrevet ut til militaere: "+mResept);
          break;
        case 3:
          Lenkeliste<Lege> ll = new Lenkeliste<Lege>();
          for (Lege lege : legeListe){
            for (Resept resept : lege.hentUtskrevneResepter()){
              if (resept.hentHeleLegemiddel() instanceof LegemiddelA){
                ll.leggTil(lege);
              }
            }
          }
          System.out.println("Her er en liste over leger som har skrevet ut resept med narkotisk stoff og hvor mange slike resepter per lege:");
          for (Lege lege : ll){
            System.out.println(lege.hentNavn()+" har skrevet ut "+lege.hentAntNarkResepter()+" antall narkotiske resepter.");
          }
          break;
        case 4:
          Lenkeliste<Pasient> pp = new Lenkeliste<Pasient>();
          for (Pasient pasient : pasientListe){
            for (Resept resept : pasient.hentUt()){
              if (resept.hentHeleLegemiddel() instanceof LegemiddelB){
                pp.leggTil(pasient);
              }
            }
          }
          System.out.println("Her er en liste over pasienter som har faatt resept med narkotisk stoff og hvor mange slike resepter per pasient:");
          for (Pasient pasient : pp){
            System.out.println(pasient.hentNavn()+" har faatt "+pasient.hentAntNarkResepter()+" antall narkotiske resepter.");
          }
          break;
        default:
          System.out.println("Det er ikke et gyldig valg.");
      }

      System.out.println("Vil du ut av statistikk-menyen? j for ja og n for nei. ");
      input = scan.next().toLowerCase();
      avslutt = input.charAt(0);
    }
  }

  static void valg5(){
    System.out.println("Denne funksjonen er ikke fullfoert.");
  }

  public static void testLegesystem(){
    Pasient p = new Pasient("Hei Pasient","010101");
    pasientListe.leggTil(p);
    Fastlege q = new Fastlege("Hei Lege",0);
    Fastlege house = new Fastlege("House MD",12345);
    legeListe.leggTil(q);
    legeListe.leggTil(house);
    LegemiddelC lm = new LegemiddelC("Ibux",240.00,200.00);
    legemiddelListe.leggTil(lm);
    BlaaResept rs = new BlaaResept(lm,q,p.hentID(),10);
    reseptListe.leggTil(rs);
  }

  public static void main(String[] args){
    char avslutt = 'n';
    String input;
    int valg = 0;
    Scanner scan = new Scanner(System.in);
    testLegesystem();

    while (avslutt !='j'){
      System.out.println("Vennligst velg en av disse valgmulighetene:"
        + "\n1. Skriv ut fullstendig oversikt over personer, leger, legemidler og resepter."
        + "\n2. Opprett og legg til nye elementer i systemet."
        + "\n3. Bruk en gitt resept fra listen til en pasient."
        + "\n4. Skriv ut forskjellige former for statistikk."
        + "\n5. Skriv all data til fil.");
      valg = scan.nextInt();

      switch (valg){
        case 1:
          valg1();
          break;
        case 2:
          valg2();
          break;
        case 3:
          valg3();
          break;
        case 4:
          valg4();
          break;
        case 5:
          valg5();
          break;
        default:
          System.out.println("Det er ikke et gyldig valg.");
      }
      System.out.println("Vil du ut av hovedmenyen? j for ja og n for nei. ");
      input = scan.next().toLowerCase();
      avslutt = input.charAt(0);
    }
  }
}
