public class Charger extends Clothes{
    private int id;
    private int phone_id;

    public Charger (String name, int price, String description,int phone_id){
        super (name, price, description);
        this.phone_id=phone_id;

    }

    public int getPhone_id (){
        return phone_id;
    }

    @Override
    public int getId (){
        return id;
    }
}