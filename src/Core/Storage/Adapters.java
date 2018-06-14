package Core.Storage;

import Core.Logic.Ride;
import com.google.gson.Gson;
import org.bson.Document;

public class Adapters {

    private static Gson gs = new Gson();

    public static Document userToDocAdapter(User u) {
        return new Document("user", gs.toJson(u));
    }

    public static User docToUserAdapter(Document d) {
        return gs.fromJson(d.get("user").toString(), User.class);
    }

    public static Document rideToDocAdapter(Ride r) {
        return new Document("ride", gs.toJson(r));
    }

    public static String rideToJsonAdapter(Ride r) {
        return gs.toJson(r);
    }

    public static Ride docToRideAdapter(Document d) {
        return gs.fromJson(d.get("ride").toString(), Ride.class);
    }
}
