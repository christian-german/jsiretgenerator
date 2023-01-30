package com.christiangerman.jsiretgenerator;

import lombok.Getter;
import lombok.Setter;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@Setter
public class Siret {
    private String siren;
    private String nic;

    public String getSiret() {
        assertThat(siren).isNotBlank();
        return siren.concat(nic);
    }

    public void setSiret(String siret) {
        assertThat(siret)
                .hasSize(14)
                .containsOnlyDigits();

        siren = siret.substring(0, 9);
        nic = siret.substring(9, 14);
    }

    @Override
    public String toString() {
        return "%s-%s".formatted(siren, nic);
    }
}
