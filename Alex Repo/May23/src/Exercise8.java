public class Exercise8 {
    public static void main(String[] args) {
        SalariedEmployee se = new SalariedEmployee(4800.00);
        HourlyEmployee he = new HourlyEmployee(28.0, 145);

        System.out.println(se.calculateSalary());
        System.out.println(he.calculateSalary());
    }
}
