package platform;

import java.util.Date;

public class shipment {

    int id;
    int purchaseId;
    Date departure;
    Date arrival;
    int boxId;
    int botId;
    int clientId;
    String status;      // Preparing, Departed, Cancelled, Completed.

    public shipment(int id, int purchaseId, Date departure, Date arrival, int boxId, int botId, int clientId, String status) {
        this.id = id;
        this.purchaseId = purchaseId;
        this.departure = departure;
        this.arrival = arrival;
        this.boxId = boxId;
        this.botId = botId;
        this.clientId = clientId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public int getBotId() {
        return botId;
    }

    public void setBotId(int botId) {
        this.botId = botId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "shipment{" +
                "id=" + id +
                ", purchaseId=" + purchaseId +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", boxId=" + boxId +
                ", botId=" + botId +
                ", clientId=" + clientId +
                ", status='" + status + '\'' +
                '}';
    }
}
