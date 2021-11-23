import java.util.ArrayList;
import java.lang.*;

public class Lexer {
    char[] code;
    int index;

    public Lexer(char[] text) {
        code = text;
        index = 0;
    }

    public ArrayList<Token> Analyse() {
        ArrayList<Token> token = new ArrayList<Token>();

        while (index < code.length) {

            if(Character.isDigit(code[index])) {
                String buffer = Character.toString(code[index]);
                index++;
                while(index < code.length && Character.isDigit(code[index])) {
                    buffer += code[index];
                    index++;
                }
                token.add(new Token("Integer", buffer));
            }
        }
        return token;
    }

    public char Peek() {
        if (index+1 >= code.length) {
            return '\0';
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
        if (index >= code.length) {
            return false;
        }
        return true;
    }
}