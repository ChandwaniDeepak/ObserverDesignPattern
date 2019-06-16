package observer.design.pattern.Modal;

import observer.design.pattern.Interface.IObservable;
import observer.design.pattern.Interface.IObserver;

import java.util.ArrayList;
import java.util.List;


public class Celebrity implements IObservable {

    private List<Fan> fans;
    private List<String> messages;

    private String fName;
    private String lName;

    public Celebrity() {
        fans = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessages(String m) {
        messages.add(m);
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public List<Fan> getFans() {
        return fans;
    }

    public boolean register(Fan fan) {
        fans.add(fan);
        return true;
    }

    public boolean remove(Fan fan) {
        fans.remove(fan);
        return true;
    }

    public boolean notifyAllObservers() {
        System.out.println("FansCount -> "+fans.size());
        for(Fan fan: fans){
            System.out.println("-------------------------------");
            System.out.println("Updating fan about New Message to "+fan.getfName()+" "+fan.getlName());
            System.out.println("-------------------------------");
            fan.update(this, getMessages().get(messages.size() - 1));
        }
        return true;
    }

    @Override
    public String toString() {
        return "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
