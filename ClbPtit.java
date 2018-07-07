/**
 * 
 */

/**
 * @author: Nhatanh
 * create date: Jul 7, 2018
 */
public class ClbPtit {

  /**
   * trả về giá trị giai thừa number.
   * giá trị giai thừa bằng tích các phần từ từ khoảng number ->> numberEnd
   * */
  int getG(int number, int numberEnd) {
    if (number == 0) {
      return 1;
    }else {
      int temp = 1;
      for (int i = number; i > numberEnd ; i--) {
        temp *= i;
      }
      
      return temp;
    }
  }
  
  /**
   * trả về số lượng phần tử n của chập k.
   * 
   * k!/((k-n)!*n!)
   * 
   * nếu k-n > n bỏ (k-n)! ở mẫu. k! = tichcs các phần tử ((k - (k-n)) ->> k)
   * 
   * nếu k - n < n bỏ n! ở mẫu. nếu k!= tích các phần tử (k - n ->>k)
   * 
   * với các trên ta sẽ giảm được đáng kết số lần thực hiện vòng lặp trong tính giai thừa
   * */
  int getT(int numberK, int numberN) {
    int temp = numberK - numberN;
    if (temp > numberN) {
      return getG(numberK, temp )/getG(numberN, 1);
    }else {
      return getG(numberK, numberN )/getG(temp, 1);
    }
  }
  
  /**
   * tính số lượng cách sắp xếp
   * 
   * bẳng tố hợp của số lượng trai * số lương tổ hợp với con gái
   * */
  int getTeam(int boy, int girl, int numberBoyInTeam, int numberPeoleInteam) {
    return getT(boy, numberBoyInTeam) * getT(girl, numberPeoleInteam - numberBoyInTeam);
  }
  
  public static void main(String []args) {
    System.out.println(new ClbPtit().getTeam(5, 2, 4, 5) );
  }
  
}
