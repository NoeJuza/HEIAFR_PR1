//==============================================================================
//  HEIA-FR
//==============================================================================
package s13;

public class AccountDemo {

  public static void main(String[] args) {

    Account a = new Account(10);
    Account b = new Account(20);
    Account c = new Account(5);

    b.deposit(20);
    a.withdraw(2);
    a.moveTo(b);
    c.moveTo(c);

    System.out.println(a.consult()+","+
                       b.consult()+","+
                       c.consult()    );
  }
}
