class IllegalPackageException extends RuntimeException {

    public IllegalPackageException() {
    }

    public IllegalPackageException(String massage) {
    }


}

class StolenPackageException extends RuntimeException {
    public StolenPackageException() {
    }

    public StolenPackageException(String massage) {
    }
}

public class Inspector implements MailService {
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public Inspector() {

    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {

            if (.getContent().getContent().contains(WEAPONS)) {
                throw new IllegalPackageException();

            }

            if (.getContent().getContent().contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if (.getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}

