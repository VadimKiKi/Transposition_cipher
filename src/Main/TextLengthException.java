package Main;

/**
 * Класс Ошибка длины слова наследуемый от базового класса Ошибка
 */
public class TextLengthException extends Exception{

    /**
     * Конструктор
     * @param message сообщение об ошибке, выводимое при ошибке
     */
    public TextLengthException(String message) {
        super(message);
    }
}
