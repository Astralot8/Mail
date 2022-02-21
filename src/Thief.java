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
            Package pack = ((MailPackage) mail).getContent();
            if (pack.getPrice() >= MinValue) {
                StolenValue = StolenValue + pack.getPrice();
                mail = new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of " + pack.getContent(), 0));
            }
        }
        return mail;
    }
}