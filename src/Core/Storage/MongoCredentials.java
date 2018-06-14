package Core.Storage;

public class MongoCredentials {

    private String hostName;
    private Integer portNum;
    private String dbName;

    public MongoCredentials(String hostName, Integer portNum, String dbName) {
        this.hostName = hostName;
        this.portNum = portNum;
        this.dbName = dbName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPortNum() {
        return portNum;
    }

    public void setPortNum(Integer portNum) {
        this.portNum = portNum;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
