//package meituan;
//import java.io.*;
//import java.util.*;
//class Test {
//}
//public class Main
//{
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner scanner  = new Scanner(System.in);
//		while(scanner.hasNext()){
//			int n = scanner.nextInt();
//			for(int i = 0;i<n;i++){
//				int pointNum = scanner.nextInt();
//				int count = 0;
//				ArrayList<Integer> al = new ArrayList<>();
//				for(int j=0;j<pointNum;j++){
//					al.add(scanner.nextInt());
//				}
////				al.sort(new Comparator<Integer>() {
////					@Override
////					public int compare(Integer o1, Integer o2) {
////						int i = o1 < o2 ? 1 : -1;
////						return i;
////					}
////					}
////				);
//				if(isGraph(al)){
//					System.out.println("Yes");
//				}
//				else {
//					System.out.println("No");
//				}
//			}
//		}
//	}
//
//	private static boolean isGraph(ArrayList<Integer> al) {
//		al.sort(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				int i = o1 < o2 ? 1 : -1;
//				return i;
//			}
//		});
////        System.out.println(al);
//		if(al.get(0)==0){
//			return true;
//		}
//		else{
//			int connectNum = al.get(0);
//			al.remove(0);
//			for(int i = 0;i<connectNum;i++){
//				int tmp = al.get(i)-1;
//				if(tmp	< 0 ) return false;
//				al.set(i,tmp);
//
//			}
//			return isGraph(al);
//		}
//	}
//
//}