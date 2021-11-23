import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: rcj <file> [flags]");
            return;
        }

        if (args.length == 2) {
            if (args[1] == "--help" || args[1] == "-h") {
                help();
                return;
            }

            openAndRun(args[1]);
        }
    }

    public static void openAndRun(String filename) {
        File obj = new File(filename);
        String contents = new String();
        if (obj.exists()) {
            try {
                Scanner reader = new Scanner(obj);
                while(reader.hasNextLine()) {
                    contents += reader.nextLine();
                }
            } catch(Exception e) {
                System.out.println("An error occurerd trying to open '"+filename+"'");
                return;
            }
        } else {
            System.out.println("'" + filename + "' does not exit!");
            return;
        }
        Lexer lexer = new Lexer(contents.toCharArray());
        ArrayList<Token> tokens = lexer.Analyse();
    }

    public static void help() {
        String s = "=+= Rect Compiler Java =+=\n"
                + "Usage: rcj <file> [flag]\n"
                + "\n"
                + "<file> can be any ReCT file\n";
        System.out.println(s);
    }

    public static void flagParse(String[] args) {
        // rcj <file> [options]
        // We need to detect the file then scan for the options

        // First we check a file or options has been entered and not just "rcj"
        if (args.length <= 1) {
            help();
            return;
        }

        // Checking if file exists
        if (!(new File(args[1])).exists()) {
            System.out.println("File '"+args[1]+"' does not exist!");
            return;
        }

        // Parse flags and run code

    }
}
