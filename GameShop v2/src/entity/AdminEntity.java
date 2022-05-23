package entity;

public class AdminEntity {

    protected int id;
    protected String name;
    protected String password;

    public AdminEntity(){

    }

    public AdminEntity(int id, String name, String password){
        this.id=id;
        this.name=name;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
