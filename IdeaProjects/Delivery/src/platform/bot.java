package platform;

public class bot extends user {

    int idBot;
    int address;

    public bot(int id, String name, String password, int type, int idBot, int address) {
        super(id, name, password, type);
        this.idBot = idBot;
        this.address = address;
    }

    public int getIdBot() {
        return idBot;
    }

    public void setIdBot(int idBot) {
        this.idBot = idBot;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "bot{" +
                "idBot=" + idBot +
                ", address=" + address +
                ", id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", type=" + type +
                '}';
    }
}
