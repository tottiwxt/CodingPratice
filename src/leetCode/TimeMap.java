package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:����һ������ʱ��ļ�ֵ�洢��?TimeMap����֧����������������
 *
 * 1. set(string key, string value, int timestamp)
 *
 * �洢��?key��ֵ?value���Լ�������ʱ���?timestamp��
 * 2. get(string key, int timestamp)
 *
 * ������ǰ����?set(key, value, timestamp_prev)?���洢��ֵ������?timestamp_prev <= timestamp��
 * ����ж��������ֵ���򷵻ض�Ӧ����??timestamp_prev?���Ǹ�ֵ��
 * ���û��ֵ���򷵻ؿ��ַ�����""����
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/time-based-key-value-store
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
