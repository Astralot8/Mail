import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    public static final String AUSTIN_POWERS = "Austin Powers";
    private final Logger logger;


    public Spy(Logger log) {
        this.logger = log;
    }


    @Override
    public Sendable processMail(Sendable mail) {
        String message;
        String to;
        String from;
        if (mail instanceof MailMessage){
            MailMessage mailMessage = (MailMessage) mail;
            to = mailMessage.getTo();
            from = mailMessage.getFrom();
            if (AUSTIN_POWERS.equals(to) | AUSTIN_POWERS.equals(from)){
                message = mailMessage.getMessage();
                logger.log(Level.WARNING,
                        "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[]{from, to, message});

            }else logger.log(Level.INFO,"Usual correspondence: from {0} to {1}",new Object[]{from, to});
        }
        return mail;
    }
}
