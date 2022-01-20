
package corr.s25;
import java.util.Arrays;
import java.util.Random;

public class CharGrid {
  private static final Random RND=new Random();
  private final char[][] grid;
  
  public CharGrid(char[][] grid) {
    int n=grid.length, m=grid[0].length;
    this.grid=new char[n][m];
    for(int i=0; i<n; i++) 
      for(int j=0; j<m; j++)
        this.grid[i][j]=grid[i][j];
  }
  
  public CharGrid(int n, int m) {
    this.grid=new char[n][m];
    for(int i=0; i<n; i++) 
      for(int j=0; j<m; j++)
        this.grid[i][j]=rndChar();
  }
  
  private static char rndChar() {
    int i=RND.nextInt(26);
    return (char)('a'+i);
  }
  
  public boolean isPresent(String word) {
    int n=grid.length, m=grid[0].length;
    for(int i=0; i<n; i++) 
      for(int j=0; j<m; j++)
        if(isPresentFrom(i,j, word)) return true;
    return false;
  }
  
  private boolean isPresentFrom(int i, int j, String word) {
    int[] t={-1,0,+1};
    for(int di:t)
      for(int dj:t) {
        if(di==0 && dj==0) continue;
        if(isHere(i, j, di, dj, word)) return true;
      }
    return false;
  }
  
  private boolean isHere(int i, int j, int di, int dj, String word) {
    int n=grid.length, m=grid[0].length;
    int len=word.length();
    for(int k=0; k<len; k++) {
      if(i<0 || i>=n || j<0 || j>=m) return false;
      if(grid[i][j] != word.charAt(k)) return false;
      i+=di; 
      j+=dj;
    }
    return true;
  }

  public String toString() {
    return Arrays.deepToString(grid);
  }
  
  //------------------------------------------
  // small demo
  public static void main(String... args) {
    char[][] t= {
        {'a', 'b', 'c'},
        {'e', 'f', 'g'}       
    };
    CharGrid g=new CharGrid(t);
    boolean ok=g.isPresent("af") && g.isPresent("gb") &&
               g.isPresent("cf") && g.isPresent("fe") &&
               g.isPresent("ea") && g.isPresent("gfe");
    boolean ko=g.isPresent("ac") || g.isPresent("ca") &&
               g.isPresent("ce") || g.isPresent("aa")||
               g.isPresent("tg") || g.isPresent("fge");
    if(ok && !ko)
      System.out.println("seems to work!");
    else
      System.out.println("bad news...");
    System.out.println(new CharGrid(4,2));
  }
  
}