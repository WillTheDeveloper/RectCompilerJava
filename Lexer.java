import java.util.ArrayList;

public class Lexer {
    String code;
    int index;

    public Lexer(String text) {
        code = text;
        index = 0;
    }

    public ArrayList<Token> Analyse() {
        ArrayList<Token> token = new ArrayList<Token>();

    }

    public String Peek() {
        if (index+1 >= code.length()) {
            return "";
        }
        return code[index+1];
    }

    public boolean Backtrack() {
        index--;
        if (index < 0) {
            return false;
        }
        return true;
    }

    public boolean Advance() {
        index++;
        if (index >= code.length()) {
            return false;
        }
        return true;
    }
}