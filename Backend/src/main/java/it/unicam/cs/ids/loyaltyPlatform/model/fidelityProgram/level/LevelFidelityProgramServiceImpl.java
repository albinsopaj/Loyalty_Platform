package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level.LevelDigitalCard;
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
public class LevelFidelityProgramServiceImpl implements FidelityProgramService<LevelFidelityProgram>{
    @Autowired
    private LevelFidelityProgramRepository repository;

    @Override
    public LevelFidelityProgram save(@NonNull LevelFidelityProgram fidelityProgram) {
        if (!repository.findAll().contains(fidelityProgram)) {
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity program already exists");
        }
    }

    @Override
    public LevelFidelityProgram findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity program not found"));
    }

    @Override
    public Optional<LevelFidelityProgram> get(@NonNull LevelFidelityProgram levelFidelityProgram) {
        return this.repository.findById(levelFidelityProgram.getId());
    }

    @Override
    public List<LevelFidelityProgram> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LevelFidelityProgram update(@NonNull LevelFidelityProgram levelFidelityProgram) {
        return this.repository.save(levelFidelityProgram);
    }

    @Override
    public LevelFidelityProgram updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull LevelFidelityProgram levelFidelityProgram) {
        this.repository.delete(levelFidelityProgram);
    }

    @Override
    public void delete(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public LevelDigitalCard registerClient(@NonNull Client client, @NonNull LevelFidelityProgram fidelityProgram) {
        if(fidelityProgram.getLikedFidelityPrograms().contains(client)){
            throw new ResponseStatusException(HttpStatus.FOUND, "Client already in fidelity program");
        } else {
            fidelityProgram.addClient(client);
            LevelDigitalCard digitalCard = new LevelDigitalCard();
            digitalCard.setDigitalWallet(client.getDigitalWallet());
            digitalCard.setFidelityProgramId(fidelityProgram.getId());
            return digitalCard;
        }
    }
}