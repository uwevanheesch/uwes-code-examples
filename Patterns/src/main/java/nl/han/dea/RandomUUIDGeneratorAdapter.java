package nl.han.dea;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.RandomBasedGenerator;

/**
 * Created by uwe on 07/03/17.
 */
public class RandomUUIDGeneratorAdapter implements IRandomGenerator {

    private RandomBasedGenerator randomBasedGenerator = Generators.randomBasedGenerator();

    public String generateRandomString() {
        return randomBasedGenerator.generate().toString();
    }
}
