package nl.han.oose.dea;

/**
 * Created by uwe on 28/03/17.
 */
public class RestClient {

    public static void main(String[] args) {

        Item berliner = new RestServiceDelegate().getItem("Berliner");
        System.out.println(berliner);

    }

}
