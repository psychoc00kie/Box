package platform;

public class box extends user {

    int boxId;
    int address;
    int owner;

    public box(int id, String name, String password, int type, int boxId, int address, int owner) {
        super(id, name, password, type);
        this.boxId = boxId;
        this.address = address;
        this.owner = owner;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "box{" +
                "boxId=" + boxId +
                ", address=" + address +
                ", owner=" + owner +
                ", id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", type=" + type +
                '}';
    }
}
