package WebDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateAADTokenTest {

    @Test
    void validateToken() {
        ValidateAADToken validateAADToken = new ValidateAADToken();
        validateAADToken.validateToken();
    }
}