package edu.wbu.dorm.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    public static String SECRET = "dsahdasdkjfd7236487ydys7s77f67sdf";

    public static String createToken(String uid,int role,int permission){
        long nowTime = System.currentTimeMillis();
        long expiresTime = nowTime + 1000*3600*2;
        Map<String ,Object> map = new HashMap<>();
        map.put("alg","hs256");
        map.put("typ","jwt");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("uid",uid)
                .withClaim("role",role)
                .withClaim("permission",permission)
                .withExpiresAt(new Date(expiresTime))
                .withIssuedAt(new Date(nowTime))
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public static Map<String,Claim> verifyToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        jwt = verifier.verify(token);
        return jwt.getClaims();
    }

    public static void main(String[] args) {
        String token = createToken("150576008",0,1);
        System.out.println(token);
        /*Map<String,Claim> map = verifyToken(token);
        System.out.println(map.get("uid").asString());
        System.out.println(map.get("role").asInt());*/
    }

}
