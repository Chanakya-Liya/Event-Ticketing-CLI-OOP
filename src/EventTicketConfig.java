public class EventTicketConfig {
    private int totalTickets;
    private int releaseRate;
    private int retrievalRate;
    private int ticketCapacity;

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
        return String.format("Total Tickets: %d,\n Release Rate: %d,\n Retrieval Rate: %d,\n Ticket Capacity: %d \n", totalTickets, releaseRate, retrievalRate, ticketCapacity);
    }
}
