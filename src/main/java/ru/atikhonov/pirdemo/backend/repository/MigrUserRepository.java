package ru.atikhonov.pirdemo.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atikhonov.pirdemo.backend.model.MigrUser;

import java.util.Optional;

public interface MigrUserRepository extends JpaRepository<MigrUser, Long> {
    Optional<MigrUser> findByLogin(String login);

}
