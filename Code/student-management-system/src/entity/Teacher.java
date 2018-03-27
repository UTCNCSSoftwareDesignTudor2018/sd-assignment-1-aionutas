package entity;

public class Teacher {

    private String name;
    private int id;
    private String address;
    private int identityCardNumber;
    private int personalNumericalCode;
    private String username;
    private String password;

    public Teacher() {
    }

    public Teacher(String name, int id, String address, int identityCardNumber, int personalNumericalCode) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.identityCardNumber = identityCardNumber;
        this.personalNumericalCode = personalNumericalCode;
    }

    public Teacher(String name, int id, String address, int identityCardNumber, int personalNumericalCode, String username, String password) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.identityCardNumber = identityCardNumber;
        this.personalNumericalCode = personalNumericalCode;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(int identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public int getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setPersonalNumericalCode(int personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (identityCardNumber != teacher.identityCardNumber) return false;
        if (personalNumericalCode != teacher.personalNumericalCode) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        if (address != null ? !address.equals(teacher.address) : teacher.address != null) return false;
        if (username != null ? !username.equals(teacher.username) : teacher.username != null) return false;
        return password != null ? password.equals(teacher.password) : teacher.password == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + identityCardNumber;
        result = 31 * result + personalNumericalCode;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", identityCardNumber=" + identityCardNumber +
                ", personalNumericalCode=" + personalNumericalCode +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
