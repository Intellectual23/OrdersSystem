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
  #### Дополнительно:
  3. После оформления заказа идет 15 секунд его обработки, за которые можно добавить блюда в заказ(Это происходит в потоке). После этого запускается поток готовки заказа, который идет уже столько секунд, сколько в поле `Difficult`.
  4. Сохранение данных опциальное при выходе из программы.
  5. Загрузка данных из файлов опциональна на стартовом меню - 0.
  6. Изначально при инициализации создается 3 пользователя (Admin -> AdminPass, Customer1 ->Pass1, Customer2 ->Pass2) и меню из 3 блюд.
  7. (Забыл про комментарии в самом коде.... но код и интерфейс максимально просты и понятны, + в этом файле все есть.)

### 3. Структура классов

  1. `Main` - создает элемент класса ConsoleApp, и запускает его.
  2. `ConsoleApp` - интерфейс консоли, сначала команды для регистрации/авторизации, после, в зависимости от типа пользователя - админа или клиента - команды для каждого из них.
  3. `AuthenficationManager` - служит для авторизации и регистрации пользователей, пароли хешируются.
  4. `User` - абстрактный класс пользователя системы
  5. `Customer` - Наследник User - класс клиента ресторана, внутри методы для создания, внесения изменений и отмены заказа. А так же оплаты и отзыва.
  6. `Admin` - Наследник User - класс админа ресторана, внутри методы для изменения меню, редактирования блюд и просмотра статистики.
  7. `Dish` - Класс блюда, внутри методы для изменения данных блюда.
  8. `Menu` - Класс меню ресторана, внутри методы для изменения и просмотра меню.
  9. `OrderStatus` - Перечисление состояний заказов, для удобства и читаемости кода.
  10. `Order` - Класс заказа, имеет поле - `Thread`, внутри которого происходит готовка блюда. занимает `difficylty` в секундах времени. Прерывается при отмене.
  11. `OrderManager` - Класс обработчика заказов, отменяет, изменяет и создает заказы. 
  12. `DataStorage` - Что-то типо Базы данных - тут хранится список всех юзеров, заказов, меню - а так же выручка(считается в методе `pay`). Удобно хранить эти параметры глобально
  13. `Review` - Класс отзыва, который оставляется после оплаты, хранится как поле в классе заказа, которое может быть null, если заказ не оценен.

### 4. Использованные Шаблоны:
  1. Синглтон - классы `DataStorage`, `AuthenficationManager` и `OrderManager` реализуют шаблон одиночки.

      Зачем? - Чтобы не запутаться в зависимстях, проще сделать глобальным эти классы, тк мы знаем, что они в одном экземпляре - код стал более читаемым.
     
  2. Фасад - предоставлен простой интерфейс к сложной системе классов, библиотеке или фреймворку в классе `ConsoleApp`.

     Зачем? -  Простой интерфейс консольного приложения получился всего в 80 строк, и сам код выглядит максимально понятно (в отличие от шаблона Команд)

  3. Шаблонный метод — это поведенческий паттерн проектирования, который определяет скелет алгоритма, перекладывая ответственность за некоторые его шаги на другие классы.
 
Зачем? -В данном случае некоторые методы класса `Customer` переброшены на класс `OrderManager`
     Общая структура `Customer` не меняется. +код интуитивнее понятен.(так же и работает `Admin` с `Menu`)
