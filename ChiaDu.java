/**
 * 
 */

/**
 * @author: Nhatanh
 * create date: Jul 7, 2018
 */
public class ChiaDu {
  
  void println(int []arrayInput, int []arrayOutPut) {
    for (int index = arrayInput.length - 1; index >= 0; index --) {
      System.out.print( arrayInput[index]+"\t");
    }
    System.out.println();
    for (int index = arrayInput.length - 1; index >= 0; index --) {
      System.out.print( arrayOutPut[index]+"\t");
    }
  }
  
  void get(int []arrayInput, int []arrayOutPut) {

    for (int index = arrayOutPut.length - 1; index >= 0; index --) {
      System.out.print(getNumber(arrayInput[index], arrayOutPut[index]) +"\t");
    }
  }
  
  int getNumber(int numberInArrayInput, int numberInArrayOut) {
    if (numberInArrayOut == 0 || numberInArrayInput == 0) {
      return -1;
    }else {
      int temp = (numberInArrayInput/numberInArrayOut);
      return ((temp * numberInArrayOut != numberInArrayInput || temp == 0) ? -1 : 
        (numberInArrayInput/(temp - 1)) == numberInArrayOut ? temp -1 : -1); 
    }
  }
  
  public static void main(String []args) {
    
    int arrayInput[] = {28, 6, 45, 27, 15, 24};
    int arrayOut[] = {31, 1, 0, 2, 0, 4};
    
    ChiaDu c = new ChiaDu();
    c.println(arrayInput, arrayOut);
    System.out.println("\n\n");
    c.get(arrayInput, arrayOut);
  }
}
