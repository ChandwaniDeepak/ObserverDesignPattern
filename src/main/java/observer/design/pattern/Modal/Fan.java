package observer.design.pattern.Modal;

import observer.design.pattern.Interface.IObservable;
import observer.design.pattern.Interface.IObserver;

import java.util.Observable;
import java.util.Observer;

public class Fan implements IObserver {

    private String fName;
    private String lName;

    public Fan() {
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

    public void update(Celebrity c, Object arg) {
        System.out.println("..........................................");
        System.out.println("New Message "+arg+" by "+c.getfName()+" "+c.getlName());
        System.out.println("..........................................");
    }

    @Override
    public String toString() {
        return "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
