package observer.design.pattern.Interface;

import observer.design.pattern.Modal.Fan;

public interface IObservable {

    boolean register(Fan observer);
    boolean remove(Fan observer);
    boolean notifyAllObservers();
}
