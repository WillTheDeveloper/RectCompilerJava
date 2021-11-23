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
}
