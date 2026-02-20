package org.sadovodBase.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final PrinterService printerService;

    public MessageService(PrinterService printerService) {
        this.printerService = printerService;
    }

    @PostConstruct
    public void init() {
        System.out.println("MessageService создан");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("MessageService уничтожается");
    }

    public void sendMessage(String message) {
        printerService.print("Сообщение: " + message);
    }
}