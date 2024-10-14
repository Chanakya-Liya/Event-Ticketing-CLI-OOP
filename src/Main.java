import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static final ConfigReader config = new ConfigReader();

    public static void main(String[] args){

        EventTicketConfig eventTicketConfig = new EventTicketConfig();
        ticketInputValidator(eventTicketConfig);

        System.out.println(eventTicketConfig.toString());
        System.out.println(config.getProperty("LBL016"));

    }

    public static void ticketInputValidator(EventTicketConfig eventConfig){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%s : ", config.getProperty("LBL012.Text"));
        eventConfig.setTotalTickets(getIntInput(Integer.parseInt(config.getProperty("LBL012.Id")), scanner));
        System.out.printf("%s : ", config.getProperty("LBL013.Text"));
        eventConfig.setReleaseRate(getIntInput(Integer.parseInt(config.getProperty("LBL013.Id")), scanner));
        System.out.printf("%s : ", config.getProperty("LBL014.Text"));
        eventConfig.setRetrievalRate(getIntInput(Integer.parseInt(config.getProperty("LBL014.Id")), scanner));
        System.out.printf("%s : ", config.getProperty("LBL015.Text"));
        eventConfig.setTicketCapacity(getIntInput(scanner, eventConfig.getTotalTickets()));
    }

    public static int getIntInput(int id, Scanner scan){
        String stringInputErrorMsg;
        String intInputErrorMsg;
        boolean flag = true;
        String userInput = null;
        if(id == 1){
            stringInputErrorMsg = config.getProperty("LBL003");
            intInputErrorMsg = config.getProperty("LBL004");
        } else if (id == 2) {
            stringInputErrorMsg = config.getProperty("LBL005");
            intInputErrorMsg = config.getProperty("LBL006");
        }else{
            stringInputErrorMsg = config.getProperty("LBL007");
            intInputErrorMsg = config.getProperty("LBL008");
        }
        while(flag){
            try{
                userInput = scan.next();
                if(Integer.parseInt(userInput) <= 0){
                    System.out.printf("%s, %s : ", config.getProperty("LBL001"), intInputErrorMsg);
                    continue;
                }
            }catch(Exception e){
                System.out.printf("%s, %s %s: ", config.getProperty("LBL001"), config.getProperty("LBL002"), stringInputErrorMsg);
                continue;
            }
            flag = false;
        }
        return Integer.parseInt(userInput);
    }

    public static int getIntInput(Scanner scan, int capacity) {
        String stringInputErrorMsg;
        String intInputErrorMsg;
        String intLowerValueErrorMsg;
        boolean flag = true;
        String userInput = null;

        stringInputErrorMsg = config.getProperty("LBL009");
        intInputErrorMsg = config.getProperty("LBL010");
        intLowerValueErrorMsg = config.getProperty("LBL011");

        while (flag) {
            try {
                userInput = scan.next();
                if (Integer.parseInt(userInput) <= 0) {
                    System.out.printf("%s, %s : ", config.getProperty("LBL001"), intInputErrorMsg);
                    continue;
                }
                if (Integer.parseInt(userInput) > capacity) {
                    System.out.printf("%s, %s : ", config.getProperty("LBL001"), intLowerValueErrorMsg);
                    continue;
                }
            } catch (Exception e) {
                System.out.printf("%s, %s %s: ", config.getProperty("LBL001"), config.getProperty("LBL002"), stringInputErrorMsg);
                continue;
            }
            flag = false;
        }
        return Integer.parseInt(userInput);
    }
}