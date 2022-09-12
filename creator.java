import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;

public class creator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What would you call the file? ");
        String nome = input.nextLine() + ".txt";

        try {
            File myObj = new File(nome);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + nome);
            } else {
                System.out.println("A file with this name already exist.");
                System.out.println("Delete the previous file, then create a new one.");
                input.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("An error has occured during the execution.");
            e.printStackTrace();
        }

        try {
            String username = "cristiangrossano";
            FileWriter myWriter = new FileWriter(nome);
            myWriter.write("message {message} Custom Command by " + username + "\n");
            myWriter.write(
                    "message {message} Danger!\nmessage {message} The creator of the program assumes no responsibility for user errors\n");

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
                    System.out.println("Added " + cont + "lines.");
                }
                System.out.println(
                        "Select a mode:\n- 1 > farm of an event;\n- 2 > farm dupe of a character;\n- 3 > farm medals;\n- 4 > farm medals from an EZA;\n- 0 > to create the file and close the program.");
                mode = input.nextInt();

                switch (mode) {
                    case 1: {
                        // ? Stage selection
                        System.out.print("Insert the id of the stage: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 7) {
                            System.out
                                    .println(
                                            "The length is wrong!\nAll the stages in this mode have 6 numbers in the ID.");
                            continue;
                        }
                        System.out.println("Stage selected: " + stageID);

                        // ? Difficulty
                        System.out.print("Select the difficulty: ");
                        difficulty = input.nextInt();
                        if (difficulty < 0 && difficulty > 5) {
                            System.out.println("Invalid difficulty.");
                            continue;
                        }
                        System.out.println("Selected difficulty: " + difficulty);

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
                        System.out.print("Insert the id of the stage: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 7) {
                            System.out
                                    .println(
                                            "The length is wrong!\nAll the stages in this mode have 6 numbers in the ID.");
                            continue;
                        }
                        System.out.println("Stage selected: " + stageID);

                        // ? Difficulty
                        System.out.println("Select the difficulty.");
                        difficulty = input.nextInt();
                        if (difficulty < 0 && difficulty > 5) {
                            System.out.println("Invalid difficulty.");
                            continue;
                        }
                        System.out.println("Selected difficulty: " + difficulty);

                        // ? Number of copies
                        System.out.print("How many copies should be farmed: ");
                        index = input.nextInt();
                        System.out.println("The bot will work for " + index + " copies.");

                        // ? Character ID
                        System.out.print("Character ID: ");
                        input.nextLine();
                        itemID = input.nextLine() + " ";
                        System.out.println("The character ID is: " + itemID);

                        // ? Write file
                        myWriter.write("message {message} Farming of " + index + " copies of " + itemID + "\n");
                        myWriter.write(character + stageID + difficulty + " " + index + " " + itemID + "\n");
                    }
                        break;
                    case 3: {
                        // ? Stage selection
                        System.out.print("Insert the id of the stage: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 7) {
                            System.out
                                    .println(
                                            "The length is wrong!\nAll the stages in this mode have 6 numbers in the ID.");
                            continue;
                        }
                        System.out.println("Stage selected: " + stageID);

                        // ? Difficulty
                        System.out.print("Select the difficulty.");
                        difficulty = input.nextInt();
                        if (difficulty < 0 && difficulty > 5) {
                            System.out.println("Invalid difficulty.");
                            continue;
                        }
                        System.out.println("Selected difficulty: " + difficulty);

                        // ? Number of medals
                        System.out.print("How many medals should be farmed: ");
                        index = input.nextInt();
                        System.out.println("The bot will work for " + index + "medals.");

                        // ? Character ID
                        System.out.print("Medals ID: ");
                        input.nextLine();
                        itemID = input.nextLine() + " ";
                        System.out.println("The medal ID is: " + itemID);

                        // ? Write file
                        myWriter.write("message {message} Farming of " + index + "medals of " + itemID + "\n");
                        myWriter.write(medals + stageID + difficulty + " " + index + " " + itemID + "\n");
                    }
                        break;
                    case 4: {
                        // ? Stage selection
                        System.out.print("Insert the id of the EZA: ");
                        input.nextLine();
                        stageID = input.nextLine() + " ";
                        if (stageID.length() != 3) {
                            System.out
                                    .println(
                                            "The length is wrong!\nAll the stages in this mode have 2 numbers in the ID.");
                            continue;
                        }
                        System.out.println("Selected EZA: " + stageID);

                        // ? Level
                        System.out.print("Wich level should be done: ");
                        index = input.nextInt();
                        System.out.println("The bot will farm the level " + index);

                        // ? Write file
                        myWriter.write("message {message} Farming EZA\n");
                        myWriter.write(eza + stageID + index + " " + index + "\n");
                    }
                        break;
                }
            } while (mode != 0);
            System.out.println("Done!");
            myWriter.write("message {message} Custom Command ended.");

            myWriter.close();
        } catch (Exception e) {
            System.out.println("An error has occured.");
            System.out.println(e);
        }

        input.close();
        return;
    }
}