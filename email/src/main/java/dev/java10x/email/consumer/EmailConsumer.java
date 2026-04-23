package dev.java10x.email.consumer;


import dev.java10x.email.dto.EmailDTO;
import org.hibernate.annotations.Comment;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue") // essa annotation pega a fila e fica escutando
    public void ListenEmailQueue(@Payload String string) {
        //@payload quer dizer que esse parametro do metodo vai receber o conteudo principal da mensagem
        //converte automaticamente de json para java
        System.out.println("Received: " + string);

    }
}
