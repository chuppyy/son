package aow;

import java.util.Scanner;

public class tour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dem=0;
		 int score=0;
		 int sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap league: ");
		int lg=sc.nextInt();
		if(lg==5) {
			score=7;
		}else if(lg==4) {
			score=8;
		}else if(lg==3) {
			score=9;
		}else if(lg==2) {
			score =10;
		}else if (lg==1) {
			score=12;
		}
		while(dem<30) {
			while(dem<10) {
				sum+=score;
			System.out.print(sum+" ");
			score++;
			dem++;
		}
			sum+=score;
			System.out.print(sum+" ");
			dem++;
			
	}

}
}