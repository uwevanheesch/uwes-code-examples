package nl.han.dea;


public class App {

    public static void main(String[] args) {

        UserAccount userAccount = new RegistrationService().generateUserAccount("Uwe");
        System.out.println(userAccount);


    }

}
