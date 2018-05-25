package Core.Storage;

import Core.Logic.Car;
import Core.Logic.Hitchhiker;
import Core.Logic.Ride;
import Core.Logic.RideDriver;
import org.bson.Document;

import java.util.Arrays;

public class RideToDocumentAdapter extends ObjectToDocumentAdapter {
    private Ride r;

    public RideToDocumentAdapter(Ride r) {
        super(r);
    }

    @Override
    public Document adaptToDocument() {
        Document carDoc = carToDocumentAdapter(r.getTheCar());
        Document rideDriverDoc = rideDriverToDocumentAdapter(r.getRideDriver());
        Hitchhiker hitchhikers[] = r.getHitchhikers().
                toArray(new Hitchhiker[0]);

        return new Document("rideID", r.getRideID()).
                append("destination", r.getDestination()).
                append("source", r.getSource()).
                append("pricePerHitchhiker", r.getPricePerHitchhiker()).
                append("theCar", carDoc).
                append("rideDriver", rideDriverDoc).
                append("hitchhikers", hitchhikers).
                append("moneySavedFromRide", r.getMoneySavedFromRide()).
                append("executed", r.isExecuted());
    }

    private Document carToDocumentAdapter(Car c) {
        return new Document("model", c.getModel()).
                append("color", c.getColor()).
                append("numOfSeatsAvailable", c.getNumOfSeatsAvailable()).
                append("gasolineConsumptionPerKM",
                        c.getGasolineConsumptionPerKM()).
                append("registrationPlate", c.getRegistrationPlate());
    }


    private Document rideDriverToDocumentAdapter(RideDriver rd) {
        return new Document("numOfRidesAsDriver", rd.getNumOfRidesAsDriver()).
                append("totalMoneySaved", rd.getTotalMoneySaved());
    }

    private Document hitchikerToDocument(Hitchhiker h) {
        return new Document("totalMoneySpent", h.getTotalMoneySpent()).
                append("numRidesAsHitchhiker", h.getNumRidesAsHitchhiker());
    }
}
