package HUAWEI;

import java.util.*;

public class SimplifyFormula {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String str = in.nextLine();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '^') {
                    //找指数
                    int right = 0;
                    for(int j =i+1;j<str.length();j++){
                        char ch  = str.charAt(j);
                        if(ch=='+'||ch == '-')
                            break;
                        right = right*10 + ch - '0';
                    }
//                    right = str.charAt(i + 1) - '0';


                    //找系数
                    int left = 0;
//                    left = str.charAt(i - 2) - '0';
                    int times = 0;
                    for(int j = i-2;j>=0;j--){
                        char ch = str.charAt(j);
                        if(ch == '+')
                            break;
                        if(ch == '-'){
                            left = -left;
                            break;
                        }
                        left = left + (ch-'0')*(int)Math.pow(10,times);
                        times++;

                    }
//                    char ch = str.charAt(i - 3);
//                    left = ch == '+' ? left : -left;
//                    System.out.println(left + " " + right);
                    if (map.containsKey(right)) {
                        map.put(right, map.get(right) + left);
                    } else {
                        map.put(right, left);
                    }
                }

            }
            Iterator iterator = map.entrySet().iterator();
            int i = 0;
            ArrayList<Integer> al = new ArrayList<>();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
//                System.out.println(entry.getValue() + "X^" + entry.getKey());
                al.add((Integer)entry.getKey());

            }
            al.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1<o2?1:-1;
                }
            });
            int pos = 0;
            for(int j = 0;j<al.size();j++){
                int right = al.get(j);
                int left= map.get(right);
                if(left!=0){
                    if(pos == 0)
                        System.out.print(left+"X^"+right);
                    else {
                        if(left>0)
                            System.out.print("+"+left+"X^"+right);
                        else
                            System.out.print(left+"X^"+right);
                    }
                    pos++;
                }
            }
            if(pos==0)
                System.out.print(0);
            System.out.println("");
        }
    }


}
