package WebDemo;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class JwtUtil {

    //salt，一段加密的字符，这一串东西不能给别人知道不然就不安全了，只有设计者知道
    private String signature = "@!ILoveJava 1314";

    //设置有效时间是7天1000 * 60 * 60 * 24 * 7
    private long time = 1000 * 60 * 60 * 24 * 7;

    /**
     * 创建Token的方法，参数是一个结果集,传入的参数是要携带的数据对象
     * @param object
     * @return
     */
    public String createToken (Object object) {
        JwtBuilder jwtBuilder = Jwts.builder();

        String jwtToken = jwtBuilder
                //设置头信息，typ是头类型，alg是编码算法！
                //Header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload,载荷，也就是存数据的部分
                .claim("res",object)
                //加一个主题，也就是前端获取到的数据名称
                .setSubject("admin")

                //设置有效期
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())

                //Signature 设置标签（签名）识别的方式，解密算法和salt
                .signWith(SignatureAlgorithm.HS256, signature)

                //拼接Header、payload和Signature成一个完整的Token
                .compact();

        return jwtToken;
    }

    /**
     * 判断某些拦截的页面是否携带有token
     * @param token
     * @return
     */
    public boolean parseToken(String token) {
        if (token == null) {
            return false;
        }

        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            Map user = body.get("res", LinkedHashMap.class);
            String issuer = body.getIssuer();

            System.out.println("Got user: " + user);
            System.out.println("Got issuer: " + issuer);
        } catch (Exception e) {
            return false;
        }

        return true;

    }
}
