public class AccountsImpl implements Accounts {
    private String user;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String city;

    public AccountsImpl(String user, String password, String firstName, String lastName, String phone, String city) {
        this.user = user;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AccountsImpl{" +
                "FirstName = '" + firstName + '\'' +
                ", LastName = '" + lastName + '\'' +
                ", Phone = " + phone +
                ", City = '" + city + '\'' +
                '}';
    }

    @Override
    public void registration() {

    }

    @Override
    public void authorization() {

    }

    @Override
    public void input() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void status() {

    }
}
