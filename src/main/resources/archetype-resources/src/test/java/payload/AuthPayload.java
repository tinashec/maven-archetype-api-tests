package ${package}.payload;

public class AuthPayload{

    private String username, password;
    
    public AuthPayload(String username, String password){
        this.username = username;
        this.password = password;
    }
}