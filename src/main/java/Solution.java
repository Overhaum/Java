
import javax.validation.ValidationException;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Solution implements Serializable {

    public static List<Smart> sortByStreamPrice(List<Smart> smart) {
        return smart.stream().sorted((c1, c2) -> (int) c1.getPrice() - (int) c2.getPrice()).collect(Collectors.toList());

    }

    // smart with Battery < 6000;
    public static List<Smart> filterBatterySmart(List<Smart> smart) {
        return smart.stream().filter(smart1 -> smart1.getBattery() < 6000).collect(Collectors.toList());
    }

    // Customer  who are 18 years old

    public static List<Customer> filterAdultsCustomer(List<Customer> customers) {
        LocalDate date = LocalDate.now();

        return customers.stream().filter(customer -> ChronoUnit.DAYS.between(date, customer.getBirth()) * (-1) > 6570)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ValidationException {


         Smart Samsung = new Smart.SmartBuilder()
                .brand("Samsung")
                .model("S22_Ultra")
                .OS("Android")
                .RAM(8)
                .ROM(512)
                .Battery(5000)
                .price(100000)
                .build();

        Smart Iphone = new Smart.SmartBuilder()
                .brand("Iphone")
                .model("14_ProMax")
                .OS("IOS")
                .RAM(8)
                .ROM(1024)
                .Battery(240540)
                .price(4000)
                .build();

        TreeSet<Smart> smartsSortForPrice = new TreeSet<Smart>();
        smartsSortForPrice.add(Samsung);
        smartsSortForPrice.add(Iphone);

        System.out.println("List of smarts sorted by price ");
        smartsSortForPrice.forEach(System.out::println);
        System.out.println("\n");

        ArrayList<Smart> smartsSortFotBattery = new ArrayList<>();

        smartsSortFotBattery .add(Samsung);
        smartsSortFotBattery .add(Iphone);

        System.out.println("List of smarts sorted by Battery ");
        smartsSortFotBattery .forEach(System.out::println);
        System.out.println("\n");


        System.out.println("Sort by stream  Battery");
        List<Smart> smartsList = new ArrayList<>();
        smartsList.add(Samsung);
        smartsList.add(Iphone);

        System.out.println("\n Smart with Battery < 6000");
        filterBatterySmart(smartsList).forEach(System.out::println);

        Customer OleksandrSanduliak = new Customer.CustomerBuilder()
                .name("Oleksandr")
                .surname("Sanduliak")
                .email("overhaum@gmail.com")
                .telephoneNumber("+380950393398")
                .birth(LocalDate.of(2002, 5, 29))
                .build();

        Customer MaksMelnichuk = new Customer.CustomerBuilder()
                .name("Maks")
                .surname("Melnichuk")
                .email("maksimko1610@gmail.com")
                .telephoneNumber("+38095767666")
                .birth(LocalDate.of(2002, 10, 16))
                .build();


        System.out.println("Filter by birthday");
        List<Customer> customers = new ArrayList<>();
        customers.add(OleksandrSanduliak);
        customers.add(MaksMelnichuk);
        filterAdultsCustomer(customers).forEach(System.out::println);
        System.out.println("\n Order");
        Credit order = new Credit.CreditBuilder().smart(Iphone).customer(MaksMelnichuk).build();
        System.out.println(order.toString());




    }


}
