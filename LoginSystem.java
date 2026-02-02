import java.io.Console;

public class LoginSystem {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.out.println("Console not available. Run from command prompt.");
            return;
        }

        String correctUsername = "admin";
        String correctPassword = "1234";

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter Username: ");
            String username = console.readLine();

            System.out.print("Enter Password: ");
            char[] passwordArray = console.readPassword(); // masks input
            String password = String.valueOf(passwordArray);

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful ✅ Welcome " + username);
                return;
            } else {
                attempts--;
                System.out.println("Invalid username or password ❌");
                System.out.println("Attempts remaining: " + attempts);
            }
        }

        System.out.println("Account locked 🚫 Too many failed attempts.");
    }
}