#Spring IoC / DI 

#Что такое IoC?
IoC  — это принцип, при котором управление созданием объектов передаётся фреймворку (Spring), а не выполняется вручную в коде.

Без IoC:

BookService bookService = new BookService();

Со Spring:

объекты создаёт контейнер

зависимости связываются автоматически

разработчик просто описывает, что нужно

IoC-контейнер в Spring — это ApplicationContext.

#Что такое DI

DI (Dependency Injection) — это способ реализации IoC.
Это означает, что зависимости передаются классу извне.

 Плохо:

public class LibraryManager {
    private BookService bookService = new BookService();
}

 Правильно :

public class LibraryManager {
    private final BookService bookService;

    public LibraryManager(BookService bookService) {
        this.bookService = bookService;
    }
}

Теперь класс не создаёт зависимость сам — её передаёт Spring.

#Что такое бин?

Бин (Bean) — это объект, который создаётся и управляется Spring.

Бином становится класс, который:

помечен @Component, @Service, @Repository

или создаётся через @Bean в @Configuration

Пример:

@Service
public class CounterService { }

Spring создаёт объект и хранит его в контейнере.

#Singleton vs Prototype

В Spring бин может иметь разную область видимости (scope).

 Singleton 
Создаётся один экземпляр
Используется во всём приложении

Prototype
Новый объект создаётся при каждом запросе

Пример:

@Scope("prototype")
Singleton	Prototype
Один объект	Новый объект каждый раз
#Почему constructor injection лучше field injection

@Autowired
private BookService bookService;

Минусы:
зависимость скрыта
нельзя сделать поле final
сложнее тестировать

 Constructor Injection (рекомендуется)
private final BookService bookService;

public LibraryManager(BookService bookService) {
    this.bookService = bookService;
}

Преимущества:

зависимости видны сразу
можно использовать final
проще писать unit-тесты
объект всегда создаётся корректно

 Итог

IoC — контейнер управляет объектами
DI — зависимости передаются извне
Бин — объект, управляемый Spring
Singleton — один объект
Prototype — новый объект каждый раз
Лучший способ внедрения — через конструктор
