package db2024.view;

public class UserTopLevel extends TopLevel {
    private String email;

    public UserTopLevel() {
        super("Utente");
    }

    public void setCurrentUserEmail(String email){
        this.email = email;
    }
    
}
