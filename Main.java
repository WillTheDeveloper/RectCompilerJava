import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: rcj <file> [flags]");
            return;
        }

        if (args.length == 2) {
            if (args[1] == "--help" || args[1] == "-h") {
                elp();
                return;
            }

            openAndRun(args[1]);
        }
    }

    public void openAndRun(String filename) {
        File obj = new File(filename);
        if (obj.exists()) {
            // Read code and Analyse()
        }
    }

    public void help() {
        String s = "=+= Rect Compiler Java =+=\n"
                + "Usage: rcj <file> [flag]\n"
                + "\n"
                + "<file> can be any ReCT file\n";
        System.out.println(s);
    }
}