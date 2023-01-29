package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface AuthenticatedUserService<T extends  AuthenticatedUser> {

    T save(@NonNull T authenticatedUser);

    T update(@NonNull T authenticatedUser);

    T updateById(@NonNull Long id);

    T findById(@NonNull Long id);

    Optional<T> get(@NonNull T authenticatedUser);

    List<T> getAll();

    void delete(@NonNull T authenticatedUser);

    void deleteById(@NonNull Long id);

}
