//==============================================================================
//  HEIA-FR / Jacques Bapst
//==============================================================================
package s13;

public class Account {

  public int dollars;

  public Account(int money) {
    dollars = money;
  }

  public Account() {
    this(0);
  }

  public int consult() {
    return dollars;
  }

  public void deposit(int x) {
    dollars += x;
  }

  public void withdraw(int x) {
    dollars -= x;
  }

  public void moveTo(Account dest) {
    dest.dollars += dollars;
    dollars = 0;
  }
}

