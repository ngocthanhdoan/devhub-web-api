package com.devhub.io.vn.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CorsConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "allowed_origins")
    private String allowedOrigins;

    @Column(name = "allowed_methods")
    private String allowedMethods;

    @Column(name = "allowed_headers")
    private String allowedHeaders;

    @Column(name = "exposed_headers")
    private String exposedHeaders;

    @Column(name = "allow_credentials")
    private boolean allowCredentials;

    @Column(name = "max_age")
    private int maxAge;

    // Constructors, getters, setters
    // ...

    public CorsConfig() {
        // Default constructor
    }
    

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the allowedOrigins
     */
    public String getAllowedOrigins() {
        return allowedOrigins;
    }

    /**
     * @param allowedOrigins the allowedOrigins to set
     */
    public void setAllowedOrigins(String allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    /**
     * @return String return the allowedMethods
     */
    public String getAllowedMethods() {
        return allowedMethods;
    }

    /**
     * @param allowedMethods the allowedMethods to set
     */
    public void setAllowedMethods(String allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    /**
     * @return String return the allowedHeaders
     */
    public String getAllowedHeaders() {
        return allowedHeaders;
    }

    /**
     * @param allowedHeaders the allowedHeaders to set
     */
    public void setAllowedHeaders(String allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    /**
     * @return String return the exposedHeaders
     */
    public String getExposedHeaders() {
        return exposedHeaders;
    }

    /**
     * @param exposedHeaders the exposedHeaders to set
     */
    public void setExposedHeaders(String exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    /**
     * @return boolean return the allowCredentials
     */
    public boolean isAllowCredentials() {
        return allowCredentials;
    }

    /**
     * @param allowCredentials the allowCredentials to set
     */
    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    /**
     * @return int return the maxAge
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * @param maxAge the maxAge to set
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

}
