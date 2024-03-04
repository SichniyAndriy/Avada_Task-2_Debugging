package main.java;

import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {

        Salary salary = new Salary();
        salary.setAmount(-15.0f);
        float hours = 161.5f;

        float totalWage = calculatePayment(salary.getAmount(), hours, (s, h) -> s * h);
        System.out.printf("Учтенное время работы: %s ч.%n", hours);
        System.out.printf("Общая выплата составляет: %s %s%n", totalWage, salary.getCurrencyName());
    }

    protected static float calculatePayment(float salary, float hours, BiFunction<Float, Float, Float> calculator) {

        final float MAX_HOURS_PER_MONTH = 672f;

        if (hours >= MAX_HOURS_PER_MONTH) {
            throw new IllegalArgumentException("Превышено максимальное количество часов за месяц");
        }
        return calculator.apply(salary, hours);
    }

    private static class Salary {
        private Float amount;

        public String getCurrencyName() {
            return "USD";
        }

        public Float getAmount() {
            return amount;
        }

        public void setAmount(Float amount) {
            this.amount = amount;
        }
    }

}
