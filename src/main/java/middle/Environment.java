package middle;

import java.util.List;
import java.util.Map;

public class Environment {
    private String eName;
    private String casinoName;
    private String pasAddress;
    private String oapiAddress;
    private int port;
    private List<User> users;

    public Environment(String eName) {
        this.eName = eName;
    }

    public Environment(Map<String, String> eDetails) {
        this.eName = eDetails.get("name");
        this.casinoName = eDetails.get("casinoName");
        this.oapiAddress = eDetails.get("address");
        this.pasAddress = eDetails.get("pasAddress");
        this.port = Integer.parseInt(eDetails.get("port"));
    }

    public Environment(String eName, String casinoName, String pasAddress, String oapiAddress, int port) {
        this.eName = eName;
        this.casinoName = casinoName;
        this.pasAddress = pasAddress;
        this.oapiAddress = oapiAddress;
        this.port = port;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
