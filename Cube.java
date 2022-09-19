
public class Cube {
	public static void main(final String[] args){
    System.out.println("hello world");
    char [][] cube= {
      {'r','r','r','r','r','r','r','r','r'},
      {'b','b','b','b','b','b','b','b','b'},
      {'o','o','o','o','o','o','o','o','o'},
      {'g','g','g','g','g','g','g','g','g'},
      {'y','y','y','y','y','y','y','y','y'},
      {'w','w','w','w','w','w','w','w','w'}};

     

      printOut(cube);
      
  }

  public static void printOut(char[][] cube) {
    for ( int i = 0; i < 6; i++){
      System.out.println(cube[i][0] + " | " + cube[i][1] + " | " + cube[i][2]);
      System.out.println(cube[i][3] + " | " + cube[i][4] + " | " + cube[i][5]);
      System.out.println(cube[i][6] + " | " + cube[i][7] + " | " + cube[i][8]);
      System.out.println(" ");
   }

  }
  

}

