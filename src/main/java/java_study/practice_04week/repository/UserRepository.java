package java_study.practice_04week.repository;

import java_study.practice_04week.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByName(String name);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByNameAndPassword(String name, String password);

    Optional<UserEntity> findByToken(String token);
}
