package BusinessLogic;

public class Admin {
    private String Email;
    private String Password;

    public Admin(String email, String password) {
        Email = email;
        Password = password;
    }

    public Admin() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
