package it.unicam.cs.ids.loyaltyPlatform.model.users;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCardService;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.LevelDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private DigitalCardService digitalCardService;


    /**
     * Method to add a client to the fidelity program, the method also creates a digital card and adds it to the client
     * @param client the client to add
     */
    public void addClient(Client client, FidelityProgram fidelityProgram) {
        if(fidelityProgram.getClients().contains(client)){
            throw new ResponseStatusException(HttpStatus.FOUND, "This user already exists inside this fidelity program");
        } else {
            if(fidelityProgram instanceof LevelFidelityProgram){

            }
        }

        //LevelDigitalCard levelDigitalCard = new LevelDigitalCard()
        //client.getDigitalWallet().addDigitalCard(levelDigitalCard);
    }

    public AuthenticatedUser addUser(@NonNull AuthenticatedUser user) {
        if (!userExists(user.getId())) {
            return this.repository.save(user);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is already present!");
    }

    public Optional<AuthenticatedUser> getUser(@NonNull Long id) {
        if (this.userExists(id) || this.repository.existsById(id)) {
            return this.repository.findById(id);
        }
        return Optional.empty();
    }

    public AuthenticatedUser getUser(@NonNull AuthenticatedUser user) {
        //TODO implement
        return null;
    }

    public void deleteUser(@NonNull Long id) {
        if (userExists(id)) {
            this.repository.deleteById(id);
        }
    }

    //TODO incomplete method definition
    public AuthenticatedUser updateAuthenticatedUser(@NonNull AuthenticatedUser user) {
//        Optional<AuthenticatedUser> oldUser = this.repository.findById(user.getID());
        return this.repository.save(user);
    }

    private boolean userExists(@NonNull Long id) {
        return this.repository.existsById(id);
    }

    //TODO incomplete method. method existsByEmail() in UserRepository isn't complete.
    private boolean userExists(@NonNull String email) {
        return this.repository.existsByEmail(email);
    }

}
