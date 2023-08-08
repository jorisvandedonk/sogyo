import java.util.Scanner;

public class ExceptionalUsers {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a username\n");
        String userName = userInput.nextLine();

        System.out.print("Enter a password\n");
        String passWord = userInput.nextLine();

        while (!User.validPassword(passWord)) {
            System.out.print("This is not a valid password. Please enter a stronger password.\n");
            passWord = userInput.nextLine();
        }
        User user = new User(userName, passWord);
        user.userRegistered();
    }
}

final class User {
    public final String userName;
    public final String passWord; 

    public User(String u, String p) {
        userName = u;
        passWord = p;
    }

    public static boolean validPassword(String passWord) {
        boolean hasNumber = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;

        for (int i = 0; i < passWord.length(); i++) {
            char character = passWord.charAt(i);
            if (Character.isDigit(character)) {
                hasNumber = true;
            } else if (Character.isLowerCase(character)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(character)) {
                hasUpperCase = true;
            }
        }

        return hasNumber && hasLowerCase && hasUpperCase;
    }
    
    public void userRegistered() {
        System.out.println("Registered user " + userName);
    }
}
