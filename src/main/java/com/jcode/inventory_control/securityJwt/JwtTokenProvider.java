package com.jcode.inventory_control.securityJwt;

import com.auth0.jwt.algorithms.Algorithm;
import com.jcode.inventory_control.dto.security.TokenDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class JwtTokenProvider {
	
	@Value("${security.jwt.token.secret-key: secret}")
	private String secretKey = "secretKey";
	
	@Value("${security.jwt.token.expire-lenght: 3600000}")
	private long validityMilliseconds = 3600000;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	Algorithm algorithm = null;
	
	@PostConstruct
	protected void init(){
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}
	
	public TokenDto createAccessToken(String loing, List<String> roles){
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityMilliseconds);
		var accessToken = getAccessToken(loing, roles, now, validity);
		var refreshToken = getRefreshToken(loing, roles, now);
		return new TokenDto(loing, true, now, validity, accessToken,refreshToken);
	}
	
	private String getAccessToken(String loing, List<String> roles, Date now, Date validity) {
		return null;
	}
	
	private String getRefreshToken(String loing, List<String> roles, Date now) {
		return null;
	}
}
