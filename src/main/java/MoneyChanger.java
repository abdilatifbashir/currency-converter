public class MoneyChanger {

  public static void main(String[] args) {
    int cents = 393;
    int centsLeft = 0;
    int dollars = 0;
    int quarters = 0;
    int dimes = 0;
    int nickels = 0;
    int pennies = 0;

    dollars = cents/100;
    centsLeft = cents%100;

    quarters = centsLeft/25;
    centsLeft = centsLeft%25;

    dimes = centsLeft/10;
    centsLeft = centsLeft%10;

    nickels = centsLeft/5;
    centsLeft = centsLeft%5;

    
  }
}
