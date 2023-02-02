package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
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
public class ManagerServiceImpl implements GeneralService<Manager> {

    @Autowired
    private ManagerRepository repository;
    @Autowired
    private FidelityProgramServiceImpl fidelityProgramService;
    @Autowired
    private ClientServiceImpl clientService;
    public Manager save(@NonNull Manager manager) {
        if (!repository.findAll().contains(manager)) {
            return this.repository.save(manager);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "manager already exists");
        }
    }

    @Override
    public Manager findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "manager not found"));
    }

    @Override
    public Optional<Manager> get(@NonNull Manager manager) {
        return this.repository.findById(manager.getId());
    }

    @Override
    public List<Manager> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Manager update(@NonNull Manager manager) {
        return this.repository.save(manager);
    }

    @Override
    public Manager updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Manager manager) {
        this.repository.delete(manager);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public void removeClient(@NonNull Long managerId, @NonNull Long clientId, @NonNull Long fidelityProgramId){
        if(findById(managerId).getCompany().equals(this.fidelityProgramService.findById(fidelityProgramId).getCompany())){
            if(this.clientService.findById(clientId).getFidelityProgramIds().contains(fidelityProgramId)){
                this.clientService.removeFidelityProgramSubscription(clientId, fidelityProgramId);
            } else {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Client isn't in this fidelity program");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Manager isn't part of the company that owns this fidelity program");
        }
    }

    public void registerClientToFidelityProgram(@NonNull Long managerId, @NonNull Long clientId, @NonNull Long fidelityProgramId){
        if(findById(managerId).getCompany().getFidelityPrograms().contains(this.fidelityProgramService.findById(fidelityProgramId))){
            Client client = this.clientService.findById(clientId);
            FidelityProgram fidelityProgram = this.fidelityProgramService.findById(fidelityProgramId);
            this.fidelityProgramService.registerClient(client, fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Cashier doesn't belong to the company that contains this fidelity program");
        }
    }
}
