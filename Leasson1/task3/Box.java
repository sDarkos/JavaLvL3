package Leasson1.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruits (T fruit){
        fruits.add(fruit);
    }

    public boolean compare (Box<? extends Fruit> box){
        return getWeight() == box.getWeight();
    }

    public float getWeight (){
        if (fruits.size() != 0){
            return fruits.get(0).getWeight() * fruits.size();
        }
        return 0f;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void rotate (Box<T> box){
        fruits.addAll(box.getFruits());
        box.getFruits().clear();
    }

    public int getCount (){
        return fruits.size();
    }
}
