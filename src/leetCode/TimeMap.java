package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:创建一个基于时间的键值存储类?TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键?key、值?value，以及给定的时间戳?timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用?set(key, value, timestamp_prev)?所存储的值，其中?timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的??timestamp_prev?的那个值。
 * 如果没有值，则返回空字符串（""）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: wangxutao@qiyi.com
 * @Date: 7/10/21 1:41 PM
 */
public class TimeMap {
  private HashMap<String, List<Entity>> map;
  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (map.containsKey(key)) {
      List<Entity> linkedList = map.get(key);
      Entity entity = new Entity(timestamp, value);
      linkedList.add(linkedList.size(), entity);
    } else {
      LinkedList<Entity> linkedList = new LinkedList<>();
      Entity entity = new Entity(timestamp, value);
      linkedList.add(entity);
      map.put(key, linkedList);
    }
  }

  public String get(String key, int timestamp) {
    if (map.containsKey(key)) {
      List<Entity> list = map.get(key);
      int index = binarySearch(list, timestamp);
      if (index > 0) {
        if (list.get(index).getTimestamp() <= timestamp) {
          return list.get(index).getValie();
        } else {
          return list.get(index -1).getValie();
        }
      } else if (index == 0) {
        if (list.get(index).getTimestamp() <= timestamp) {
          return list.get(index).getValie();
        }
      }
    }
    return "";
  }

  private int binarySearch(List<Entity> list, int target) {
    int low = 0, high = list.size()-1;
    while(low < high) {
      int mid = (low + high) / 2 + low;
      if (list.get(mid).getTimestamp() <= target) {
        low = mid + 1;
      }
      else {
        high = mid;
      }
    }
    return low;
  }
}

class Entity {

  public Entity(int timestamp, String valie) {
    this.timestamp = timestamp;
    this.valie = valie;
  }

  private int timestamp;

  public int getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(int timestamp) {
    this.timestamp = timestamp;
  }

  public String getValie() {
    return valie;
  }

  public void setValie(String valie) {
    this.valie = valie;
  }

  private String valie;

}
