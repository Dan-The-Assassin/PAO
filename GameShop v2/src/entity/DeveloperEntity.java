package entity;

public class DeveloperEntity {
    protected int id;
    protected String name;

    public DeveloperEntity(){
    }

    public DeveloperEntity(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DeveloperEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
