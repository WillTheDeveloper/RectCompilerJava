public class Token {
    String name;
    String value;

    public Token(String _name, String _value) {
        name = _name;
        value = _value;
    }

    public String string() {
        return String.format("{ name: '%s', value: '%s' }", name, value);
    }
}