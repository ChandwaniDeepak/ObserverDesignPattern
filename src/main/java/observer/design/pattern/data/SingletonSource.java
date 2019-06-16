package observer.design.pattern.data;

import observer.design.pattern.Modal.Celebrity;
import observer.design.pattern.Modal.Fan;

import java.util.ArrayList;
import java.util.List;

public class SingletonSource {

    private static volatile SingletonSource data = new SingletonSource();
    private List<Celebrity> celebrities;
    private List<Fan> fans;

    //private constructor.
    private SingletonSource(){
        celebrities = new ArrayList<>();
        fans = new ArrayList<>();
    }

    public static SingletonSource getInstance() {
        return data;
    }

    public void addCeleb(Celebrity c){
        System.out.println("Celebrity added");
        celebrities.add(c);
    }

    public void addFan(Fan f){
        System.out.println("Fan added");
        fans.add(f);
    }

    public List<Celebrity> getCelebrities() {
        return celebrities;
    }

    public List<Fan> getFans() {
        return fans;
    }
}
