package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardService;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramService;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PointsFidelityProgramServiceImpl implements FidelityProgramService<PointsFidelityProgram> {

    @Autowired
    private PointsFidelityProgramRepository repository;

    @Autowired
    private DigitalCardService<PointsDigitalCard> digitalCardService;
    @Override
    public PointsFidelityProgram save(@NonNull PointsFidelityProgram fidelityProgram) {
        if (!repository.findAll().contains(fidelityProgram)) {
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity program already exists");
        }
    }

    @Override
    public PointsFidelityProgram findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity Program not found"));
    }

    @Override
    public Optional<PointsFidelityProgram> get(@NonNull PointsFidelityProgram PointsFidelityProgram) {
        return this.repository.findById(PointsFidelityProgram.getId());
    }

    @Override
    public List<PointsFidelityProgram> getAll() {
        return this.repository.findAll();
    }

    @Override
    public PointsFidelityProgram update(@NonNull PointsFidelityProgram PointsFidelityProgram) {
        return this.repository.save(PointsFidelityProgram);
    }

    @Override
    public PointsFidelityProgram updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull PointsFidelityProgram PointsFidelityProgram) {
        this.repository.delete(PointsFidelityProgram);
    }

    @Override
    public void delete(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public PointsDigitalCard registerClient(@NonNull Client client, @NonNull PointsFidelityProgram fidelityProgram) {
        if(fidelityProgram.getLikedFidelityPrograms().contains(client)){
            throw new ResponseStatusException(HttpStatus.FOUND, "Client already in fidelity program");
        } else {
            fidelityProgram.addClient(client);
            PointsDigitalCard digitalCard = new PointsDigitalCard();
            digitalCard.setDigitalWallet(client.getDigitalWallet());
            digitalCard.setFidelityProgramId(fidelityProgram.getId());
            client.getDigitalWallet().addDigitalCard(digitalCard);
            digitalCardService.save(digitalCard);
            return digitalCard;
        }
    }

    public Integer valueConvert(@NonNull PointsFidelityProgram pointsFidelityProgram, @NonNull Integer value){
        return pointsFidelityProgram.getConversionRate()*value;
    }
}
