package Core.Logic;

public interface RideStatusObservable {

    void addListener(RideStatusObserver rideStatusObserver);

    void removeListener(RideStatusObserver rideStatusObserver);
}
