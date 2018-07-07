import java.util.*;
import java.lang.*;

/**
 * @author: Nhatanh
 * create date: Jul 7, 2018
 */

class Main
{
  
  /**
  * trả vê gia tri giai thưa một số
  **/
  private int getG(int number){
    if (number == 0) {
      return 1;
    }else {
      int temp = 1;
      for (int i = 1; i <= number; i++){
        temp *= i;
      }
      return temp;
    }
  }
  
  
  /**
  * trả vêf ước của một số 
  **/
  private int getU(int number){
    int temp = 1;
    for (int i = number/2; i > 0; i --){
      if (number% i == 0){
        temp += 1;
      }
    }
    return temp;
  }
  
  /**
   * thương hai số
  **/
  private int getThuong(int numberA, int numberB){
    if (numberA > numberB)
      return numberA/numberB;
    return numberB/numberA;
  }
  
  private String getNumber(int numberA, int numberB) {
    return ""+ getU(getThuong(getG(numberA), getG(numberB)));
  }
  
  public static void main (String[] args) throws java.lang.Exception
  {
//    int numberA = 0;
//    int numberB = 0;
//    Scanner input = new Scanner(System.in);
//    try {
//      numberA = input.nextInt();
//      numberB = input.nextInt();
//    }catch (Exception e) {
//    }finally {
//      input.close();
//    }
    System.out.println(new Main().getNumber(4, 6));
    System.out.println(new Main().getNumber(4, 5));
    System.out.println(new Main().getNumber(3, 3));
    
  }
}