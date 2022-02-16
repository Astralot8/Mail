import java.util.logging.Level;
import java.util.logging.Logger;

//public class Spy implements MailService {
//    public static final String AUSTIN_POWERS = "Austin Powers";
//    private final Logger logger;
//
//
//    public Spy(Logger log) {
//        this.logger = log;
//    }
//
//
//    @Override
//    public Sendable processMail(Sendable mail) {
//        logger.setLevel(Level.ALL);
//        if (mail.getFrom() == AUSTIN_POWERS) {
//            logger.log(Level.WARNING, "Detected target mail correspondence: from" + mail.getFrom() + " to" + mail.getTo());
//        } else {
//            logger.log(Level.INFO, "Usual correspondence: from" + mail.getFrom() + " to" + mail.getTo());
//        }
//        return mail;
//    }
//}
