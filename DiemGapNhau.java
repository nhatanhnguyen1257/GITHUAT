/**
 * 
 */

/**
 * @author: Nhatanh
 * create date: Jul 8, 2018
 *
 * @deprecated: tìm số điểm n. sao cho số điểm số tam giác tạo từ số điểm n
 * gâp k lần số đường thẳng tạo từ số điểm n.
 *
 */
public class DiemGapNhau {

  /**
   * sô tam giác từ điểm tình băng n * (n -1) * (n - 2) / 3!.
   * 
   * n là số các chọn đỉnh 1 của tam giac.
   * n-1 là số cách cchọn đỉnh 2.
   * n-2 là số các chọn dỉnh 3 của tam giác
   * vì 1 tam giác có 3 đỉnh có có thể ddược xoay thành 6 tam giác khác
   * ví dụ: ABC, ACB, CAB, CBA, BAC, BCA nên chia cach chọn
   * 
   * 
   * số đường thăng tạo từ các điểm tính bằng: n (n - 1)/2.
   * 
   * nó đuôcj tạo bỏi chỉnh hơn: chập 2 của n.
   * 
   * 
   * nêu ta có tỷ số: n -2 / 3 = k
   * 
   * trong đó n là số điểm không thẳng hàng.
   *  trong đó k là tỷ số cần.
   * */
  private int tiSoGiuaTamGiacDuongThang(int soDiem) {
    return soDiem * 3 +2;
  }
  
  public static void main(String []args) {
    System.out.println(new DiemGapNhau().tiSoGiuaTamGiacDuongThang(2));
  }
}
