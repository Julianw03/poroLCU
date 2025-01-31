package com.julianw03.poroLCU.model.shared;

import lombok.Getter;

@Getter
public class Ownership {
    @Getter
    public static class Rental {
        private Boolean rented;

        private Rental() {
        }
    }

    private Boolean loyaltyReward;
    private Boolean owned;
    private Boolean xboxGPReward;

    private Ownership() {
    }
}
