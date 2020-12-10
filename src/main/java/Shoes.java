

public class Shoes extends Clothes {
    private int id;
    private int shoe_number;
    private int cloth_id;

    public Shoes (String name, int price, String description, int shoe_number){
        super (name, price, description);
        this.shoe_number=shoe_number;

    }

    public int getShoe_number (){
        return shoe_number;
    }

    public int getId (){
        return id;
    }

    public int getCloth_id (){
        return cloth_id;
    }
}