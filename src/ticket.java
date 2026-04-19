public class ticket {


    //----an entity for tickets all the attributes listed
    private int tickeid;
    private User user ;
    private Train train ;
    private int seatBooked ;
    private static int counter = 1001;

    //in future add price of ticket to
    public ticket(User user, Train train, int seatBooked) {
        this.tickeid = counter++;
        this.user = user;
        this.train = train;
        this.seatBooked = seatBooked;
    }


    public int getTickeid() {
        return tickeid;
    }

    public void setTickeid(int tickeid) {

        this.tickeid = tickeid;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ticket.counter = counter;
    }


    @Override
    public String toString() {
        return "TICKET ID;" + tickeid + "|Train " + train.getName() + "|Route " +train.getSource() + " -> " + train.getDestination() +
                "| Seats " +seatBooked+ "| Booked BY:" +user.getFullname();
    }


}
