package BusinessLogic;

public class CustomerServiceAgent {
    private String Email;
    private String Password;

    public CustomerServiceAgent() {
    }

    public CustomerServiceAgent(String email, String password) {
        Email = email;
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
