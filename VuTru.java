/**
 * 
 */

/**
 * @author: Nhatanh
 * create date: Jul 7, 2018
 */
public class VuTru {

  private String number = "";
  
  // chia nhỏ các khoảng 10^ 4
  private final int TEMP = 10000;
  
  // khoang lam tron sau dau phay
  private final int SIZE = 400000;
  
  // chua so mũ sau dau phẩy
  private int mu = 0;
  
  
  /**
   * kiểm tra xem thuộc loại số chia hết, phân số hưu hạn hay vô hạn
   * */
  private String math(int tuSO, int thuongSo) {
    
    if (tuSO % thuongSo == 0) {
      return ""+ (double)(tuSO/thuongSo);
    }else{
      
      if ((tuSO * Math.pow(10, 1 +
                    Math.abs( String.valueOf(tuSO).toString().length()
                        - String.valueOf(thuongSo).toString().length())))
                          % thuongSo == 0) {

        return ""+ (double)tuSO  / thuongSo;
        
      }else {
        
        if ( tuSO < thuongSo) {
          tuSO *= Math.pow(10,
              Math.abs( String.valueOf(tuSO).length() - String.valueOf(thuongSo).length()));
          mu += (String.valueOf(TEMP).length() - 1);
        }
        
        number += ""+tuSO / thuongSo +".";
        tuSO = tuSO % thuongSo;

        for( int i = 0; i <= SIZE/TEMP; i++) {
          
          number += ""+ tuSO * TEMP /thuongSo;
          tuSO = tuSO % thuongSo;
          mu += (String.valueOf(TEMP).length() - 1);
        }
        return number ;
      }
    }
  }
  
  /**
   * nếu là sô nguyên thì vị trí thứ 2 từ cuối chuỗi sẽ là đấu .
   * nếu không phai thi là dâu . thi là sô hưu tử vô hạn khoặc hưu han.
   * số mũ sẽ có 2 khoảng 164 và 170
   * 
   * với 164 thì làm tròn tới số thứ 5 từ cuối.
   * với 168 thì lam tròn tới kí tự thứ 9 từ cuối cùng 
   * */
  private String chuoi(String string) {
    
    if (string.charAt(string.length() - 2) == '.') {
      return string.substring(0, string.length() - 2); 
    }else {
      StringBuffer stringBuffer = new StringBuffer(string);
      for (int i = stringBuffer.length() - 1;  i >= 0; i -= String.valueOf(TEMP).length() - 1  ) {
        for (int j = 0; j < String.valueOf(TEMP).length() - 1; j ++) {
          stringBuffer.replace(i - j - 1 , i - j - 1, ""+(int)((int)(stringBuffer.charAt(i - j - 1) - '0') 
                                                + (int)(stringBuffer.charAt(i) - '0') + 0.5));
        }
        stringBuffer.substring(0, i - String.valueOf(TEMP).length() - 1 );
        mu -= String.valueOf(TEMP).length() - 1;
        
        if (mu == SIZE / TEMP * (String.valueOf(TEMP).length() - 1)) {
          break;
        };
      }
      
      return stringBuffer.toString() +"*10^-"+ mu;
    }
    
  }
  
  public static void main(String []args) {
    VuTru v = new VuTru();
    System.out.println(v.chuoi(v.math(1, 512)));
  }
  
}
