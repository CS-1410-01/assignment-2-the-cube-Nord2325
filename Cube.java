
import java.util.ArrayList;

public class Cube {

  static ArrayList <String> rotations = new ArrayList<String>();

	public static void main(final String[] args){
      
      char [][] cube= {
    {'o','o','o','o','o','o','o','o','o'}, // this is the up/top 0
    {'r','r','r','r','r','r','r','r','r'}, // this is the down/bottom 1
    {'b','b','b','b','b','b','b','b','b'}, // this is the right side 2
    {'g','g','g','g','g','g','g','g','g'}, // this is the left side 3
    {'w','w','w','w','w','w','w','w','w'}, // this is the front side 4
    {'y','y','y','y','y','y','y','y','y'}}; // this is the back side 5
    
    for(String i: args){

      if (i.contains("u'")){
        cube = moveUPrime(cube);
      }
      else if (i.contains("u")){
        cube = moveU(cube);
      } 
      else if (i.contains("d'")){
        cube = moveDPrime(cube);
      }
      else if (i.contains("d")){
        cube = moveD(cube);
      }

      // else if (args.get(i).equals ("l")){
      //   moveL(cube);
      // }
      // else if (args.get(i).equals ("l'")){
      //   moveLPrime(cube);
      // }
      // else if (args.get(i).equals ("r")){
      //   moveR(cube);
      // }
      // else if (args.get(i).equals ("r'")){
      //   moveRPrime(cube);
      // }
      // else if (args.get(i).equals ("f")){
      //   moveF(cube);
      // }
      // else if (args.get(i).equals ("f'")){
      //   moveFPrime(cube);
      // }
      // else if (args.get(i).equals ("b")){
      //   moveB(cube);
      // }
      // else if (args.get(i).equals ("b'")){
      //   moveBPrime(cube);
      // }
    }
     
      // cube = moveU(cube);
      // cube = moveUPrime(cube);
      // cube = moveD(cube);
      // cube = moveDPrime(cube);
      // cube = moveR(cube);
      // cube = moveRPrime(cube);
      // cube = moveL(cube);
      // cube = moveLPrime(cube);
      // cube = moveF(cube);
      // cube = moveFPrime(cube);
      // cube = moveB(cube);
      // cube = moveBPrime(cube);
      printOut(cube);
  }

  public static void printOut(char[][] cube) {
    for ( int i = 0; i < 6; i++){
      System.out.println(cube[i][0] + " | " + cube[i][1] + " | " + cube[i][2]);
      System.out.println(cube[i][3] + " | " + cube[i][4] + " | " + cube[i][5]);
      System.out.println(cube[i][6] + " | " + cube[i][7] + " | " + cube[i][8]);
      System.out.println(" ");
      System.out.println("To Solve: ");

   }
   for(int i = rotations.size(); i>0; i--){
      System.out.print(rotations.get(i-1) + " ");
    }

 


  }

  public static char[][] moveU(char[][] cube){
    rotations.add("u'");
    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate top of cube clockwise 
    // middle spot does not change
    // set new values for top made by rotating top of cube
    cube[0][0] = copy[0][6];
    cube[0][1] = copy[0][3];
    cube[0][2] = copy[0][0];
    cube[0][3] = copy[0][7];
    cube[0][5] = copy[0][1];
    cube[0][6] = copy[0][8];
    cube[0][7] = copy[0][5];
    cube[0][8] = copy[0][2];

    // change right side of cube
    // new values comes from the back of the cube the 5's
    cube[2][0] = copy[5][8];
    cube[2][1] = copy[5][7];
    cube[2][2] = copy[5][6];

    // change the value of the front side
    // gets its values from the right side
    cube[4][0] = copy[2][0];
    cube[4][1] = copy[2][1];
    cube[4][2] = copy[2][2];

    // change the value of the left side
    // left side gets its value from the front
    cube[3][0] = copy[4][0];
    cube[3][1] = copy[4][1];
    cube[3][2] = copy[4][2];

    //change the values of the back side
    // backside gets its value from the left
    cube[5][6] = copy[3][2];
    cube[5][7] = copy[3][1];
    cube[5][8] = copy[3][0];

    return cube;
  }

  public static char[][] moveUPrime(char[][] cube){
    rotations.add("u");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate top of cube clockwise 
    // middle spot does not change
    // set new values for top made by rotating top of cube
    cube[0][6] = copy[0][0];
    cube[0][3] = copy[0][1];
    cube[0][0] = copy[0][2];
    cube[0][7] = copy[0][3];
    cube[0][1] = copy[0][5];
    cube[0][8] = copy[0][6];
    cube[0][5] = copy[0][7];
    cube[0][2] = copy[0][8];

    // change right side of cube
    // new values comes from the back of the cube the 5's
    cube[5][8] = copy[2][0];
    cube[5][7] = copy[2][1];
    cube[5][6] = copy[2][2];

    // change the value of the front side
    // gets its values from the right side
    cube[2][0] = copy[4][0];
    cube[2][1] = copy[4][1];
    cube[2][2] = copy[4][2];

    // change the value of the left side
    // left side gets its value from the front
    cube[4][0] = copy[3][0];
    cube[4][1] = copy[3][1];
    cube[4][2] = copy[3][2];

    //change the values of the back side
    // backside gets its value from the left
    cube[3][2] = copy[5][6];
    cube[3][1] = copy[5][7];
    cube[3][0] = copy[5][8];

    return cube;
  }

  public static char[][] moveD(char[][] cube){
    rotations.add("d'");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate bottom of cube clockwise 
    // middle spot does not change
    // set new values for bottom made by rotating top of cube
    cube[1][0] = copy[1][2];
    cube[1][1] = copy[1][5];
    cube[1][2] = copy[1][8];
    cube[1][3] = copy[1][1];
    cube[1][5] = copy[1][7];
    cube[1][6] = copy[1][0];
    cube[1][7] = copy[1][3];
    cube[1][8] = copy[1][6];

    // change right side of cube (Blue)
    // new values comes from the back of the cube the 5's
    cube[2][6] = copy[5][2];
    cube[2][7] = copy[5][1];
    cube[2][8] = copy[5][0];

    // change the value of the front side (White)
    // gets its values from the right side
    cube[4][6] = copy[2][6];
    cube[4][7] = copy[2][7];
    cube[4][8] = copy[2][8];

    // change the value of the left side (Green)
    // left side gets its value from the front
    cube[3][6] = copy[4][6];
    cube[3][7] = copy[4][7];
    cube[3][8] = copy[4][8];

    //change the values of the back side (Yellow)
    // backside gets its value from the left
    cube[5][0] = copy[3][8];
    cube[5][1] = copy[3][7];
    cube[5][2] = copy[3][6];

    return cube;
  }

  public static char[][] moveDPrime(char[][] cube){
    rotations.add("d");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate bottom of cube clockwise 
    // middle spot does not change
    // set new values for bottom made by rotating top of cube
    cube[1][2] = copy[1][0];
    cube[1][5] = copy[1][1];
    cube[1][8] = copy[1][2];
    cube[1][1] = copy[1][3];
    cube[1][7] = copy[1][5];
    cube[1][0] = copy[1][6];
    cube[1][3] = copy[1][7];
    cube[1][6] = copy[1][8];

    // change right side of cube (Blue)
    // new values comes from the back of the cube the 5's
    cube[5][2] = copy[2][6];
    cube[5][1] = copy[2][7];
    cube[5][0] = copy[2][8];

    // change the value of the front side (White)
    // gets its values from the right side
    cube[2][6] = copy[4][6];
    cube[2][7] = copy[4][7];
    cube[2][8] = copy[4][8];

    // change the value of the left side (Green)
    // left side gets its value from the front
    cube[4][6] = copy[3][6];
    cube[4][7] = copy[3][7];
    cube[4][8] = copy[3][8];

    //change the values of the back side (Yellow)
    // backside gets its value from the left
    cube[3][8] = copy[5][0];
    cube[3][7] = copy[5][1];
    cube[3][6] = copy[5][2];

    return cube;
  }

  public static char[][] moveR(char[][] cube){
    rotations.add("r'");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate right side of cube clockwise 
    // middle spot does not change
    // set new values for right made by rotating right side of cube
    cube[2][0] = copy[2][6];
    cube[2][1] = copy[2][3];
    cube[2][2] = copy[2][0];
    cube[2][3] = copy[2][7];
    cube[2][5] = copy[2][1];
    cube[2][6] = copy[2][8];
    cube[2][7] = copy[2][5];
    cube[2][8] = copy[2][2];

    // change front side of cube (white)
    // new values comes from the bottom of the cube the 5's
    cube[4][2] = copy[1][2];
    cube[4][5] = copy[1][5];
    cube[4][8] = copy[1][8];

    // change the value of the top side
    // gets its values from the front side
    cube[0][2] = copy[4][2];
    cube[0][5] = copy[4][5];
    cube[0][8] = copy[4][8];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[1][2] = copy[5][2];
    cube[1][5] = copy[5][5];
    cube[1][8] = copy[5][8];

    //change the values of the back side 
    // backside gets its value from the top
    cube[5][2] = copy[0][2];
    cube[5][5] = copy[0][5];
    cube[5][8] = copy[0][8];

    return cube;
  }

  public static char[][] moveRPrime(char[][] cube){
    rotations.add("r");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate right side of cube clockwise 
    // middle spot does not change
    // set new values for right made by rotating right side of cube
    cube[2][6] = copy[2][0];
    cube[2][3] = copy[2][1];
    cube[2][0] = copy[2][2];
    cube[2][7] = copy[2][3];
    cube[2][1] = copy[2][5];
    cube[2][8] = copy[2][6];
    cube[2][5] = copy[2][7];
    cube[2][2] = copy[2][8];

    // change front side of cube (white)
    // new values comes from the bottom of the cube the 5's
    cube[1][2] = copy[4][2];
    cube[1][5] = copy[4][5];
    cube[1][8] = copy[4][8];

    // change the value of the top side
    // gets its values from the front side
    cube[4][2] = copy[0][2];
    cube[4][5] = copy[0][5];
    cube[4][8] = copy[0][8];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[5][2] = copy[1][2];
    cube[5][5] = copy[1][5];
    cube[5][8] = copy[1][8];

    //change the values of the back side 
    // backside gets its value from the top
    cube[0][2] = copy[5][2];
    cube[0][5] = copy[5][5];
    cube[0][8] = copy[5][8];

    return cube;
  }
  public static char[][] moveL(char[][] cube){
    rotations.add("l'");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate right side of cube clockwise 
    // middle spot does not change
    // set new values for right made by rotating right side of cube
    cube[3][0] = copy[3][2];
    cube[3][1] = copy[3][5];
    cube[3][2] = copy[3][8];
    cube[3][3] = copy[3][1];
    cube[3][5] = copy[3][7];
    cube[3][6] = copy[3][0];
    cube[3][7] = copy[3][3];
    cube[3][8] = copy[3][6];

    // change front side of cube 
    // new values comes from the bottom of the cube
    cube[4][0] = copy[1][0];
    cube[4][3] = copy[1][3];
    cube[4][6] = copy[1][6];

    // change the value of the top side
    // gets its values from the front side
    cube[0][0] = copy[4][0];
    cube[0][3] = copy[4][3];
    cube[0][6] = copy[4][6];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[1][0] = copy[5][0];
    cube[1][3] = copy[5][3];
    cube[1][6] = copy[5][6];

    //change the values of the back side 
    // backside gets its value from the top
    cube[5][0] = copy[0][0];
    cube[5][3] = copy[0][3];
    cube[5][6] = copy[0][6];

    return cube;
  }

  public static char[][] moveLPrime(char[][] cube){
    rotations.add("l");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate right side of cube clockwise 
    // middle spot does not change
    // set new values for right made by rotating right side of cube
    cube[3][2] = copy[3][0];
    cube[3][5] = copy[3][1];
    cube[3][8] = copy[3][2];
    cube[3][1] = copy[3][3];
    cube[3][7] = copy[3][5];
    cube[3][0] = copy[3][6];
    cube[3][3] = copy[3][7];
    cube[3][6] = copy[3][8];

    // change front side of cube 
    // new values comes from the bottom of the cube
    cube[1][0] = copy[4][0];
    cube[1][3] = copy[4][3];
    cube[1][6] = copy[4][6];

    // change the value of the top side
    // gets its values from the front side
    cube[4][0] = copy[0][0];
    cube[4][3] = copy[0][3];
    cube[4][6] = copy[0][6];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[5][0] = copy[1][0];
    cube[5][3] = copy[1][3];
    cube[5][6] = copy[1][6];

    //change the values of the back side 
    // backside gets its value from the top
    cube[0][0] = copy[5][0];
    cube[0][3] = copy[5][3];
    cube[0][6] = copy[5][6];

    return cube;
  }

  public static char[][] moveF(char[][] cube){
    rotations.add("f'");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate front side of cube clockwise 
    // middle spot does not change
    // set new values for front made by rotating front side of cube
    cube[4][0] = copy[4][6];
    cube[4][1] = copy[4][3];
    cube[4][2] = copy[4][0];
    cube[4][3] = copy[4][7];
    cube[4][5] = copy[4][1];
    cube[4][6] = copy[4][8];
    cube[4][7] = copy[4][5];
    cube[4][8] = copy[4][2];

    // change left side of cube 
    // new values comes from the bottom of the cube
    cube[3][2] = copy[1][0];
    cube[3][5] = copy[1][1];
    cube[3][8] = copy[1][2];

    // change the value of the top side
    // gets its values from the front side
    cube[0][6] = copy[3][8];
    cube[0][7] = copy[3][5];
    cube[0][8] = copy[3][2];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[1][0] = copy[2][6];
    cube[1][1] = copy[2][3];
    cube[1][2] = copy[2][0];

    //change the values of the right side 
    // backside gets its value from the top
    cube[2][0] = copy[0][6];
    cube[2][3] = copy[0][7];
    cube[2][6] = copy[0][8];

    return cube;
  }

  public static char[][] moveFPrime(char[][] cube){
    rotations.add("f");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate front side of cube clockwise 
    // middle spot does not change
    // set new values for front made by rotating front side of cube
    cube[4][6] = copy[4][0];
    cube[4][3] = copy[4][1];
    cube[4][0] = copy[4][2];
    cube[4][7] = copy[4][3];
    cube[4][1] = copy[4][5];
    cube[4][8] = copy[4][6];
    cube[4][5] = copy[4][7];
    cube[4][2] = copy[4][8];

    // change left side of cube 
    // new values comes from the bottom of the cube
    cube[1][0] = copy[3][2];
    cube[1][1] = copy[3][5];
    cube[1][2] = copy[3][8];

    // change the value of the top side
    // gets its values from the front side
    cube[3][8] = copy[0][6];
    cube[3][5] = copy[0][7];
    cube[3][2] = copy[0][8];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[2][6] = copy[1][0];
    cube[2][3] = copy[1][1];
    cube[2][0] = copy[1][2];

    //change the values of the right side 
    // backside gets its value from the top
    cube[0][6] = copy[2][0];
    cube[0][7] = copy[2][3];
    cube[0][8] = copy[2][6];

    return cube;
  }
  public static char[][] moveB(char[][] cube){
    rotations.add("b'");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate back side of cube clockwise 
    // middle spot does not change
    // set new values for back 
    cube[5][8] = copy[5][6];
    cube[5][7] = copy[5][3];
    cube[5][6] = copy[5][0];
    cube[5][5] = copy[5][7];
    cube[5][3] = copy[5][1];
    cube[5][2] = copy[5][8];
    cube[5][1] = copy[5][5];
    cube[5][0] = copy[5][2];

    // change left side of cube 
    // new values comes from the bottom of the cube
    cube[3][0] = copy[1][6];
    cube[3][3] = copy[1][7];
    cube[3][6] = copy[1][8];

    // change the value of the top side
    // gets its values from the front side
    cube[0][0] = copy[3][6];
    cube[0][1] = copy[3][3];
    cube[0][2] = copy[3][0];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[1][6] = copy[2][8];
    cube[1][7] = copy[2][5];
    cube[1][8] = copy[2][2];

    //change the values of the right side 
    // backside gets its value from the top
    cube[2][2] = copy[0][0];
    cube[2][5] = copy[0][1];
    cube[2][8] = copy[0][2];

    return cube;
  }

  public static char[][] moveBPrime(char[][] cube){
    rotations.add("b");

    char[][] copy = new char[6][9]; // create a new array named copy

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy[i].length; j++) {
        copy[i][j] = cube[i][j];   // copy of the original array
      }
    }
    // rotate back side of cube clockwise 
    // middle spot does not change
    // set new values for back 
    cube[5][6] = copy[5][8];
    cube[5][3] = copy[5][7];
    cube[5][0] = copy[5][6];
    cube[5][7] = copy[5][5];
    cube[5][1] = copy[5][3];
    cube[5][8] = copy[5][2];
    cube[5][5] = copy[5][1];
    cube[5][2] = copy[5][0];

    // change left side of cube 
    // new values comes from the bottom of the cube
    cube[1][6] = copy[3][0];
    cube[1][7] = copy[3][3];
    cube[1][8] = copy[3][6];

    // change the value of the top side
    // gets its values from the front side
    cube[3][6] = copy[0][0];
    cube[3][3] = copy[0][1];
    cube[3][0] = copy[0][2];

    // change the value of the bottom side 
    // bottom side gets its value from the back
    cube[2][8] = copy[1][6];
    cube[2][5] = copy[1][7];
    cube[2][2] = copy[1][8];

    //change the values of the right side 
    // backside gets its value from the top
    cube[0][0] = copy[2][2];
    cube[0][1] = copy[2][5];
    cube[0][2] = copy[2][8];

    return cube;
  }


}

