
/**
 * 
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

 * Note:

 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:

 * [0,1,3,5,6,8,12,17]

 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.

 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:

 * [0,1,2,3,4,8,9,11]

 * Return false. There is no way to jump to the last stone as 
 * the gap between the 5th and 6th stone is too large.
 * 
 * 
 * **/
public class FrogJump {

	/** vị trí thực hiện bước nhẩy lớn nhất **/
	private int mIndex;
	
	/** vị trí cần di chuyên tới khi thực hiện bước nhẩy **/
	private int mIndexMovie;
	
	
	/** chia mảng ban đầu ra là 2 phần từ vị trí thực hiện bước nhẩy lớn nhất 
	 * nếu bên trai và bên phải đều thỏa mãn điều kiện đề bài thì có thể thực hiện và ngược lại
	 * 
	 * **/
	public boolean canCross(int[] stones) {
		int maxDivede = maxDivede(stones);
		return isNumberLeft(stones, maxDivede)
				&& isNumberRight(stones, maxDivede) ? true : false;

	}
	
	/**
	 * kiển tra với dãy bên trai.
	 * 
	 * **/
	private boolean isNumberLeft(int[] stones, int maxDivede) {
		int maxDivedeTemp = maxDivede;
		// If the frog's last jump was k units,
		// then its next jump must be either k - 1, k, or k + 1 units. 
		// Note that the frog can only jump in the forward direction.
		for (int index = mIndex - 1; index > 0; index--) {
			if (isNumberInArray(stones, stones[index] - maxDivedeTemp, index, 0)) {
				index = mIndexMovie + 1;
			} else if (isNumberInArray(stones, stones[index] - maxDivedeTemp + 1, index, 0)) {
				index = mIndexMovie + 1 ;
				maxDivedeTemp -= 1;
			} else {
				return false;
			}
		}
		
		// vì bước nhẩy nhỏ nhất bắt đầu từ 1. nên nếu khác 1 tức là không tồn tại
		if (maxDivedeTemp != 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * kiểm tra số từ bên trái. Nếu số đó thỏa mãn thì trả về true.
	 * nếu không thỏa mã điều kiện trả về false.
	 * */
	private boolean isNumberRight(int[] stones, int maxDivede) {
		int maxDivedeTemp = maxDivede;
		// If the frog's last jump was k units,
		// then its next jump must be either k - 1, k, or k + 1 units. 
		// Note that the frog can only jump in the forward direction.
		for (int index = mIndex ; index < stones.length - 1; index++) {
			if (isNumberInArray(stones, stones[index] + maxDivedeTemp, stones.length - 1, index)) {
			} else if (isNumberInArray(stones, stones[index] + maxDivedeTemp + 1, stones.length - 1, index)) {
				maxDivedeTemp += 1;
			} else if (isNumberInArray(stones, stones[index] + maxDivedeTemp - 1, stones.length - 1, index)) {
				maxDivedeTemp -= 1;
			} else
				return false;
		}
		return true;
	}
	
	/**
	 * kiểm tra xem một số có nằm trong một dãy số cho trước không.
	 * trả về vị trí trùng với đúng giá trị của số.
	 * 
	 * @return nếu có tồn tại số trong mảng trả về @true. nếu không tồn tại trả về @false
	 * */
	private boolean isNumberInArray(int[] stones, int number, int indexBegin, int indexEnd ) {
		for (int i = indexBegin; i >= indexEnd ; i--) {
			if (stones[i] == number) {
				mIndexMovie = i ;
				return true;
			}
		}
		return false;
	}

	/**
	 * Tìm giá trị bước nhẩy lớn nhất giữa 2 số liên tiếp. Vd: 0,1,2,3,4,8,9,11 -> 8 -  4
	 * Đồng thời trả về vị trí chứa giá trị lớn nhất : Vd: 0,1,2,3,4,8,9,11 -> (index[5] = 8 
	 * 
	 * @return (int) number max divede
	 * */
	private int maxDivede(int stones[]) {
		int maxDivede = 0;
		int temp = 0;
		for (int index = stones.length - 1; index > 0; index--) {
			temp = stones[index] - stones[index - 1];
			if (temp > maxDivede) {
				mIndex = index ;
				maxDivede = temp;
			}
		}
		return maxDivede;
	}

	public static void main(String []args) {
		int array1[] = {0,1,3,5,6,8,12,17};
		int array2[] = {0,1,2,3,4,8,9,11};
		FrogJump frogJump = new FrogJump();
		System.out.println(""+ frogJump.canCross(array1));
		System.out.println(""+ frogJump.canCross(array2));
	}
	
}
