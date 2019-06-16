package observer.design.pattern.Interface;


import observer.design.pattern.Modal.Celebrity;

public interface IObserver {
    void update(Celebrity o, Object arg);
}
