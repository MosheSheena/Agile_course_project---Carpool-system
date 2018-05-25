package Core.Logic;

public class LogicFacade {

    private static LogicFacade ourInstance = new LogicFacade();

    public static LogicFacade getInstance() {
        return ourInstance;
    }

    private LogicFacade() {}


}
