import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Account {
    private int id = 0;
    private String name;
    private double balance = 0.0;
    private Date dateCreate;
    private final ArrayList<Transation> transation;

    public Account(){
        this.dateCreate = new Date();
        this.transation = new ArrayList<Transation>();
    };
    public Account(int id,double balance){
        this.id = id;
        this.balance = balance;
        this.transation = new ArrayList<Transation>();
    }

    public Account(int id, double balance, String name){
        this.dateCreate = new Date();
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.transation = new ArrayList<Transation>();
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public Date getDateCreated(){
        return dateCreate;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public ArrayList<Transation> getTransation()
    {
        return transation;
    }

    public void withDraw(double money){
        this.balance -= money;
        Transation tempT = new Transation(" - Списание", money, this.getBalance(), "Списано: ");
        transation.add(tempT);
    }

    public void deposite(double money){
        this.balance += money;
        Transation tempT = new Transation(" - Зачисление", money, this.getBalance(), "Зачислено: ");
        transation.add(tempT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}