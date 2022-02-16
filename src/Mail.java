import java.util.logging.Level;
import java.util.logging.Logger;

public class Mail {
    /*
Интерфейс: сущность, которую можно отправить по почте.
У такой сущности можно получить от кого и кому направляется письмо.
*/
    public interface Sendable {
        String getFrom();

        String getTo();
    }

    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    public static class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {

        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {
        private final String message;
        public static final String AUSTIN_POWERS = "Austin Powers";

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }
    }

    public static class Spy implements MailService {
        public static final String AUSTIN_POWERS = "Austin Powers";
        private final Logger logger;


        public Spy(Logger log) {
            this.logger = log;
        }


        @Override
        public Sendable processMail(Sendable mail) {
            logger.setLevel(Level.ALL);
            if (mail.getFrom() == AUSTIN_POWERS) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from" + mail.getFrom() + " to" + mail.getTo());
            } else {
                logger.log(Level.INFO, "Usual correspondence: from" + mail.getFrom() + " to" + mail.getTo());
            }
            return mail;
        }
    }

    class IllegalPackageException extends RuntimeException {

        public IllegalPackageException() {
        }
    }

    class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }
    }

    public static class Inspector implements MailService {
        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";

        public Inspector() {

        }

        @Override
        public Sendable processMail(Sendable mail) {
            try {
                if (processMail(mail) instanceof MailPackage) {
                    processMail(mail);
                }
            } catch (IllegalPackageException i) {
                if (mail.toString().contains(BANNED_SUBSTANCE)) {
                    throw i;
                }
                if (mail.toString().contains(WEAPONS)) {
                    throw i;
                }
            } catch (StolenPackageException s) {
                if (mail.toString().contains("stones")) {
                    throw s;
                }
            } finally {
                try {
                    if (processMail(mail) instanceof MailMessage) {
                            processMail(mail);
                    }
                } catch (IllegalPackageException ignored) {

                }

            }
            return mail;
        }
    }


    public static class UntrustworthyMailWorker implements MailService {
        private static MailService[] workers;
        private static RealMailService realWorker = new RealMailService();

        public UntrustworthyMailWorker(MailService[] w) {
            this.getRealMailService() =;
        }

        public MailService getRealMailService() {
            return realWorker;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            // your code here...
        }
    }

    public static class Thief implements MailService {
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
            if (processMail(mail) instanceof MailPackage) {

            }
            StolenValue++;
            return processMail((Sendable) new Package("stones instread of {contend}", 0));
        }
    }

}


