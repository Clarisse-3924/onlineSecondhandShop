import java.util.Objects;

public class Clothes {
    private int price;
    private int id;
    private String name;
    private String description;




    public Clothes(String name, int price, String description){
        this.name=name;
        this.price=price;
        this.description=description;

    }
    public String getDescription (){
        return description;
    }

    public int getId (){
        return id;
    }

    public String getName (){
        return name;
    }

    public int getPrice (){
        return price;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Clothes clothes=(Clothes) o;
        return price == clothes.price &&
                id == clothes.id &&
                Objects.equals (name, clothes.name) &&
                Objects.equals (description, clothes.description);
    }

}
