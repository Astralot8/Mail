class IllegalPackageException extends RuntimeException {
    public IllegalPackageException() {
    }

    public IllegalPackageException (String message) {
    }
}

class StolenPackageException extends RuntimeException {
    public StolenPackageException() {
    }

    public StolenPackageException (String message) {
    }
}

public class Inspector implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // your code here...
    }
}
