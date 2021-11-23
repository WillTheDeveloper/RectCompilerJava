public class Token {
    String type;
    String value;

    public Token(String _type, String _value) {
        type = _type;
        value = _value;
    }

    public String string() {
        return String.format("{ name: '%s', value: '%s' }", type, value);
    }
}