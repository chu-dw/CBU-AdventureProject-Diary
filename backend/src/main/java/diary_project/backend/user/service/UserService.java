package diary_project.backend.user.service;

import diary_project.backend.user.entity.User;
import diary_project.backend.user.repository.UserRepository;
import diary_project.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Qualifier("UserService")
    public JwtUtil util;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> SignIn(User user){
        if(userRepository.existsByEmail(user.getEmail()) && userRepository.existsByPassword(user.getPassword())){
            String authToken = util.CreateToken(user.getEmail());
            String refreshToken = util.createRefreshToken();

            savaRefreshToken(refreshToken,user.getEmail());

            return userRepository.findUserByEmail(user.getEmail());
        }
        else { throw new IllegalStateException("로그인 실패");}
    }

    private void savaRefreshToken(String email, String RefreshToken) {
        userRepository.updateByRefreshToken(email,RefreshToken);
    }

    public void logout(String email){
        userRepository.deleteByRefreshToken("",email);
    }

    public boolean checkToken(String refreshToken){ //토큰 존재여부 검사
        return userRepository.existsByRefreshToken(refreshToken);
    }

}
