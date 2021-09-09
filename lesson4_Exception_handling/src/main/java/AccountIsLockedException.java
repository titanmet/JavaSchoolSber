public class AccountIsLockedException extends Exception {
    AccountIsLockedException(long startTime){
        long waitingTime = (10000 - (System.currentTimeMillis()-startTime))/1000;
        TerminalImpl.waiting(waitingTime);
    }
}
