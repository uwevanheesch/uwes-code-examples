package nl.han.dea;


public class RandomGeneratorFactory {

    private RandomGeneratorFactory(){
    }

    public static IRandomGenerator getGenerator(GeneratorType type){
        switch (type){
            case CRYPTIC_TYPE: return new RandomUUIDGeneratorAdapter();
            case READABLE_TYPE: return new RandomNameGeneratorAdapter();
            default: return new RandomUUIDGeneratorAdapter();
        }
    }


}
