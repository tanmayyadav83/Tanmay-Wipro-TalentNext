package Module4.SpringMiniProject;
public class User {
    private Integer id;
    private String username;
    private String password; // plain input (not stored)
    private String employeeNo;
    private String email;

    public User() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmployeeNo() { return employeeNo; }
    public void setEmployeeNo(String employeeNo) { this.employeeNo = employeeNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
