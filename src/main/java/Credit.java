
import java.util.Objects;
import java.util.UUID;


public class Credit {
    private String id = UUID.randomUUID().toString();
    private Smart smart;
    private Customer customer;

    public Credit(Smart smart, Customer customer) {
        this.smart = smart;
        this.customer = customer;

    }

    public Smart getSmart() {
        return smart;
    }


    public void setSmart(Smart smart) {
        this.smart = smart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return   id.equals(credit.id) && smart.equals(credit.smart) && customer.equals(credit.customer);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id:'" + id + '\'' +
                "\n Smart: " + smart.getBrand() +
                "," + smart.getModel() +

                "\n Customer: " + customer.getSurname() +
                " " + customer.getName() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, smart, customer);
    }



    public static class CreditBuilder{

        private String id = UUID.randomUUID().toString();
        private Smart smart;
        private Customer customer;
        private double cost;
        private int hour;
        private boolean permission;

        public Credit.CreditBuilder smart(Smart smart){
            this.smart=smart;
            return this;
        }
        public Credit.CreditBuilder customer(Customer customer){
                  this.customer=customer;
                  return this;
        }


        public Credit build(){
            return new Credit(smart,customer);
        }

    }
}
