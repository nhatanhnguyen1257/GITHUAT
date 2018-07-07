/**
 * @deprecated: sử dụng class này để tiền hành sắp xếp sâu
 * săp xếp bằng thuật toán sắp xếp nha.
 * 
 * @author: Nhatanh
 * create date: Jul 7, 2018
 */
public class BienDoiXau {

  
  /**
   * @deprecated: sử dụng thuật toán sắp sếp nhanh 
   * để tiến hành sắp xếp chuỗi.
   * Một chuỗi có thể coi là một mảng kiểu char
   * mối một kí tự sẽ được trả về bằng một số nguyên nên ta có thể
   * tiến hành so sánh như một số int.
   * 
   * @param array: là mảng kí tự cần truyền.
   * @param left: là vị trí phần tử từ bên trái quá.
   * @param right: là vị trí phần tử từ phía bên phảii qua.
   * */
  private int sort(char array[], int left, int right) {
    int numberSwap = 0;
    int left_ = right;
    int right_ = left;
    int temp = array[(left + right) /2];
    do {
      
      while(array[left] < temp && left < right)
        left++;
      
      while (array[right] > temp && right > left)
        right --;
      
      if (left <= right) {
        swap(array[left], array[right]);
        left ++;
        right --;
        numberSwap += 1;
      }
      
    }while(left <= right);
    
    if (left < right_) 
      sort(array, left, right_);
    if (left_ < right)
      sort(array, right_, right);
    
  
    return numberSwap;
  }
  
  /**
   * sử dụng hoán đổi vị trí cácc chữ trong chuỗi.
   * */
  private void swap(int numberA, int numberB) {
    int temp = 0;
    if (numberA > numberB) {
      temp = numberB;
      numberB = numberA;
      numberA = temp;
    }
  }
  
  public static void main(String []args) {
    char string[] = "CLPCL".toCharArray();
    
    System.out.println(new BienDoiXau().sort(string, 0, string.length-1));
  }
}
