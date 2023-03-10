package WebDemo;

public class ForgeRockUtil {


    /**
     * Validate the integrity of the JWT OIDC token, according to the spec
     * (http://openid.net/specs/openid-connect-core-1_0.html#IDTokenValidation). Specifically check that the issuer is
     * the expected issuer, the token has not expired, the token has at least one audience claim, and if there is an
     * authorized party claim ("azp"), does it appear in the audience list contained within the token?
     *
     * @param jwtValue The encoded JWT string.
     * @return The validated JWT claims.
     * @throws AuthLoginException
     */
    /*
    public JwtClaimsSet validateJwt(String jwtValue) throws AuthLoginException {
        final SignedJwt signedJwt = getSignedJwt(jwtValue);
        JwtClaimsSet jwtClaimSet = signedJwt.getClaimsSet();
        final String jwtClaimSetIssuer = jwtClaimSet.getIssuer();
        if (!config.getConfiguredIssuer().equals(jwtClaimSetIssuer)) {
            logger.error("The issuer configured for the module, " + config.getConfiguredIssuer() + ", and the " + "issuer found in the token, " + jwtClaimSetIssuer + ", do not match. This means that the token " + "authentication was directed at the wrong module, or the targeted module is mis-configured.");
            throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_TOKEN_ISSUER_MISMATCH, null);
        }
        // See if a resolver is present corresponding to jwt issuer, and if not, add, then dispatch validation to
        // resolver.
        OpenIdResolver resolver = openIdResolverCache.getResolverForIssuer(config.getCryptoContextValue());
        if (resolver == null) {
            if (logger.messageEnabled()) {
                if (CRYPTO_CONTEXT_TYPE_CLIENT_SECRET.equals(config.getCryptoContextType())) {
                    logger.message("Creating OpenIdResolver for issuer " + jwtClaimSetIssuer + " using client secret");
                } else {
                    logger.message("Creating OpenIdResolver for issuer " + jwtClaimSetIssuer + " using config url " + config.getCryptoContextValue());
                }
            }
            try {
                resolver = openIdResolverCache.createResolver(jwtClaimSetIssuer, config.getCryptoContextType(), config.getCryptoContextValue(), config.getCryptoContextUrlValue());
            } catch (IllegalStateException e) {
                logger.error("Could not create OpenIdResolver for issuer " + jwtClaimSetIssuer + " using crypto context value " + config.getCryptoContextValue() + " :" + e);
                throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_ISSUER_MISMATCH, null);
            } catch (FailedToLoadJWKException e) {
                logger.error("Could not create OpenIdResolver for issuer " + jwtClaimSetIssuer + " using crypto context value " + config.getCryptoContextValue() + " :" + e, e);
                throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_JWK_NOT_LOADED, null);
            }
        }
        try {
            resolver.validateIdentity(signedJwt);
            List<String> audienceClaim = jwtClaimSet.getAudience();
            if (!jwtHasAudienceClaim(jwtClaimSet)) {
                logger.error("No audience claim present in ID token.");
                throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_NO_AUDIENCE_CLAIM, null);
            }
            if (jwtHasAuthorizedPartyClaim(jwtClaimSet)) {
                String authorizedPartyClaim = (String) jwtClaimSet.getClaim(AUTHORIZED_PARTY_CLAIM_KEY);
                if (!audienceClaim.contains(authorizedPartyClaim)) {
                    logger.error("Authorized party was present in ID token, but its value was not found in the " + "audience claim.");
                    throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_AUTHORIZED_PARTY_NOT_IN_AUDIENCE, null);
                }
            }
        } catch (OpenIdConnectVerificationException oice) {
            logger.warning("Verification of ID Token failed: " + oice);
            throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_VERIFICATION_FAILED, null);
        } catch (JwsSigningException jse) {
            logger.error("JwsSigningException", jse);
            throw new AuthLoginException(RESOURCE_BUNDLE_NAME, BUNDLE_KEY_JWS_SIGNING_EXCEPTION, null);
        }
        return jwtClaimSet;
    }
    */
}
