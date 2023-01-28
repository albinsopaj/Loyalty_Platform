package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface AuthenticatedUserService<T extends  AuthenticatedUser> {

    T save(@NonNull T authenticatedUser);

    T saveById(@NonNull Long id);

    T update(@NonNull T authenticatedUser);

    T updateById(@NonNull Long id);

    T findById(@NonNull Long id);

    Optional<T> get(@NonNull T authenticatedUser);

    List<T> getAll();

    void delete(@NonNull T authenticatedUser);

    void delete(@NonNull Long id);

    void delete(@NonNull String email);
}
