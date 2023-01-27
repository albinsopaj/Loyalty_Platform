package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import java.util.List;
import java.util.Optional;

public interface UserService {

    AuthenticatedUser update(@NonNull AuthenticatedUser authenticatedUser);

    AuthenticatedUser updateById(@NonNull Long id);

    AuthenticatedUser findById(@NonNull Long id);

    Optional<AuthenticatedUser> get(@NonNull AuthenticatedUser authenticatedUser);

    List<AuthenticatedUser> getAll();

    void delete(@NonNull AuthenticatedUser authenticatedUser);

    void deleteById(@NonNull Long id);

    void deleteByEmail(@NonNull String email);


}
