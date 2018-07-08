import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author: Nhatanh
 * create date: Jul 8, 2018
 */
public class VuTru {
  
  // khoang lam tron sau dau phay
  private final int SIZE = 400000;
  
  // chua so mũ sau dau phẩy
  private int mu = 0;
  
  
  Map<Integer, String> map = new HashMap<Integer, String>();
  
  /**
   * kiểm tra xem thuộc loại số chia hết, phân số hưu hạn hay vô hạn
   * */
  private String math(long tuSO, long mauSo) {

    int index = 1;
    
    // do dai cua phan sau dau phay
    int lenghtString = 100;
    
    // chua phan du cua phep toan
    long phanDu = tuSO % mauSo;
    
    // tinh phan nguyen cua phan so
    long phanNguyen = tuSO / mauSo;
    
    String number = ""+ phanNguyen ;

    String tempNumber ="";
    
    if (phanDu != 0) {
      number += ".";
      
      while(true) {
        mu ++;
        lenghtString --;
        tuSO = phanDu * 10; 
        phanNguyen = tuSO / mauSo;
        
        if (phanNguyen == 0) {
          tuSO = phanDu * 10;
          tempNumber += 0;
        }else {
          tempNumber += phanNguyen;
        }
        
        phanDu = tuSO % mauSo;
          
        if (lenghtString == 0) {
          map.put(index, tempNumber);
          tempNumber = "";
          lenghtString = 100;
          index ++;
        }
        
        if (phanDu == 0)
          break;
        
         if (mu == SIZE)
           break;
      }
      return number;    
    }else 
       return number;
    
  }
  
  private void inSo(Map<Integer, String> map, int tuSo, int MauSO) {
    System.out.print(math(tuSo, MauSO));
    for (Map.Entry<Integer, String> m : map.entrySet()) {
      System.out.println(m.getValue());
    }
  }

  
  public static void main(String []args) {
    VuTru v = new VuTru();
    v.inSo(v.map, 1, 3);
    
  }
  
}
