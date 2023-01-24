package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.platform.LoyaltyPlatform;

public class LevelDigitalCard extends DigitalCard {

    private int level = 0;

    private int experience;

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public void levelUp() {
        this.level++;
    }

    @Override
    public void updateStatus(LoyaltyPlatform platform, Integer value) {

    }

}
