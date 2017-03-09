package nl.han.dea;


public class RegistrationService {

    private IRandomGenerator randomGenerator = RandomGeneratorFactory.getGenerator(GeneratorType
            .CRYPTIC_TYPE);

    public UserAccount generateUserAccount(String name){
        UserAccount newAccount = new UserAccount(name);
        String password = randomGenerator.generateRandomString();
        newAccount.setPassword(password);
        return newAccount;
    }

}
