import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Transation
{
    private final Date date;
    private String type;
    private double amount;
    private double balance;
    private final String description;

    public Transation()
    {
        date = new Date();
        description = "";
    }

    public Transation(String type, double amount, double balance, String description)
    {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance =  balance;
        this.description = description;
    }

    public String toString()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return "Тип операции" + type + " : " + description + amount + " Баланс: " + balance + " Время транзакции: " + dateFormat.format(date);
    }
}