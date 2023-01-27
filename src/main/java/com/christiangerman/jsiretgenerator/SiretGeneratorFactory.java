package com.christiangerman.jsiretgenerator;

public final class SiretGeneratorFactory {

    public SiretGeneratorFactory() {
    }

    public static SiretGenerator createSiretGenerator() {
        return new SiretGeneratorImpl();
    }
}
