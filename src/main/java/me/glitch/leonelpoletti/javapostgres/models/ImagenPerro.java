package me.glitch.leonelpoletti.javapostgres.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagenPerro {
    @JsonProperty(value = "message")
    private String message;
    @JsonProperty(value = "status")
    private String status;
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public String toString() {
        return "message: " + this.message + ", status: " + this.status;
    }
}
