# OrdersSystem
## КПО 2023-2024 - ДЗ№2
Cистема управления заказами в ресторане


### 1. О программе:

Реализовал консольное приложение, управляющее заказами в ресторане. 
Перечень функций(требований):
  0. ООП и СОЛИД соблюдены.
  1. Аутенфикация - отдельный класс `AuthenficationManager` отвечает за регистрацию и аутенфкацию, причем пароли хешируются.
  2. Использование шаблонов проектирование(см в пункте 3)
  3. Хранение Данных - в Синглтоне `DataStorage` хранятся все основные данные. Благодаря сериализации можно сохранять и загружать эти данные.
  4. Реализация многопоточности для обработки заказов - каждый поток отвечает за свой заказ, запускается, прерывается при отмене и работает параллельно со всеми остальными потоками. Данные хранятся в папке `files`
  5. Codestyle - в соответствии с https://kotlinlang.org/docs/coding-conventions.html#names-for-test-methods.
  6. Интерфейс понятен.
  7. Клиент может опционально оставить оценку и отзыв на товар(оценка от 1 до 5 и текстовый комментарий).
  8. У админа есть возможность посмотреть статистику по отзывам и заказам - Какие блюда сколько раз были заказаны и их средний рейтинг.
  9. (Систему приоритетов не реализовал)

### 2. Инструкция:

  1. Запустить `main.kt`
  2. Следовать понятному интерфейсу консоли!

### Использованные Шаблоны:
  1. Синглтон - классы `DataStorage`, `AuthenficationManager` и `OrderManager` реализуют шаблон одиночки.
      Чтобы не запутаться в зависимстях, проще сделать глобальным эти классы, тк мы знаем, что они в одном экземпляре - код стал более читаемым.
  3. Фасад - предоставлен простой интерфейс к сложной системе классов, библиотеке или фреймворку в классе `ConsoleApp`.
      Простой интерфейс консольного приложения получился всего в 80 строк, и сам код выглядит максимально понятно (в отличие от шаблона Команд)
  5. Шаблонный метод — это поведенческий паттерн проектирования, который определяет скелет алгоритма, перекладывая ответственность за некоторые его шаги на другие классы. В данном случае некоторые методы класса `Customer` переброшены на класс `OrderManager`
     Общая структура `Customer` не меняется. +код интуитивнее понятен.
