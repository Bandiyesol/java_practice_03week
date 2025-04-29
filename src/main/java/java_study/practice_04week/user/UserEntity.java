package java_study.practice_04week.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserEntity {
    @Id

    private Long id;

    private String name;
    private String email;
    private String password;

    public void SetName(String name) {
        this.name = name;
    }

    public void SetEmail(String email) {
        this.email = email;
    }

    public void SetPassword(String password) {
        this.password = password;
    }

}
