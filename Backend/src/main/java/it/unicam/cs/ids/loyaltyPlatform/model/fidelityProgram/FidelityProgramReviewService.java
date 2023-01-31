package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class FidelityProgramReviewService {
    @Autowired
    private @NonNull FidelityProgramReviewRepository repository;
    
    public FidelityProgramReview save(@NonNull FidelityProgramReview fidelityProgramReview) {
        if (!repository.findAll().contains(fidelityProgramReview)) {
            return this.repository.save(fidelityProgramReview);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "review already exists");
        }
    }

    public FidelityProgramReview findById(@NonNull FidelityProgramReviewKey id) {
        //TODO
        return null;
    }


    public Optional<FidelityProgramReview> get(@NonNull FidelityProgramReview fidelityProgramReview) {
        //TODO
        return null;
    }

    public List<FidelityProgramReview> getAll() {
        return this.repository.findAll();
    }

    public FidelityProgramReview update(@NonNull FidelityProgramReview fidelityProgramReview) {
        return this.repository.save(fidelityProgramReview);
    }

    public FidelityProgramReview updateById(@NonNull FidelityProgramReviewKey id) {
        //TODO
        return null;
    }

    public void delete(@NonNull FidelityProgramReview fidelityProgramReview) {
        this.repository.delete(fidelityProgramReview);
    }

    public void delete(@NonNull FidelityProgramReviewKey id) {
        //TODO
    }


}
