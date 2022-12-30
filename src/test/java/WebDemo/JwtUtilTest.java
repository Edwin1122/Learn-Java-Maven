package WebDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    void createToken() {

        User edwin = new User("edwin", 18);

        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.createToken(edwin);
        System.out.println("Token: " + token);
    }

    @Test
    void parseToken() {
        JwtUtil jwtUtil = new JwtUtil();
        jwtUtil.parseToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJyZXMiOnsibmFtZSI6ImVkd2luIiwiYWdlIjoxOH0sInN1YiI6ImFkbWluIiwiZXhwIjoxNjcyOTg2NTEzLCJqdGkiOiJkZTQ1NzQ5MC01Mjc3LTQxNGMtYTY2Zi1mNWQzMmVhNTdkZTcifQ.fDtvGtO4xmJaOYy9feiOKvgPyHQvn4G2ukz5CrPO1ls");
    }
}