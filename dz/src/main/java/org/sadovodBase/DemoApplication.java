package org.sadovodBase;
import org.sadovodBase.service.LibraryInfoService;
import org.sadovodBase.service.SessionData;
import org.sadovodBase.manager.LibraryManager;
import org.sadovodBase.service.CounterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final LibraryManager libraryManager;
    private final CounterService counterService;
    private final ApplicationContext applicationContext;
    private final ObjectProvider<SessionData> sessionDataProvider;
    private final LibraryInfoService libraryInfoService;
    private final String applicationName;




    public DemoApplication(LibraryManager libraryManager,
                           CounterService counterService,
                           ObjectProvider<SessionData> sessionDataProvider,
                           ApplicationContext applicationContext,
                           LibraryInfoService libraryInfoService, String applicationName) {
        this.libraryManager = libraryManager;
        this.counterService = counterService;
        this.sessionDataProvider = sessionDataProvider;
        this.applicationContext = applicationContext;
        this.libraryInfoService = libraryInfoService;
        this.applicationName = applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("Добавляем 3 книги");
        libraryManager.seedThreeBooks();
        libraryManager.printAll();

        System.out.println("\n Проверка CounterService");

        System.out.println("DemoApplication counter: " + counterService.increment());
        libraryManager.showCounterFromManager();
        System.out.println("DemoApplication counter again: " + counterService.increment());

        SessionData s1 = sessionDataProvider.getObject();
        SessionData s2 = sessionDataProvider.getObject();

        System.out.println("Session1: " + s1.getSessionId());
        System.out.println("Session2: " + s2.getSessionId());
        SessionData c1 = applicationContext.getBean(SessionData.class);
        SessionData c2 = applicationContext.getBean(SessionData.class);

        System.out.println("Ctx Session1: " + c1.getSessionId());
        System.out.println("Ctx Session2: " + c2.getSessionId());

        System.out.println("\nВсе бины в контексте ");

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        java.util.Arrays.sort(beanNames);

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println("\nИнформация о библиотеке от application.yml");
        libraryInfoService.printInfo();

        System.out.println("App name: " + applicationName);

    }
}