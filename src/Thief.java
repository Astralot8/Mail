public class Thief implements MailService {
    private static int StolenValue;
    private static int MinValue;

    public Thief(int m) {
        this.MinValue = m;
    }

    public int getStolenValue() {
        return StolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            mail = (Sendable) new Package("stones instead of " + ((MailPackage) mail).getContent(), 0);
            StolenValue++;
        }
        return mail;
    }
}