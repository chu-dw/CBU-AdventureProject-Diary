package diary_project.backend.util;

import io.jsonwebtoken.*;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

@Slf4j
@UtilityClass
public class JwtUtil {
    private String salt = "dw";

    private Long expireMin = Long.valueOf(2);


    public String CreateToken(String email){
        return create(email,"authToken",expireMin);
    }


    private String create(String email,String subject,Long expireMin) //토큰 생성
    {
        final JwtBuilder builder = Jwts.builder();
        //header 설정
        //builder.setHeaderParam("typ","Jwt")로 고정
        //payload 설정 -claim 정보 포함
        builder.setSubject(subject) //subject 에는 유효기간이 들어감
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*expireMin)); //유효기간은 2분
        if(email != null)
        {
            builder.claim("user",email);
        }
        //signature - secret key 를 이용한 암호화 . salt -> secret key ?
        builder.signWith(SignatureAlgorithm.HS256,salt.getBytes());
        final String jwt = builder.compact();
        log.debug("토큰발행 {}",jwt);
        return jwt;
    }

    public Map<String,Object> checkAndGetClaims(String jwt){ //토큰에 저장된 정보꺼내기
        Jws<Claims> claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt); //claim 꺼내기 =>디코딩
        log.trace("claims:{}",claims);
        return claims.getBody();
    }



    public String createRefreshToken(){ //refreshToken 생성
        return create(null,"refreshToken",expireMin*5);
    }
}
