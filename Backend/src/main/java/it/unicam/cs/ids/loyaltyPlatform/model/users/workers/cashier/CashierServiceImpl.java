package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level.LevelDigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsReward;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.ClientServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CashierServiceImpl implements GeneralService<Cashier> {

    @Autowired
    private CashierRepository repository;

    @Autowired
    private PointsFidelityProgramServiceImpl pointsFidelityProgramService;

    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private LevelDigitalCardServiceImpl levelDigitalCardService;
    @Autowired
    private PointsDigitalCardServiceImpl pointsDigitalCardService;
    @Autowired
    private FidelityProgramServiceImpl fidelityProgramService;

    public Cashier save(@NonNull Cashier cashier) {
        if (!repository.findAll().contains(cashier)) {
            return this.repository.save(cashier);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Cashier already exists");
        }
    }

    @Override
    public Cashier findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cashier not found"));
    }

    @Override
    public Optional<Cashier> get(@NonNull Cashier cashier) {
        return this.repository.findById(cashier.getId());
    }

    @Override
    public List<Cashier> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cashier update(@NonNull Cashier cashier) {
        return this.repository.save(cashier);
    }

    @Override
    public Cashier updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Cashier cashier) {
        this.repository.delete(cashier);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }


    public Client viewClientProfile(@NonNull Long clientId){
        return this.clientService.findById(clientId);
    }

    public Client registerClient(@NonNull Client client){
        return this.clientService.save(client);
    }

    public void updatePointsDigitalCardStatus(@NonNull Long cashierId, @NonNull Long digitalCardId, @NonNull Integer value){
        PointsFidelityProgram pointsFidelityProgram = this.pointsFidelityProgramService.findById(this.pointsDigitalCardService.findById(digitalCardId).getFidelityProgramId());
        if(findById(cashierId).getCompany().getFidelityPrograms().contains(pointsFidelityProgram)){
            this.pointsFidelityProgramService.updateStatus(digitalCardId, value);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Cashier doesn't have access to this digital card");
        }
    }

    public void updateLevelDigitalCardStatus(@NonNull Long cashierId, @NonNull Long digitalCardId, @NonNull Integer value){
        LevelFidelityProgram levelFidelityProgram = this.levelFidelityProgramService.findById(this.levelDigitalCardService.findById(digitalCardId).getFidelityProgramId());
        if(findById(cashierId).getCompany().getFidelityPrograms().contains(levelFidelityProgram)){
            this.levelFidelityProgramService.updateStatus(digitalCardId,value);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Cashier doesn't have access to this digital card");
        }
    }

    public boolean redeemReward(@NonNull Long cashierId, @NonNull Long pointsDigitalCardId, @NonNull PointsReward pointsReward){
        PointsFidelityProgram pointsFidelityProgram = this.pointsFidelityProgramService.findById(this.pointsDigitalCardService.findById(pointsDigitalCardId).getFidelityProgramId());
        if(findById(cashierId).getCompany().getFidelityPrograms().contains(pointsFidelityProgram)){
            return this.pointsFidelityProgramService.redeemReward(pointsDigitalCardId,pointsReward);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Cashier doesn't have access to this digital card");
        }
    }
}
