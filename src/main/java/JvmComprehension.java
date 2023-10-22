public class JvmComprehension {
    /*ClassLoaders подсистема загрузки классов. Application ClassLoader загружает классы JvmComprehension, Object.
    Platform ClassLoader загружает классы из сторонних библиотек, которые мы подключили (зависимостей в pom).
    Bootstrap ClassLoader загружает системные классы. Создаётся стековая память (Stack Memory). */

    public static void main(String[] args) { // Создается фрейм main в Stack Memory
        int i = 1;                      // для примитивных переменных прямо на стеке выделяется память, в данном случае для
        // переменной «i» выделилась память и мы указали ей значение равной 1
        Object o = new Object();        // создается объект класса Object в куче и сохраняем/запоминаем ссылку «о»
        // на стеке и ссылаемся на объект, который располагается в куче
        Integer ii = 2;                 // создается объект ii в куче (heap)
        printAll(o, i, ii);             // происходит вызов метода printAll, в момент вызова метода создается новый фрейм на стеке,
        // туда передаем ссылку на объект Object, в этот момент создается новая ссылка на фрейме printAll
        // и указывает она на тот же самый созданный объект, который мы уже создали;
        // также выделяется память для создания нового экземпляра переменной «i» на стеке в фрейме printAll

        System.out.println("finished"); // создается фрейм toString на стеке
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // создается объект userlessVar в куче (heap)
        System.out.println(o.toString() + i + ii);  // создается фрейм toString на стеке
    }

    // cборщик мусора проверяет наличие объектов в куче, которые больше не используются, затем выполняет работу по их удалению.
}
