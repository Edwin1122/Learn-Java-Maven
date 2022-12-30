package WebDemo;

import cn.hutool.json.JSONObject;
import org.junit.jupiter.api.Test;


class NormalJwtUtilTest {

    @Test
    void verifyToken(){

        JSONObject subjectJson = new JSONObject();
        subjectJson.put("userId", 8888);
        subjectJson.put("name", "ylc");

        String token = Auth0JwtUtil.createToken(subjectJson);
        System.out.println("token:" + token);
        System.out.println("===================");

        System.out.println("Verify result: " + Auth0JwtUtil.verifyToken(token));
        System.out.println("===================");


        System.out.println("Decode info: ");
        Auth0JwtUtil.decodeToken(token);

    }
}