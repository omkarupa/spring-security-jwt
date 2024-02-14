package com.pu_solutions.simplejwt.jwt;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	private Key key;
	
	private static String secretKey = "omkarupa";
	

	public JWTService() {
		super();
		this.key = generateKey();
	}



	private Key generateKey() {
		
		return Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
		
		
	}


	public String generateToken(String username)
	{
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 10))
				.signWith(key)
				.compact();
		
	}
	
	
	public Claims extractAllClaims(String token)
	{
		return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
	
	private <T> T extractClaims(String token,Function<Claims, T> claimsResolver)
	{
		Claims claims = extractAllClaims(token);
		
		return claimsResolver.apply(claims);
	}
	
	
	public String getUsernameFromToken(String token)
	{
		return extractClaims(token, Claims::getSubject);
		
	}
	
	public Date extractExpirationTime(String token)
	{
		return extractClaims(token, Claims::getExpiration);
	}
	
	public boolean isTokenExpired(String token)
	{
		return extractExpirationTime(token).before(new Date(System.currentTimeMillis()));
	}
	
	public boolean isTokenValid(String token,String username)
	{
		return getUsernameFromToken(token).equals(username) && !isTokenExpired(token);
	}

}
