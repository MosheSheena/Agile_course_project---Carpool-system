package Core.Logic;

public interface RideStatusObserver {

    void onJoinRideAction();

    void onLeaveRideAction();

    void onCancelRideAction();

    void onExecuteRideAction();
}
