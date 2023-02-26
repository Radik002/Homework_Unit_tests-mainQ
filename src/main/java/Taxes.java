import java.util.Scanner;

public class Taxes {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогооблажения");

            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1 -> {
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                }
                case 2 -> {
                    System.out.println("Введите сумму расхода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    spendings += money;
                }
                case 3 -> {
                    int tax15 = taxEarningsMinusSpendings(earnings, spendings);
                    int tax6 = taxEarnings(earnings);
                    earnings = 0;
                    spendings = 0;
                    if (tax15 > tax6) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + tax6 + " рублей");
                        System.out.println("Налог на другой системе: " + tax15 + " рублей");
                        System.out.println("Экономия: " + (tax15 - tax6) + " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + tax15 + " рублей");
                        System.out.println("Налог на другой системе: " + tax6 + " рублей");
                        System.out.println("Экономия: " + (tax6 - tax15) + " рублей");
                    }
                }
                default -> System.out.println("Такой операции нет");
            }

        }

    }
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public boolean notEquals(int a, int b) {
        if (taxEarnings(a) <= taxEarningsMinusSpendings(a, b)) {
            return true;
        } else return false;
    }
}