package java_study.practice_04week.repository;

import java_study.practice_04week.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByEmail(String email);
}
