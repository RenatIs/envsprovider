package middle;

import java.util.List;
import java.util.Map;

public class Environment {
    private String eName, casinoName, pasAddress, oapiAddress;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
