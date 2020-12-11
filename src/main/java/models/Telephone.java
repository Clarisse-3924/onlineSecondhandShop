package models;

public class Telephone {

    private int p_id;
    private String name;
    private String description;
    private  int price;
    private String image;

    public Telephone (String name, int price, String description,String image){
        super();
        this.description=description;
       this.name=name;
       this.price=price;
       this.image=image;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telephone)) return false;

        Telephone telephone = (Telephone) o;

        if (p_id != telephone.p_id) return false;
        if (price != telephone.price) return false;
        if (name != null ? !name.equals(telephone.name) : telephone.name != null) return false;
        if (description != null ? !description.equals(telephone.description) : telephone.description != null)
            return false;
        return image != null ? image.equals(telephone.image) : telephone.image == null;
    }

    @Override
    public int hashCode() {
        int result = p_id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}