import java.util.Scanner;


public class Main {

    private static final ConfigReader config = new ConfigReader();

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        EventTicketConfig eventTicketConfig = new EventTicketConfig();
        System.out.printf("%s: ", config.getLabel("LBL016"));
        while(true){
            String userInput = scan.next();
            if(userInput.equalsIgnoreCase("y")){
                eventTicketConfig = eventTicketConfig.loadData();
                break;
            } else if (userInput.equalsIgnoreCase("n")) {
                ticketInputValidator(eventTicketConfig);
                eventTicketConfig.saveData();
                break;
            }else{
                System.out.printf("%s, %s: ", config.getLabel("LBL001"), config.getLabel("LBL017"));
            }
        }
        System.out.println(eventTicketConfig.toString());
    }

    public static void ticketInputValidator(EventTicketConfig eventConfig){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%s : ", config.getLabel("LBL012.Text"));
        eventConfig.setTotalTickets(getIntInput(Integer.parseInt(config.getLabel("LBL012.Id")), scanner));
        System.out.printf("%s : ", config.getLabel("LBL013.Text"));
        eventConfig.setReleaseRate(getIntInput(Integer.parseInt(config.getLabel("LBL013.Id")), scanner));
        System.out.printf("%s : ", config.getLabel("LBL014.Text"));
        eventConfig.setRetrievalRate(getIntInput(Integer.parseInt(config.getLabel("LBL014.Id")), scanner));
        System.out.printf("%s : ", config.getLabel("LBL015.Text"));
        eventConfig.setTicketCapacity(getIntInput(scanner, eventConfig.getTotalTickets()));
    }

    public static int getIntInput(int id, Scanner scan){
        String stringInputErrorMsg;
        String intInputErrorMsg;
        boolean flag = true;
        String userInput = null;
        if(id == 1){
            stringInputErrorMsg = config.getLabel("LBL003");
            intInputErrorMsg = config.getLabel("LBL004");
        } else if (id == 2) {
            stringInputErrorMsg = config.getLabel("LBL005");
            intInputErrorMsg = config.getLabel("LBL006");
        }else{
            stringInputErrorMsg = config.getLabel("LBL007");
            intInputErrorMsg = config.getLabel("LBL008");
        }
        while(flag){
            try{
                userInput = scan.next();
                if(Integer.parseInt(userInput) <= 0){
                    System.out.printf("%s, %s : ", config.getLabel("LBL001"), intInputErrorMsg);
                    continue;
                }
            }catch(Exception e){
                System.out.printf("%s, %s %s: ", config.getLabel("LBL001"), config.getLabel("LBL002"), stringInputErrorMsg);
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

        stringInputErrorMsg = config.getLabel("LBL009");
        intInputErrorMsg = config.getLabel("LBL010");
        intLowerValueErrorMsg = config.getLabel("LBL011");

        while (flag) {
            try {
                userInput = scan.next();
                if (Integer.parseInt(userInput) <= 0) {
                    System.out.printf("%s, %s : ", config.getLabel("LBL001"), intInputErrorMsg);
                    continue;
                }
                if (Integer.parseInt(userInput) > capacity) {
                    System.out.printf("%s, %s : ", config.getLabel("LBL001"), intLowerValueErrorMsg);
                    continue;
                }
            } catch (Exception e) {
                System.out.printf("%s, %s %s: ", config.getLabel("LBL001"), config.getLabel("LBL002"), stringInputErrorMsg);
                continue;
            }
            flag = false;
        }
        return Integer.parseInt(userInput);
    }


}