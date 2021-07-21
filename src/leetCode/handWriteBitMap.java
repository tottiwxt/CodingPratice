package leetCode;

/**
 * @Description: 一个byte有8位
 * @Author: wangxutao@qiyi.com
 * @Date: 5/18/21 5:23 PM
 */
public class handWriteBitMap {
  static class BitMap {

    private byte[] bitmap;
    private int length;

    public BitMap(int length) {
      bitmap = new byte[(length >>> 3) +1];
    }

    public void add(int num) {
      int index = num >>> 3;
      int bit_index = num % 8; //等价于 number&7
      byte b = bitmap[index];
      byte comp = (byte) (1 << (7 - bit_index));
      bitmap[index] = (byte) (b | comp);
    }

    public boolean get(int num) {
      int index = num >>> 3;
      int bit_index = num % 8;
      byte b = bitmap[index];

      return (b >>> (7- bit_index) & 1) == 1;
    }

    public int getFirstBlank() {
      for (int i = 0; i<= length>>>3; i++) {
        byte b = bitmap[i];
        for (int index = 7; index >= 0; index --) {
          if ( ((b >>> index) & 1) == 0) {
            int result = (7-index) + i * 8;
            if (result > 0) {
              return result;
            }
          }
        }
      }
      return -1;
    }
  }

  public static void main(String[] args) {
    BitMap bitMap = new BitMap(3);
    bitMap.add(0);
    bitMap.add(1);
    bitMap.add(3);
    System.out.println(bitMap.get(0));
    System.out.println(bitMap.get(1));
    System.out.println(bitMap.get(2));
    System.out.println(bitMap.getFirstBlank());

    System.out.println(8>>>3);
    System.out.println(16>>>3);
    System.out.println((1 << (7 - 0)));
  }
}
