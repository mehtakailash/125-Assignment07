package app;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.scg.SCGDriver;
import com.scg.domain.ClientAccount;
//import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
 * Initialize client list files.
 */
public final class InitLists {
    /** This class' logger. */
    private static final Logger log = Logger.getLogger("InitLists");
    /**
     * Prevent instantiation.
     */
    private InitLists() {
    }

    /**
     * Serialize the client, consultant and time card lists.
     *
     * @param accounts the account list to serialize
     * @param timeCards the time card list to serialize
     */
//    private static void serializeLists(final List<ClientAccount> accounts,
//                                       final List<TimeCard> timeCards) {
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream(new FileOutputStream("ClientList.ser"));
//            out.writeObject(accounts);
//            out.close();
//
//            out = new ObjectOutputStream(new FileOutputStream("TimeCardList.ser"));
//            out.writeObject(timeCards);
//            out.close();
//
//        } catch (final IOException e) {
//            log.log(Level.SEVERE, "Serialization of lists failed.", e);
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//            } catch (final IOException ex) {
//                log.log(Level.SEVERE, "Unable to close file.", ex);
//            }
//        }
//    }

    /**
     * InitLists application method.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
    	
    	// Create list of client accounts and a list of time cards
    	SCGDriver           driver          = new SCGDriver();
    	List<TimeCard>      timeCardList    = driver.getTimeCards();
    	List<ClientAccount> clientList      = driver.getClientAccounts();
    
    	
        // Print them
        for (TimeCard timeCard : timeCardList) {
            System.out.println(timeCard.toString());
        }
        
        // Serialize the lists
//        serializeLists(clientList, timeCardList);
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("ClientList.ser"));
            out.writeObject(clientList);
            out.close();

            out = new ObjectOutputStream(new FileOutputStream("TimeCardList.ser"));
            out.writeObject(timeCardList);
            out.close();

        } catch (final IOException e) {
            log.log(Level.SEVERE, "Serialization of lists failed.", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (final IOException ex) {
                log.log(Level.SEVERE, "Unable to close file.", ex);
            }
        }
    }
}