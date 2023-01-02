package WebDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;

import com.auth0.jwk.*;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidateAADToken
{

    private static Logger logger = LoggerFactory.getLogger(ValidateAADToken.class);

    public void validateToken(){
//        System.out.println("AAD Token Validation");
        logger.info("AAD Token Validation");

        // Validate Azure AD Token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiJhcGk6Ly84ZmYwZGQxMC0zMmQ2LTRiZTUtYjkyOS0xNjRmZDQ0NmNhOTciLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC84MDBkOTIyNS1jYzUxLTRjZDgtYmUwNS1kNmY5NDgxZmZmNjUvIiwiaWF0IjoxNjcxMDE0MDQwLCJuYmYiOjE2NzEwMTQwNDAsImV4cCI6MTY3MTAxNzk0MCwiYWlvIjoiRTJaZ1lKZ1lzZkJxOVQyclZXN1h1OFIvM05xZ0JRQT0iLCJhcHBpZCI6IjQ4YjFkZmY3LTM3ODQtNGUyMS1iMjI5LTZiY2FlODM2NWNiNSIsImFwcGlkYWNyIjoiMSIsImlkcCI6Imh0dHBzOi8vc3RzLndpbmRvd3MubmV0LzgwMGQ5MjI1LWNjNTEtNGNkOC1iZTA1LWQ2Zjk0ODFmZmY2NS8iLCJvaWQiOiIwMmIzODc5My02ODg3LTQ5NmMtOGIwZi01OWY5OGI5OGI2YjYiLCJyaCI6IjAuQVZZQUpaSU5nRkhNMkV5LUJkYjVTQl9fWlJEZDhJX1dNdVZMdVNrV1Q5Ukd5cGVmQUFBLiIsInJvbGVzIjpbIkZsaWVVcGxvYWQiXSwic3ViIjoiMDJiMzg3OTMtNjg4Ny00OTZjLThiMGYtNTlmOThiOThiNmI2IiwidGlkIjoiODAwZDkyMjUtY2M1MS00Y2Q4LWJlMDUtZDZmOTQ4MWZmZjY1IiwidXRpIjoiUGphaWhsdERXRVdXQUtkS01US01BQSIsInZlciI6IjEuMCJ9.rhlSDyYlBiYgEVhD_WGqKh3qMvl-PcIwnedGJIS_l7_mox2SP8FSOKUlFRZYTrKLynV3GQufPT8ABNQ_HuASY6TTplsCVtMqjoyEIrrTEg2cEJhzsCMx_1Xn2q8sDU0ex3wzgG8H35Kx1W9g_kdcHPDqKhJT6zsckxQDTDzaITqS-LZExmyOMNBvLEdUQ3m4BS7SAoPZ5ljG8g4tTKjy_MI7FNvIdgmbJGz3U_ynrZpVWkWp734zuKq0WRKXrLZxXPxeFWyUAP_AOQEJhvec4wOI6aaIDJl5zj45GCszw0cFknQNGmynoggeKF2AWKtKDgzeXwvQg91Coe0gFPAL0Q";
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(jwt.getKeyId());

        JwkProvider provider = null;
        Jwk jwk = null;
        Algorithm algorithm = null;

        try {

            provider = new UrlJwkProvider(new URL("https://login.microsoftonline.com/common/discovery/keys"));
            jwk = provider.get(jwt.getKeyId());
            algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            algorithm.verify(jwt);// if the token signature is invalid, the method will throw SignatureVerificationException

            try {
                JWTVerifier verifier = JWT.require(algorithm).withAudience("api://d92655f6-2a63-458b-9fe2-187e176397b4")
                        .withClaim("roles", "DaemonAppRole").build(); // Reusable verifier instance
                DecodedJWT jwt2 = verifier.verify(token);
                logger.info("Decoded JWT: {}", jwt2);
            } catch (TokenExpiredException e) {
                System.out.println("Token is expired");
            } catch (InvalidClaimException e) {
                System.out.println("Invalid Claim for Audience");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JwkException e) {
            e.printStackTrace();
        } catch (SignatureVerificationException e) {
            System.out.println(e.getMessage());
        }
    }
}
