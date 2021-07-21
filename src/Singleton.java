/**
 * @Description:
 * @Author: wangxutao@qiyi.com
 * @Date: 7/20/21 6:59 PM
 */
public class Singleton {
  class K {
    private volatile K k;
    private K(){
    }
    public K getInstance(){
      if (k == null) {
        synchronized (K.class) {
          if (k == null) {
            k = new K();
          }
        }
      }
      return k;
    }
  }
}
