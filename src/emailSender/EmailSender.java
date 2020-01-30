package emailSender;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

        //  Создай объект Session вызывая Session.getDefaultInstance(properties),
        //      где properties — содержит все важные свойства, например, имя хоста SMTP сервера.
        //
        //  Создай объект MimeMessage передавая ему объект Session, полученный на предыдущем шаге.
        //      У нас есть набор различных свойств в этом объекте, таких как получатель письма,
        //      тема, тело сообщения, вложения и т.д.
        //
        //  Используй javax.mail.Transport для отправки письма вызывая статический метод send(email),
        //      где email может быть объект MimeMessage.
public class EmailSender {
    public static void main(String[] args) {

        String to = "receive@abc.com";         // sender email
        String from = "sender@abc.com";        // receiver email
        String host = "127.0.0.1";             // mail server host

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);   // default session

        try {
            MimeMessage message = new MimeMessage(session);         // email message

            message.setFrom(new InternetAddress(from));             // setting header fields

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Test Mail from Java Program");      // subject line

            // actual mail body
            message.setText("You can send mail from Java program by using mail API, but you need" +
                    "couple of more JAR files e.g. smtp.jar and activation.jar");

            // Send message
            Transport.send(message);
            System.out.println("Email Sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
