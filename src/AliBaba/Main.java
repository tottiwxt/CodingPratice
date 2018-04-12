package AliBaba;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /**
     * 请完成下面这个函数，实现题目要求的功能
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     *
     * @param a 贷款金额
     * @param i 年利率
     * @param n 贷款期限
     * @return 月还款额，保留2位小数，向上舍入
     */
    static String calculate(int a, double i, int n) {
    	DecimalFormat df = new DecimalFormat("0.00");
    	double res = a;


    	

    	
    	
    	double month_rate = i/1200;
    	int month  = n*12;
    	double sum = 0;
    	sum = (1+month)/2*month;
    	//res = (-(month+1)*n) / (sum-1);
//    	res = n*(month+1) /(((1+month))/2+1)*month;
//    	String str=df.format(res/month_rate);
    	res = ((month+month_rate)*n)/ ((month_rate+(1+month)/2)*month);
    	String str=df.format(res);
    	return str;
    	
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
       
        //请出入贷款金额(正整数):;
        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        //请输入年利率(如:4.35)%:;
        double _i;
        _i = Double.parseDouble(in.nextLine().trim());
                
       //请输入贷款期限多少年:;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
  
        res = calculate(_a, _i, _n);
        System.out.println(res);
    }
}