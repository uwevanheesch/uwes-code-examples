package nl.han.dea;


import org.kohsuke.randname.RandomNameGenerator;

public class RandomNameGeneratorAdapter implements IRandomGenerator{

    private RandomNameGenerator generator = new RandomNameGenerator();

    public String generateRandomString() {
        return generator.next();
    }

}
