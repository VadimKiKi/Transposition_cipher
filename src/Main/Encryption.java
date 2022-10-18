package Main;

/**
 * Класс Шифрование, хранящий необходимые методы для шифрования\дешиврофания текста
 * @author Taratonov Vadim
 * @version 1.0
 */
public class Encryption {

    /**
     * Массив значений ключа K1
     */
    private final int[] K1 = {3, 2, 5, 1, 4};
    /**
     * Массив значений ключа K2
     */
    private final int[] K2 = {3, 5, 2, 1, 4};

    /**
     * Метод проверки длины текста
     * @param text текст для шифрования
     * @throws TextLengthException ошибка длины текста
     * @see TextLengthException
     */
    public void checkLength(String text) throws TextLengthException {
        if (text.length()!=25)
            throw new TextLengthException("Длина не удовлетворяет требуемой!");
    }

    /**
     * Метод создания первоначальной матрицы для зашифровки слова
     * @param text текст для шифрования
     * @return возвращает первоначалльную матрицу слова
     */
    public String[][] createInitialMat(String text){
        String[][] initialMat = new String[K1.length][K2.length];
        int k = 0;
        for (int i = 0; i < initialMat.length; i++) {
            for (int j = 0; j < initialMat[i].length; j++) {
                initialMat[i][j] = String.valueOf(text.charAt(k));
                k++;
            }
        }
        return initialMat;
    }

    /**
     * Метод создания матрицы текста для зашифровывания согласно значениям ключа К1
     * @param initialMat первоначальная матрица для зашифровки текста
     * @return возвращает матрицу текста согласно значениям ключа К1
     * @see Encryption#K1
     */
    public String[][] createNormalMat(String[][] initialMat){
        String[][] normalMat = new String[K1.length][K2.length];
        for (int i = 0; i < normalMat.length; i++) {
            for (int j = 0; j < normalMat[i].length; j++) {
                normalMat[i][j] = initialMat[K1[i] - 1][j];
            }
        }
        return normalMat;
    }

    /**
     * Метод создания матрицы зашифрованного текста по значениям ключа К2
     * @param text зашифрованный текст
     * @return возврщает матрицу зашифрованного текста согласно восстановлению по значениям ключа К2
     * @see Encryption#K2
     */
    public String[][] createEncryptMat(String text){
        String[][] encryptMat = new String[K1.length][K2.length];
        int k = 0;
        for (int i = 0; i < encryptMat.length; i++) {
            for (int j = 0; j < encryptMat[i].length; j++) {
                encryptMat[j][K2[i]-1]=String.valueOf(text.charAt(k));
                k++;
            }
        }
        return encryptMat;
    }

    /**
     * Метод шифрования слова
     * @param text текст для шифрования
     * @return возвращает зашифрованный текст
     */
    public StringBuilder encrypt(String text){
        String[][] initialMat = createInitialMat(text);
        String[][] normalMat = createNormalMat(initialMat);

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < normalMat.length; i++) {
            for (int j = 0; j < normalMat[i].length; j++) {
                code.append(normalMat[j][K2[i] - 1]);
            }
        }
        return code;
    }

    /**
     * Метод поиска индекса элемента в массиве
     * @param a массив для поиска
     * @param target значение для поиска
     * @return возвращает индекс искомого элемента
     */
    public int find(int[] a, int target) {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Метод дешифрования слова
     * @param text текст для дешифрования
     * @return возвращает расшифрованный текст
     */
    public StringBuilder decrypt(String text){
        String[][] encryptMat = createEncryptMat(text);
        StringBuilder code = new StringBuilder();
        int k = 1;
        for (int i = 0; i < encryptMat.length;i++) {
            for (int j = 0; j < encryptMat[i].length; j++) {
                code.append(encryptMat[find(K1,k)][j]);
            }
           k++;
        }
        return code;
    }
}
