import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);

        //Запрашиваем количество людей и помещаем в calculator.numberOfPeople.
        System.out.print("На сколько человек разделить счет? ");
        getNumberOfPeople(calculator, sc);

        //Выполняем основной цикл пока isExit() == false
        do {
            System.out.println("Введите название нового товара:");
            addNewProductName(calculator, sc);
            System.out.println("Введите цену товара в формате \"рубли,копейки\"");
            addNewProductPrice(calculator, sc);
            System.out.printf("Вы добавили товар: %s с ценой %.2f %s\n", calculator.currentProduct, calculator.currentPrice, wordRoubleEnding(calculator.currentPrice));
        } while (!isExit(sc));

        //Выводим результат
        printResult(calculator);
    }

    //Метод getNumberOfPeople() запрашивает ввод с консоли значения и помещает его в calculator.numberOfPeople,
    // если значение меньше 1 или не является целым числом, то запрашивает повторно.
    public static void getNumberOfPeople(Calculator calculator, Scanner sc) {
        do {
            System.out.println("Введите целое число больше 1.");
            while (!sc.hasNextInt()) {
                System.out.println("Введите целое число!");
                sc.next();
            }
            calculator.numberOfPeople = sc.nextInt();
        } while (calculator.numberOfPeople <= 1);
    }

    // Метод addNewProductName() запрашивает ввод названия товара и добавляет его в калькулятор
    public static void addNewProductName(Calculator calculator, Scanner sc) {
        //Запрашиваем название товара "
        calculator.currentProduct = sc.next();
        //Добавляем название товара в калькулятор
        calculator.addProductName(calculator.currentProduct + "\n");
    }

    //Метод addNewProductPrice() запрашивает цену товара и добавляет ее в калькулятор.
    public static void addNewProductPrice(Calculator calculator, Scanner sc) {
        //Запрашиваем цену товара в нужном формате, если формат неверный - выводим ошибку и запрашиваем повторно.
        while (!sc.hasNextDouble()) {
            System.out.println("Неверный формат цены!\nВведите цену товара в формате \"рубли,копейки\"");
            sc.next();
        }
        //Если формат цены верный, то присваиваем цену calculator.currentPrice и суммируем в калькуляторе.
        calculator.currentPrice = sc.nextDouble();
        calculator.priceSum(calculator.currentPrice);
    }

    //Метод isExit() возвращает true, если ввели "завершить" иначе возвражает false
    public static boolean isExit(Scanner sc) {
        //Запрашиваем надо ли добавить новый товар или завершить.
        System.out.println("Для добавления нового товара введите любой символ, для завершения введите \"завершить\".");
        //Если ввели "завершить", то возвращаем true иначе возвращаем false
        return sc.next().equalsIgnoreCase("завершить");
    }

    //Метод printResult() выводит список товаров, цену на каждого человека, и слово "рубль" с нужным окончанием
    public static void printResult(Calculator calculator) {
        double pricePerPerson = calculator.allProductPrice / calculator.numberOfPeople;
        System.out.print("Добавленные товары:\n" + calculator.productList);
        System.out.printf("Каждый должен заплатить: %.2f %s.\n", pricePerPerson, wordRoubleEnding(pricePerPerson));
    }

    //Метод wordEnding() возвращает строку с нужным написанием слова "рубль" в зависимости от последних цифр целой части цены.
    public static String wordRoubleEnding(double price) {
        int roundedPrice = (int) Math.floor(price);
        String roubleEnding;
        if (roundedPrice % 100 >= 11 && roundedPrice % 100 <= 14) {
            roubleEnding = "рублей";
        } else {
            switch (roundedPrice % 10) {
                case 1:
                    roubleEnding = "рубль";
                    break;
                case 2:
                case 3:
                case 4:
                    roubleEnding = "рубля";
                    break;
                default:
                    roubleEnding = "рублей";
            }
        }
        return roubleEnding;
    }
}

