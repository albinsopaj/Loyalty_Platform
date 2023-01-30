package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramService;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements AuthenticatedUserService<Client> {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;
    @Autowired
    private PointsFidelityProgramServiceImpl pointsFidelityProgramService;
    public Client save(@NonNull Client client) {
        if (!repository.findAll().contains(client)) {
            return this.repository.save(client);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "client already exists");
        }
    }

    @Override
    public Client findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found"));
    }

    @Override
    public Optional<Client> get(@NonNull Client client) {
        return this.repository.findById(client.getId());
    }

    @Override
    public List<Client> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Client update(@NonNull Client client) {
        return this.repository.save(client);
    }

    @Override
    public Client updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Client client) {
        this.repository.delete(client);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public void registerToPointsFidelityProgram(@NonNull Client client, @NonNull PointsFidelityProgram fidelityProgram){
        DigitalCard digitalCard = this.pointsFidelityProgramService.registerClient(client, fidelityProgram);
        client.getDigitalWallet().addDigitalCard(digitalCard);
        }
    public void registerToLevelFidelityProgram(@NonNull Client client, @NonNull LevelFidelityProgram fidelityProgram){
        DigitalCard digitalCard = this.levelFidelityProgramService.registerClient(client, fidelityProgram);
        client.getDigitalWallet().addDigitalCard(digitalCard);
    }
}
