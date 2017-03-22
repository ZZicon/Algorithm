package ╣зр╩уб;

public class text {
	public static void main(String args[]){
		int l = 0, num = 0;
		for (int i = 0; i < 3; i++) {
			num = ++i;
			System.out.println("num="+num);
			for (int j = i; j > 0; j--) {
				++l;
				System.out.println("l="+l);
			}
		}
		
		
		System.out.println(num*l);
	}
}
