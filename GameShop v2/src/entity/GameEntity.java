package entity;

public class GameEntity {

    protected int id;
    protected String name;
    protected double size;
    protected double price;
    protected double rating;
    protected int publisher_id;
    protected int developer_id;
    protected int bundle_id;

    public GameEntity(){

    }

    public GameEntity(int id, String name, double size, double price, double rating, int publisher_id, int developer_id, int bundle_id) {
        this.id=id;
        this.name=name;
        this.size=size;
        this.price=price;
        this.rating=rating;
        this.publisher_id=publisher_id;
        this.developer_id=developer_id;
        this.bundle_id=bundle_id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public double getSize() {
        return size;
    }

    public int getBundle_id() {
        return bundle_id;
    }

    public int getDeveloper_id() {
        return developer_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBundle_id(int bundle_id) {
        this.bundle_id = bundle_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", rating=" + rating +
                ", publisher_id=" + publisher_id +
                ", developer_id=" + developer_id +
                ", bundle_id=" + bundle_id +
                '}';
    }
}
