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
                token.add(new Token("INTEGER", buffer));
            }

            else if(Character.isAlphabetic(code[index])) {
                String buffer = Character.toString(code[index]);
                index++;
                while(index < code.length && Character.isLetterOrDigit(code[index])) {
                    buffer += code[index];
                    index++;
                }
                boolean x = false;
                STRING keywords = ['DIE', 'PRINT'];
                for(int i = 0; i < keywords.length; i++) {
                    if(buffer == keywords[i]){
                        token.add(new Token(keywords[i], buffer));
                        x = true;
                        break;
                    }
                }
                if (! x) {
                    token.add(new Token("IDENTIFIER", buffer));
                }
            }

            else if(code[index] == '"') {
                String buffer = Character.toString(code[index]);
                index++;
                while(index < code.length && code[index] != '"') {
                    buffer += code[index];
                    index++;
                }
                token.add(new Token("STRING", buffer));
            }

            else if(Character.isWhitespace(code[index])) {
                index++;
            }

            else if (code[index] == '+') {
                token.add(new Token("PLUS", ""));
                index++;
            }

            else if (code[index] == '-') {
                token.add(new Token("MINUS", ""));
                index++;
            }

            else if (code[index] == '*') {
                token.add(new Token("MULTIPLY", ""));
                index++;
            }

            else if (code[index] == '/') {
                token.add(new Token("DIVIDE", ""));
                index++;
            }

            else if (code[index] == '=') {
                token.add(new Token("COMPARE", ""));
                index++;
            }

            else if (code[index] == '<') {
                if (code[index+1] == '-') {
                    index++;
                    token.add(new Token("ASSIGN", ""));
                } else {
                    token.add(new Token("SMALL THAN", ""));
                }
                index++;
            }

            else if (code[index] == '>') {
                token.add(new Token("GREATER THAN", ""));
                index++;
            }

            else if (code[index] == ';') {
                token.add(new Token("SEMICOLON", ""));
                index++;
            }

            else if (code[index] == '(') {
                token.add(new Token("LEFT BRACKET", ""));
                index++;
            }

            else if (code[index] == ')') {
                token.add(new Token("RIGHT BRACKET", ""));
                index++;
            }

            else if (code[index] == '{') {
                token.add(new Token("LEFT BRACE", ""));
                index++;
            }

            else if (code[index] == '}') {
                token.add(new Token("RIGHT BRACE", ""));
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