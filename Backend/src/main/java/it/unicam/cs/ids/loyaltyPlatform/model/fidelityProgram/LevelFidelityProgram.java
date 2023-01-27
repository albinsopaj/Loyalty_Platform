package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.LevelDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

/**
 * Fidelity program based on levels
 */
@AllArgsConstructor
@Getter
@Setter
public class LevelFidelityProgram extends FidelityProgram {
    private @NonNull Integer conversionRate;

    private @NonNull List<FidelityLevel> levels;

    /**
     * Method to add a client to the fidelity program, the method also creates a digital card and adds it to the client
     * @param client the client to add
     */
    @Override
    public void addClient(Client client) {
        if (!this.getClients().contains(client)) {
            this.getClients().add(client);
        }
        //LevelDigitalCard levelDigitalCard = new LevelDigitalCard()
        //client.getDigitalWallet().addDigitalCard(levelDigitalCard);
    }

    @Override
    public void changeStatus(Integer value, DigitalCard digitalCard) {
        if(digitalCard instanceof LevelDigitalCard levelDigitalCard){
            updateDigitalCardStatus(valueConvert(value), levelDigitalCard);
        } else {
            System.out.println("Error: this digital card isn't a level digital card");
        }
    }
    private void updateDigitalCardStatus(Integer experience, LevelDigitalCard levelDigitalCard){
        if(!levelDigitalCard.isCompleted()){
            levelDigitalCard.addExperience(experience);
            int nextLevel = levelDigitalCard.getLevel() + 1;
            while(levelDigitalCard.getExperience()>=levels.get(nextLevel).getExperienceToUnlock()){
                levelDigitalCard.levelUp();
                levelDigitalCard.removeExperience(levels.get(nextLevel).getExperienceToUnlock());
                levelDigitalCard.addRewards(levels.get(levelDigitalCard.getLevel()).getRewardsList());
                nextLevel++;
                if(levels.size()<nextLevel){
                    levelDigitalCard.setCompleted(true);
                    break;
                }
            }
        } else {
            System.out.println("Digital Card completed");
        }
    }

    private Integer valueConvert(Integer value){
        return value*conversionRate;
    }
}
