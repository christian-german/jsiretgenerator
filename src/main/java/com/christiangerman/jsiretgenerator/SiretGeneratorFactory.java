package com.christiangerman.jsiretgenerator;

/**
 * Factory to create implementations of {@link SiretGenerator}.
 */
public final class SiretGeneratorFactory {

    /**
     * Creates a SiretGenerator implementation.
     *
     * @return A {@link SiretGenerator}.
     */
    public static SiretGenerator createSiretGenerator() {
        return new SiretGeneratorImpl();
    }
}
