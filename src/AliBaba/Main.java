package AliBaba;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    /**
     * ������������������ʵ����ĿҪ��Ĺ���
     * ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨��
     *
     * @param a ������
     * @param i ������
     * @param n ��������
     * @return �»�������2λС������������
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
       
        //����������(������):;
        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        //������������(��:4.35)%:;
        double _i;
        _i = Double.parseDouble(in.nextLine().trim());
                
       //������������޶�����:;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
  
        res = calculate(_a, _i, _n);
        System.out.println(res);
    }
}