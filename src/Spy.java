import java.util.logging.Logger;

public class Spy implements MailService {
    private final Logger logger;

    public Spy(Logger l) {
        // your code here...
    }

    @Override
    public Sendable processMail(Sendable mail) {
        // your code here...
    }
}
