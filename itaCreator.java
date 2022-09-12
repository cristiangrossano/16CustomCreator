import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

public class itaCreator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Come vorresti chiamare il file ");
        String nome = input.nextLine() + ".txt";

        try {
            File myObj = new File(nome);
            if (myObj.createNewFile()) {
                System.out.println("File creato: " + nome);
            } else {
                System.out.println("Un file con questo nome esiste già.");
                System.out.println("Cancella il file e creano uno nuovo.");
                input.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Riscontrato un errore.");
            e.printStackTrace();
        }

        try {
            String username = "cristiangrossano";
            FileWriter myWriter = new FileWriter(nome);
            myWriter.write("message {message} Custom Command fatto da " + username + "\n");
            myWriter.write(
                    "message {message} Pericolo!\nmessage {message} Il creatore del bot non si assume responsabilità negli errori degli utenti\n");

            int mode = 0;
            int cont = 0;
            int difficulty = 0;
            int index = 0;
            String stageID = " ";
            String itemID = " ";
            String event = "event stage ";
            String medals = "farm medals ";
            String character = "farm dupe ";
            String eza = "eza exact ";
            do {
                if (cont > 0) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Aggiunte " + cont + "linee.");
                }
                System.out.println(
                        "Seleziona una modalità:\n- 1 > farm di un evento;\n- 2 > farm copie di un personaggio;\n- 3 > farm medaglie;\n- 4 > farm medaglie da un eza\n- 0 > per creare il file e chiudere il programma.");
                mode = input.nextInt();

                switch (mode) {
                    case 1: {
                        // ? Stage selection
                        System.out.print("Inserisci l'id dello stage: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 7) {
                            System.out
                                    .println(
                                            "Lunghezza sbagliata!\nTutti gli stage in questa categoria sono fatti da 6 cifre");
                            continue;
                        }
                        System.out.println("Stage selezionato: " + stageID);

                        // ? Difficulty
                        System.out.print("Seleziona la difficoltà: ");
                        difficulty = input.nextInt();
                        if (difficulty < 0 && difficulty > 5) {
                            System.out.println("Difficoltà non valida.");
                            continue;
                        }
                        System.out.println("Difficoltà selezionata: " + difficulty);

                        // ? Number of times
                        System.out.print("How many times should the stage be done: ");
                        index = input.nextInt();
                        System.out.println("The stage will be done " + index + " times.");

                        // ? Write file
                        myWriter.write("message {message} farming" + stageID + "for " + index + " times.\n");
                        myWriter.write(event + stageID + difficulty + " " + index + "\n");

                    }

                        break;
                    case 2: {
                        // ? Stage selection
                        System.out.print("Inserisci l'id dello stage: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 7) {
                            System.out
                                    .println(
                                            "Lunghezza sbagliata!\nTutti gli stage in questa categoria sono fatti da 6 cifre");
                            continue;
                        }
                        System.out.println("Stage selezionato: " + stageID);

                        // ? Difficulty
                        System.out.println("Seleziona la difficoltà.");
                        difficulty = input.nextInt();
                        if (difficulty < 0 && difficulty > 5) {
                            System.out.println("Difficoltà non valida.");
                            continue;
                        }
                        System.out.println("Difficoltà selezionata: " + difficulty);

                        // ? Number of copies
                        System.out.print("Quante copie dovrebbero essere farmate: ");
                        index = input.nextInt();
                        System.out.println("Il bot lavorerà per " + index + " copie.");

                        // ? Character ID
                        System.out.print("ID Personaggio: ");
                        input.nextLine();
                        itemID = input.nextLine() + " ";
                        System.out.println("L'id del personaggio è : " + itemID);

                        // ? Write file
                        myWriter.write("message {message} Farming di " + index + " copie di " + itemID + "\n");
                        myWriter.write(character + stageID + difficulty + " " + index + " " + itemID + "\n");
                    }
                        break;
                    case 3: {
                        // ? Stage selection
                        System.out.print("Inserisci l'id dello stage: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 7) {
                            System.out
                                    .println(
                                            "Lunghezza sbagliata!\nTutti gli stage in questa categoria sono fatti da 6 cifre");
                            continue;
                        }
                        System.out.println("Stage selezionato: " + stageID);

                        // ? Difficulty
                        System.out.print("Seleziona la difficoltà.");
                        difficulty = input.nextInt();
                        if (difficulty < 0 && difficulty > 5) {
                            System.out.println("Difficoltà non valida.");
                            continue;
                        }
                        System.out.println("Difficoltà selezionata: " + difficulty);

                        // ? Number of medals
                        System.out.print("How many medals should be farmed: ");
                        index = input.nextInt();
                        System.out.println("Il bot farmerà per " + index + "medaglie.");

                        // ? Character ID
                        System.out.print("ID Medaglie: ");
                        input.nextLine();
                        itemID = input.nextLine() + " ";
                        System.out.println("L'ID della medaglia: " + itemID);

                        // ? Write file
                        myWriter.write("message {message} farm di " + index + "medaglie di " + itemID + "\n");
                        myWriter.write(medals + stageID + difficulty + " " + index + " " + itemID + "\n");
                    }
                        break;
                    case 4: {
                        // ? Stage selection
                        System.out.print("Inserisci l'ID dell'EZA: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 3) {
                            System.out
                                    .println(
                                            "Lunghezza sbagliata!\nTutti gli stage in questa categoria dovrebbero avere 2 cifre nell'ID.");
                            continue;
                        }
                        System.out.println("EZA Selezionato: " + stageID);

                        // ? Level
                        System.out.print("Quale livello dovrebbe essere fatto: ");
                        index = input.nextInt();
                        System.out.println("Il bot farmerà il livello " + index);

                        // ? Write file
                        myWriter.write("message {message} Farm EZA\n");
                        myWriter.write(eza + stageID + index + " " + index + "\n");
                    }
                        break;
                }
            } while (mode != 0);
            System.out.println("Done!");
            myWriter.write("message {message} Custom Command finito.");

            myWriter.close();
        } catch (Exception e) {
            System.out.println("Riscontrato un errore.");
            System.out.println(e);
        }

        input.close();
        return;
    }
}