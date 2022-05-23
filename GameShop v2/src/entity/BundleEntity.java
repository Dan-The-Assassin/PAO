package entity;

public class BundleEntity {
    protected int id;
    protected String name;
    protected int discount;

    public BundleEntity(){

    }

    public BundleEntity(int id, String name, int discount){
        this.id=id;
        this.name=name;
        this.discount=discount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "BundleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                '}';
    }
}
