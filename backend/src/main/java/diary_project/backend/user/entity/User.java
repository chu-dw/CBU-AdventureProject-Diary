package diary_project.backend.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long Id;
    private String email;
    private String name;
    private String password; //비밀번호
    private String authToken; //jwt 토큰
    private String refreshToken; // Jwt 토큰을 갱신하기위한 토큰
}
