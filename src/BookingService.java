
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
    private List<Train> trainList = new ArrayList<>();
    private List<ticket> ticketList = new ArrayList<>();

    public BookingService()
    {

        //add date for the same if train is availabe for that particul;ar date or no


        trainList.add(new Train(101,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(102,"Shatabdi Express","Delhi","Mumbai",60));
        trainList.add(new Train(103,"Durunto Express","Agra","Delhi",70));
        trainList.add(new Train(104,"vande Bharat Express","Delhi","Goa",100));
        trainList.add(new Train(105,"Intercity","Kolkata","Manali",90));
        trainList.add(new Train(106,"Tejas Express","Delhi","Bengaluru",80));
    }
    public List<Train> searchTrain(String source , String destination ) {
        List<Train> res = new ArrayList<>();
        for (Train train:trainList) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination) ) {
                res.add(train);
            }
        }
        return res;
    }

    ticket bookTicket(User user, int trainId, int seatCount) {
        for (Train train: trainList) {
            if (train.getTrainId()==trainId) {
                if (train.bookseat(seatCount) ){
                    ticket ticket=new ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }
                else {
                    System.out.println("No enough seats available");
                    return null;
                }
            }
        }
        System.out.println("Train ID not found");
        return null;
    }
    public List<ticket> getTicketByUser(User user)
    {
        List<ticket> res=new ArrayList<>();
        for(ticket ticket:ticketList)
        {
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                res.add(ticket);
            }
        }
        return res;
    }

    public boolean cancelTicket(int ticketId,User user)
    {
        Iterator<ticket> iterator= ticketList.listIterator();
        while(iterator.hasNext())
        {
            ticket ticket=iterator.next();
            if(ticket.getTickeid()==ticketId &&
                    ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                Train train=ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket "+ticketId +" cancelled Successfully");
                return true;
            }
        }

        System.out.println("Ticket not found or does not belong to current user");
        return false;
    }

    public void listAllTrains()
    {
        System.out.println("List of all trains:");
        for(Train train:trainList)
        {
            System.out.println(train);
        }
    }
}
