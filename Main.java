public class Main {
    public static void main(String[] args) {
        String name = "Will";
        System.out.println("Hello " + name);
        System.out.println("Length of " + name + " is " + name.length() + " characters.");
        if (name.length() > 5) {
            System.out.println("You have a pretty long name.");
        } else {
            System.out.println("Your name is quite short.");
        }
    }
}