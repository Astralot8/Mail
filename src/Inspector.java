class IllegalPackageException extends RuntimeException {
    public IllegalPackageException() {
    }
}

class StolenPackageException extends RuntimeException {
    public StolenPackageException() {
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
            if (((MailPackage) mail).getContent().getContent().contains(WEAPONS)) {
                throw new IllegalPackageException();
            }
            if (((MailPackage) mail).getContent().getContent().contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            }
            if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
//    public Sendable processMail(Sendable mail) {
//        if (mail instanceof MailPackage) {
//            Package pack = ((MailPackage) mail).getContent();
//            String contend = pack.getContent();
//            if (contend.indexOf("stones instead of ") == 0) {
//                throw new StolenPackageException();
//            } else if (contend.equals(WEAPONS) || contend.equals(BANNED_SUBSTANCE)) {
//                throw new IllegalPackageException();
//            }
//        }
//        return mail;
//    }
}

