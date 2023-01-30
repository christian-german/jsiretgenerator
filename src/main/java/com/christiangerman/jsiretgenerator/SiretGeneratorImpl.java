package com.christiangerman.jsiretgenerator;

import static com.christiangerman.jsiretgenerator.LuhnGenerator.generateLuhnNumber;
import static com.christiangerman.jsiretgenerator.LuhnGenerator.pad;

class SiretGeneratorImpl implements SiretGenerator {
    @Override
    public Siret generateSiret() {
        Siret siret = new Siret();

        String generatedSiren = generateLuhnNumber(9);
        String generatedSiret = pad(generatedSiren, 14);

        siret.setSiret(generatedSiret);
        return siret;
    }
}
