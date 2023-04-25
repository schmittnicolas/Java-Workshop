package fr.epita.assistants.observer;

import java.util.HashSet;
import java.util.Set;

public class Swimmer implements Observable<Swimmer>{
    public Set<Observer<Swimmer>> observers;
    private String name;

    private SwimmerStatus status;

    public Swimmer(String name){
        this.name = name;
        this.status = SwimmerStatus.OK;
        observers = new HashSet<>();
        System.out.println(name + " goes into the sea.");
    }

    public String getName() {
        return name;
    }

    public SwimmerStatus getStatus() {
        return status;
    }

    public void setStatus(SwimmerStatus status) {
        this.status = status;
        if (status == SwimmerStatus.DROWNING){
            System.out.println(name + ": I'm drowning, help!!");
        }
        this.fire(this);
    }

    @Override
    public Set<Observer<Swimmer>> getObservers() {
        return observers;
    }

    @Override
    public void register(Observer<Swimmer>... observers) {
        for (Observer<Swimmer> observer : observers) {
            this.observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer<Swimmer> observer) {
        this.observers.remove(observer);
    }

    @Override
    public void fire(Swimmer event) {
        for (Observer<Swimmer> observer : this.observers) {
            observer.onEvent(event);
        }
    }
}
