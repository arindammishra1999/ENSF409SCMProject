package edu.ucalgary.ensf409;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Calculations {
    private ArrayList<Integer> costOptions;
    private ArrayList<Furniture> furniture;
    private ArrayList<String[]> idsForEachCostOption;
    public Calculations(){
        this.costOptions = new ArrayList<Integer>();
        this.furniture = new ArrayList<Furniture>();
        this.idsForEachCostOption = new ArrayList<String[]>();
    }

    /*this method loops through the ArrayList
    and finds the lowest priceing option out of
    the ones stored in the ArrayList*/
    public int choseBestPrice(){
        int bestPrice = this.costOptions.getValue(0);
        for(Node i:this.costOptions){
            if(i.getValue()<bestPrice){
                bestPrice=i.getValue();
            }
        }
    }

    /*this method will take in the results from the sql query
    and find the combination of items that will correctly form
    the desired object, returns the ids of the furniture items
    in a String array, if no such items exist it will return a string of
    length one with "error" inside*/
    public String[] calculatePrices(ResultSet results, String furnitureType){
        String[] ids = {"error"};

        //loop through results checking the one column to see if type matches,
        //if it does pull the info from the needed rows
        while(results.next()){
            if(checkFurnitureType(furnitureType, results.getString("Type"))){
                ArrayList<String> s = new ArrayList<String>();
                ResultSetMetaData rsmd = results.getMetaData();
                for(int i = 0; i < rsmd.getColumnCount(); i++){
                    if(results.getString(i).equals("Y") || results.getString(i).equals("N")){
                        s.add(results.getString(i));
                    }
                }
                boolean[] availability = makeBooleanArray(s.toStringArray());
                furniture.add(new Furniture(results.getString("Type"),results.getString("ID"),results.getInt("Price"), availability));
            }
        }

        //need to figure out how to return both the cost and the ids
        createOptions();
        return ids;
    }

    /*will check to make sure that the furniture being compared
    is the correct type for the wanted furniture*/
    private boolean checkFurnitureType(String wantedFurniture, String furnitureToCheck){
        if(wantedFurniture.equals(furnitureToCheck)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean convertPieceAvalabilityToBoolean(String available){
        if(available.equals("Y")){
            return true;
        }
        else{
            return false;
        }
    }

    //this method will somehow concatenate all the individual booleans together
    public boolean[] makeBooleanArray(String[] booleans){
        boolean[] b = new boolean[booleans.length];
        for(int i = 0; i < b.length; i++){
            b[i] = convertPieceAvalabilityToBoolean(booleans[i]);
        }
        return b;
    }

    /*this method loops through the furniture array in a sort of search mechanism,
    determines a combination of items has already been used by checking if the combo of ids
    already exists*/
    public void createOptions(){
        boolean[] b = createAllTrueArray(furniture.get(0).getPiecesAvailable().length);
       for(int i = 0; i <furniture.size();i++){
           String[] idCombo = {furniture.get(i).getID()};
           boolean[] parts = furniture.get(i).getPiecesAvailable();
           for(int j=0; j<furniture.size();j++){
                if(!checkArrayEquivalency(parts, furniture.get(j).getPiecesAvailable()) && 
                !checkArrayEquivalency(parts, b)){
                    addToBooleanArray(parts, furniture.get(j).getPiecesAvailable());
                    addToStringArray(idCombo, furniture.get(j).getID());
                }
           }
           if(checkArrayEquivalency(parts, b)&&!idsForEachCostOption.contains(idCombo)){
                costOptions.add(calculateCostFromIds(idCombo));
                idsForEachCostOption.add(idCombo);
           }
       }

       int cost = choseBestPrice();
       String[] idForSelected = idsForEachCostOption.get(costOptions.indexOf(cost));
    }

    private String[] addToStringArray(String[] array, String toAdd){
        String[] results = new String[array.length+1];
        for(int i = 0; i < array.length; i++){
            results[i] = array[i];
        }
        results[array.length] = toAdd;
        return results;
    }

    private boolean[] addToBooleanArray(boolean[] array, boolean[] toAdd){
        boolean[] results = new boolean[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i]==false && toAdd[i] == true){
                results[i] = toAdd[i];
            }else{
                results[i] = array[i];
            }
        }
        return results;
    }

    private boolean checkArrayEquivalency(boolean[] one, boolean[] two){
        for(int i =0; i <one.length; i++){
            if(one[i] != two[i]){
                return false;
            }
        }
        return true;
    }

    private boolean[] createAllTrueArray(int size){
      boolean[] a = new boolean[size];
      for(int i = 0; i <size; i++){
          a[i] = true;
      }
      return a;
    }

    private int calculateCostFromIds(String[] ids){
        int cost = 0;
        for(int i = 0; i < furniture.size(); i++){
            for(int j = 0; j < ids.length; j++){
                if(furniture.get(i).getID().equals(ids[j])){
                    cost += furniture.get(i).getPrice();
                }
            }
        }
        return cost;
    }
}
