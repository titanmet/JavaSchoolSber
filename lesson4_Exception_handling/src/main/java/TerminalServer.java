import java.util.Collection;

public class TerminalServer {
    public static void initAccount(Collection<Account> accounts) {
        accounts.add(new Account(1111,100,"Вася"));
        accounts.add(new Account(2222,200,"Петя"));
        accounts.add(new Account(3333,500,"Коля"));
        accounts.add(new Account(4444,800,"Имануил"));
        accounts.add(new Account(5555,300,"Катя"));
        accounts.add(new Account(6666,500,"Маша"));
        accounts.add(new Account(7777,900,"Аня"));
        accounts.add(new Account(8888,200,"Джон"));
        accounts.add(new Account(9999,400,"Карина"));
    }
}
