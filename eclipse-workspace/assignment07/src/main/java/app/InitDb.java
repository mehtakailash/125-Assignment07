package app;

import java.util.List;
import com.scg.SCGDriver;
import com.scg.domain.ClientAccount;
import com.scg.domain.TimeCard;
import com.scg.persistent.DbServer;

/**
* Class to The initialize/populate the database.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-06-01 
*/
public final class InitDb {
    /** The database URL. */
    private static final String DB_URL = "jdbc:derby://localhost:1527/memory:scgDb";

    /** The database account name. */
    private static final String DB_ACCOUNT = "student";

    /** The database account password. */
    private static final String DB_PASSWORD = "student";

    /**
     * Prevent instantiation.
     */
    private InitDb() {
    }

    /**
     * Entry point.
     *
     * @param args not used.
     *
     * @throws Exception if anything goes awry
     */
    public static void main(final String[] args) throws Exception {
//        final List<ClientAccount> accounts = new ArrayList<ClientAccount>();
//        final List<Consultant> consultants = new ArrayList<Consultant>();
//        final List<TimeCard> timeCards = new ArrayList<TimeCard>();
//        ListFactory.populateLists(accounts, consultants, timeCards);
     // Create list of client accounts and a list of time cards
    	SCGDriver           driver          = new SCGDriver();
    	List<TimeCard>      timeCards    = driver.getTimeCards();
    	List<ClientAccount> accounts      = driver.getClientAccounts();

//    	Class.forName("com.mysql.jdbc.Driver").newInstance();

        final  DbServer db = new DbServer(DB_URL,
                                          DB_ACCOUNT, DB_PASSWORD);

        for (final ClientAccount client : accounts) {
            db.addClient(client);
        }

//        for (final Consultant consultant : consultants) {
//            db.addConsultant(consultant);
//        }

        for (final TimeCard timeCard : timeCards) {
            db.addTimeCard(timeCard);
        }
        
        // Print them
        for (TimeCard timeCard : timeCards) {
            System.out.println(timeCard.toString());
        }
    }
}
