package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level.LevelDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class FidelityProgramServiceImpl implements GeneralService<FidelityProgram> {
    
    @Autowired
    private FidelityProgramRepository repository;
    @Autowired
    private DigitalCardServiceImpl digitalCardService;

    @Override
    public FidelityProgram save(@NonNull FidelityProgram fidelityProgram) {
        if (!repository.findAll().contains(fidelityProgram)) {
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity program already exists");
        }
    }

    @Override
    public FidelityProgram findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity Program not found"));
    }

    @Override
    public Optional<FidelityProgram> get(@NonNull FidelityProgram FidelityProgram) {
        return this.repository.findById(FidelityProgram.getId());
    }

    @Override
    public List<FidelityProgram> getAll() {
        return this.repository.findAll();
    }

    @Override
    public FidelityProgram update(@NonNull FidelityProgram FidelityProgram) {
        return this.repository.save(FidelityProgram);
    }

    @Override
    public FidelityProgram updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull FidelityProgram FidelityProgram) {
        this.repository.delete(FidelityProgram);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }


    public DigitalCard registerClient(@NonNull Client client, @NonNull FidelityProgram fidelityProgram) {
        if(fidelityProgram.getLikedFidelityPrograms().contains(client)){
            throw new ResponseStatusException(HttpStatus.FOUND, "Client already in fidelity program");
        } else {
            fidelityProgram.addClient(client);
            DigitalCard digitalCard;
            if(fidelityProgram instanceof PointsFidelityProgram pointsFidelityProgram){
                 digitalCard = new PointsDigitalCard(fidelityProgram.getId(),client.getDigitalWallet());
            } else {
                digitalCard = new LevelDigitalCard(fidelityProgram.getId(), client.getDigitalWallet());
            }
            digitalCard.setDigitalWallet(client.getDigitalWallet());
            digitalCard.setFidelityProgramId(fidelityProgram.getId());
            client.getDigitalWallet().addDigitalCard(digitalCard);
            digitalCardService.save(digitalCard);
            return digitalCard;
        }
    }
}
