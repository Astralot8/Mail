public class UntrustworthyMailWorker implements MailService {
    private final MailService[] workers;
    private final RealMailService realMailWorker;

    public UntrustworthyMailWorker(MailService[] workers) {
        this.workers = workers;
        this.realMailWorker = new RealMailService();
    }

    public MailService getRealMailService() {
        return realMailWorker;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable buff = null;
        for (int i = 0; i < this.workers.length; i++) {
            buff = this.workers[i].processMail(buff);
        }
        return getRealMailService().processMail(buff);
    }
}
