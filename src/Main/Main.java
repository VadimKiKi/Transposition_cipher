package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        
        //ШИФРОВАНИЕ_ПЕРЕСТАНОВКОЙ_   //исходный текст конкретно на 25 символов
        //ЕНОФАЕЕ_ООПАКИТ_ВВШСРИЙРН   //зашифрованный текст конкретно на 25 символов
        Scanner in = new Scanner(System.in);
        Encryption f = new Encryption();
        //переменная, хранящая текст для шифрования\дешифрования
        String text;
        System.out.print("Введите открытый текст (25 символов) : ");
        //проверка на кореектность ввода входного текста
        try {
            text = in.nextLine();
            f.checkLength(text);
        } catch (TextLengthException e) {
            System.out.println(e.getMessage());
            return;
        }

        //переменная выбора пункта для действий
        int choice;
        System.out.println("Что вы хотите сделать: зашифровать - 1, расшифровать - 2, полный цикл шифрования - 3");
        try {
            choice = in.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Неверный ввод!");
            return;
        }
        switch (choice) {
            case 1 -> {
                StringBuilder code = f.encrypt(text);
                System.out.println("Зашифрованное сообщение: " + code);
            }
            case 2 -> {
                StringBuilder code = f.decrypt(text);
                System.out.println("Расшифрованное сообщение: " + code);
            }
            case 3 -> {
                StringBuilder code = f.encrypt(text);
                System.out.println("Зашифрованное сообщение: " + code);
                StringBuilder code1 = f.decrypt(String.valueOf(code));
                System.out.println("Расшифрованное сообщение: " + code1);
            }
            default -> System.out.println("Неверный выбор пункта!");
        }

    }
}





