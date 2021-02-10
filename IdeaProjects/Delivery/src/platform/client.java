package platform;

public class client extends user {

    int clientId; // this is the id with which we will identify clients


    public client(int id, String name, String password, int clientId) {
        super(id, name, password, 2);
        this.clientId = clientId;
    }
}
