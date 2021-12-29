package com.cars.halamotor_obeidat.model;

public class CertificateClaims {
    String claims,claimsS;

    public CertificateClaims(String claims, String claimsS) {
        this.claims = claims;
        this.claimsS = claimsS;
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }

    public String getClaimsS() {
        return claimsS;
    }

    public void setClaimsS(String claimsS) {
        this.claimsS = claimsS;
    }
}
