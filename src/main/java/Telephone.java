public class Telephone extends Clothes {
    private int id;
    private String trade_mark;
    public Telephone (String name, int price, String description,String trade_mark){
        super (name, price, description);
        this.trade_mark=trade_mark;
    }

    @Override
    public int getId (){
        return id;
    }

    public String getTrade_mark (){
        return trade_mark;
    }
}