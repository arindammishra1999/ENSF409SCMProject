package edu.ucalgary.ensf409;
public class Furniture {
    private String type;
    private boolean[] piecesAvailable;
    private String ID;
    private int price;

    public Furniture(String type, String ID, int price, boolean[] piecesAvailable){
        this.type = type;
        this.ID = ID;
        this.price = price;
        this.piecesAvailable = piecesAvailable;
    }

    //need getter/setters for values

    public String getType(){
        return this.type;
    }

    public boolean[] getPiecesAvailable(){
        return this.piecesAvailable;
    }

    public String getID(){
        return this.ID;
    }

    public int getPrice(){
        return this.price;
    }
    //this class might make it easier to keep track of what the table contains
    //and help make the calculations less of a nightmare
}
