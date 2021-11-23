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

            else if(Character.isAlphabetic(code[index])) {
                String buffer = Character.toString(code[index]);
                index++;
                while(index < code.length && Character.isLetterOrDigit(code[index])) {
                    buffer += code[index];
                    index++;
                }
                token.add(new Token("Identifier", buffer));
            }

            else if(code[index] == '"') {
                String buffer = Character.toString(code[index]);
                index++;
                while(index < code.length && code[index] != '"') {
                    buffer += code[index];
                    index++;
                }
                token.add(new Token("String", buffer));
            }

            else if(Character.isWhitespace(code[index])) {
                index++;
            }

            else {
                System.out.println("ERROR: Unknown token");
                return new ArrayList<Token>();
            }
        }
        return token;
    }
}