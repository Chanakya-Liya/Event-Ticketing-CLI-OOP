import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EventTicketConfig {
    private int totalTickets;
    private int releaseRate;
    private int retrievalRate;
    private int ticketCapacity;

    private static final ConfigReader config = new ConfigReader();

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    public int getTicketCapacity() {
        return ticketCapacity;
    }

    public void setTicketCapacity(int ticketCapacity) {
        this.ticketCapacity = ticketCapacity;
    }

    public String toString(){
        return String.format("Total Tickets: %d,\nRelease Rate: %d,\nRetrieval Rate: %d,\nTicket Capacity: %d\n", totalTickets, releaseRate, retrievalRate, ticketCapacity);
    }

    public void saveData(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(config.getConfig("JSONFileLocation"))) {
            gson.toJson(this, file);
            System.out.println("Successfully saved the object as JSON to saveFile.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EventTicketConfig loadData() {
        Gson gson = new Gson();
        System.out.println(config.getConfig("JSONFileLocation"));
        try (FileReader reader = new FileReader(config.getConfig("JSONFileLocation"))) {
            return gson.fromJson(reader, EventTicketConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if an error occurs
        }
    }
}
