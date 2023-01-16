package diary_project.backend.user.repository;

import diary_project.backend.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    @Query("Select u.name from User u")
    List<Object[]> getList();


    @Query("Select u from User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

    boolean existsByEmail(String email);

    boolean existsByPassword(String password);
    @Modifying(clearAutomatically = true)
    @Query("update User u set refreshToken = :refreshToken where u.email = :email")
    void updateByRefreshToken(@Param("refreshToken") String refreshToken,@Param("email") String email);

    @Modifying(clearAutomatically = true)
    @Query("update User u set refreshToken = :logout where u.email = :email") // null이라 써도 되나?
    void deleteByRefreshToken(@Param("logout") String logout,@Param("email") String email);

    boolean existsByRefreshToken(String refreshToken);
}
