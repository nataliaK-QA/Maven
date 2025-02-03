# «Система сборки Maven»

## Цели задания:
- Научиться создавать maven-проекты.
- Научиться писать юнит-тесты с помощью JUnit 5.
- Научиться использовать maven-плагины.
 
## Инструкция к заданию:
Скачайте и установите профессиональный редактор кода Intellij Idea Community Version.
🆕 Откройте IDEA, создайте и настройте новый maven-проект. Под каждую задачу следует создавать отдельный проект, если обратное не сказано в условии.
Создайте пустой репозиторий на GitHub и свяжите его с папкой вашего проекта (не с какой-либо другой папкой).
🆕 Правильно настройте репозиторий в плане .gitignore. Проигнорируйте папки .idea и target (раньше была out) и .iml-файл — их в репозитории быть не должно.
Выполните в IDEA задачу согласно условию.
Проверьте соблюдение правил форматирования кода.
🆕 Убедитесь, что при запуске mvn clean test все тесты запускаются, проходят, а сборка завершается успешно.
Закоммитьте и отправьте в репозиторий содержимое папки проекта.
Материалы, которые пригодятся для выполнения задания
🆕 Как создать maven-проект в IDEA.
Как отформатировать код в Java.

## Задание:
Нашей целью будет переделать проект с приложением про бонус с покупки на Maven и его протестировать.

Шаг 1. Создайте проект на базе Maven.

Шаг 2. Добавьте в проект JUnit Jupiter & Surefire Plugin.

Шаг 3. Создайте сервисный класс со следующим исходным кодом:

public class BonusService {
  public long calculate(long amount, boolean registered) {
    int percent = registered ? 3 : 1;
    long bonus = amount * percent / 100;
    long limit = 500;
    if (bonus > limit) {
      bonus = limit;
    }
    return bonus;
  }
}
Шаг 4. Создайте тестовый класс со следующим исходным кодом:

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

  @Test
  void shouldCalculateForRegisteredAndUnderLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1000;
    boolean registered = true;
    long expected = 30;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000_000;
    boolean registered = true;
    long expected = 500;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }
}
Шаг 5. Запустите тесты через mvn clean test, убедитесь, что они запускаются и проходят.

Шаг 6. Проведите поверхностный тест-дизайн сервисного класса, допишите как минимум два недостающих и прямо напрашивающихся теста.

Шаг 7. Убедитесь, что тесты запускаются и проходят.

## Итого: отправьте на проверку ссылку на репозиторий GitHub с вашим проектом.

