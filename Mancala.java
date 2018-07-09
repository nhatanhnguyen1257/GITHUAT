/**
 * @author: Nhatanh
 * create date: Jul 8, 2018
 */
public class Mancala {

  private int []array;
  
  public Mancala(int []ary) {
    this.array = ary;
  }
  
  private void inMang(int [] array) {
    System.out.println("");
    for (int number : array) {
      System.out.print(number +"\t");
    }
    System.out.println("");
  }
  
  /**
   * @deprecated: tạo một mảng mới để không làm ảnh hưởng tới dữ liệu đầu vào.
   * @author: Nhatanh
   * create date: Jul 8, 2018
   * @param array: mảng truyền vào.
   * @return trả về một mảng số sao chép từ mảng @Array
   */
  private int[] saoChepMang(int []array) {
    int []a = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      a[i] = array[i];
    }
    return  a;
  }
  
  
  private int  mancala(int array[], int lengthMancale) {
    
    int aray[];
    int temp;
    int tong = 0;
    for ( int i = 0 ; i < array.length; i++) {
      
      aray = saoChepMang(array);
      dichMang(i, aray, lengthMancale);
      
      temp = tongSoChan( aray);
      inMang(aray);
      if (temp > 0) {
        tong = temp;
      }
    }
    return tong;
  }
  
  /**
   * @author: Nhatanh
   * create date: Jul 8, 2018.
   * @param array: mảng cacs số nguyên.
   * @return trả về tổng các số chẵn trong mảng.
   */
  private int tongSoChan(int []array) {
    int tong = 0;
    for (int a : array) {
      if ( (a & 1) == 0) {
        tong += a;
      }
    }
    return tong;
  }
  

  /**
   * @deprecated: các trường hợp số 0 sẽ bị bỏ qua
   * 
   * TH1: nếu giá trị phần tử tại m nhỏ hơn khoảng từ m tới cuối mảng thì ta tăng 1 đơn vị tại các phần tử thứ m+1
   *     tới m+1 + giá trị tại m.
   * TH2: nếu giá trị lớn hơn khoảng từ m tới cuối mảng. thì chia làm 2 phần.
   *     phần 1; dịch từ vị trí đó tới cuối mảng với giá trị tăng mỗi phần tử là 1.
   *     phần 2: kiểm tra xem giá trị còn dư sau khi dịch là bao nhiêu.
   *           + nếu giá trị đó chia hết cho độ dài mảng thì ta dịch tất cả các phần tử với giá trị tăng là giá trị ngyên của phép chia.
   *           + nếu khôg chia hết thì ta tiến hành như bước trên với tới bước cuối thì dịch từ 0 - giá trị dư. mỗi lần tăng 1 đơn vị
   * @author: Nhatanh
   * create date: Jul 8, 2018
   * @param index: vị trí sét phần tử trong mảng.
   * @param array: mảng số nguyên dùng để tính.
   * @param lengthMancale: độ dài mảng.
   */
  private void dichMang(int index, int []array, int  lengthMancale) {
    if (array[index] != 0) {
      int temp =  array[index] - (lengthMancale - 1 - index);
      //TH1:
      if ( temp <= 0) {
        array[index] = 0;
        thayDoiGiaTriMang(index, index + (lengthMancale - 1 - index) - 1, array, 1);
      }else {
        //TH2:
        array[index ] = 0;
        thayDoiGiaTriMang(index, array.length - 1, array, 1);
        
        if (temp % lengthMancale == 0) {
          thayDoiGiaTriMang(0, array.length - 1, array, temp / lengthMancale);
        }else {
          thayDoiGiaTriMang(0, array.length - 1, array, temp / lengthMancale);
          temp = temp % lengthMancale;
          thayDoiGiaTriMang(0, temp, array, 1);
        }
      }
    }
  }
  
  /**
   * @deprecated: sử dụng để tăng giá trị phần tử thứ nên @number
   * @param: indexStart: vị tri phan tử lấy giá trị gán cho các biến tiếp.
   * @param: indexEnd:  vị trí cuối cùng để tăng.
   * @param: ary mang số nguyên.
   * @param: number: số đơn vị tăng.
   * */
  private void thayDoiGiaTriMang(int indexStart,int indexEnd, int []ary, int number) {
    
    if (indexStart != 0)
        indexStart += 1;
    
    for (int i = indexStart; i <= indexEnd; i++) {
      ary[i] += number;
    }
  }
  
  
  
  public static void main(String []args) {
    int array[] = {0, 1, 1, 0, 0 , 0, 0, 0 , 0 , 7, 0, 0, 0, 0};
    Mancala m = new Mancala(array);
    System.out.println(m.mancala(m.array, 14));
  }
}
