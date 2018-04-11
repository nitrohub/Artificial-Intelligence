package precodes;
import java.util.*;
class Solutioni{
		static int j1,j2,j1_max,j2_max,goal,j1_r1,j1_r2,j2_r1,j2_r2,limit,dep;
		public static void solve(){
			dep=0;
			int sol=0;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the capacity of Jug 1:");
			j1_max=sc.nextInt();
			System.out.println("Enter the capacity of Jug 2:");
			j2_max=sc.nextInt();
			System.out.println("Enter the goal capacity:");
			goal=sc.nextInt();
			System.out.println("Enter the limit:(Only for stopping after some limit.\nBut if goal is achieved before it, then execution stops.)");
			limit=sc.nextInt();
			j1=0;
			j2=0;
			if((j1==goal)||(j2==goal)){
				System.out.println("Jug 1:"+j1+"\tJug 2:"+j2);
				System.out.println("Solution achieved");	
			}
			else{
				while(dep<=limit && sol!=1) {
					sol=ids();
					dep+=1;
				}
			}
		}
		public static int checkForR1() {
			int fin1=0;
			int lim=0;
			System.out.println("\n\nRoot 1: We assume that Jug 1 will be always filled and Jug 2 will be emptied!\n");
			while(fin1!=1 && lim<=dep){
				if((j1_r1==goal)||(j2_r1==goal)){
					System.out.println("Root 1: Solution achieved within depth "+dep);
					fin1=1;	
					return 1;
				}
				else if((j1_r1>0) && (j2_r1<j2_max)){
					int fin=0,tr=0;
					if(j1_r1>j2_max-j2_r1){
							tr=j2_max-j2_r1;
						}
					else{
							tr=j1_r1;
						}
					while(fin!=1) {	
						j2_r1+=1;
						j1_r1-=1;
						if((j2_r1==j2_max)||(j1_r1==0)) { 
							fin=1;
						}
					}
					System.out.println("Root 1: Jug 1 transferred "+tr+" into Jug 2");
					System.out.println("Root 1: Jug 1:"+j1_r1+"\tJug 2:"+j2_r1);
					}
				else if((j1_r1>0) && (j2_r1==j2_max)){
					j2_r1=0;
					System.out.println("Root 1: Jug 2 was filled hence Jug 2 was emptied!");
					System.out.println("Root 1: Jug 1:"+j1_r1+"\tJug 2:"+j2_r1);
					}
				else if(j1_r1==0){
						j1_r1=j1_max;
						System.out.println("Root 1: Jug 1 was empty hence Jug 1 filled");
						System.out.println("Root 1: Jug 1:"+j1_r1+"\tJug 2:"+j2_r1);
					}
				lim+=1;
			}
			if(fin1==0) {
				System.out.println("No solution within depth "+dep+" for root 1!");
			}
			return 0;
		}
		public static int checkForR2() {
			int fin1=0;
			int lim=0;
			System.out.println("\n\nRoot 2: We assume that Jug 2 will be always filled and Jug 1 will be emptied!\n");
			while(fin1!=1 && lim<=dep){
				if((j1_r2==goal)||(j2_r2==goal)){
					System.out.println("Root 2: Solution achieved within depth "+dep);
					fin1=1;	
					return 1;
				}
				else if((j2_r2>0) && (j1_r2<j1_max)){
					int fin=0,tr=0;
					if(j2_r2>j1_max-j1_r2){
							tr=j1_max-j1_r2;
						}
					else{
							tr=j2_r2;
						}
					while(fin!=1) {	
						j1_r2+=1;
						j2_r2-=1;
						if((j1_r2==j1_max)||(j2_r2==0)) { 
							fin=1;
						}
					}
					System.out.println("Root 2: Jug 2 transferred "+tr+" into Jug 1");
					System.out.println("Root 2: Jug 1:"+j1_r2+"\tJug 2:"+j2_r2);
					}
				else if((j2_r2>0) && (j1_r2==j1_max)){
					j1_r2=0;
					System.out.println("Root 2: Jug 1 was filled hence Jug 1 was emptied!");
					System.out.println("Root 2: Jug 1:"+j1_r2+"\tJug 2:"+j2_r2);
					}
				else if(j2_r2==0){
						j2_r2=j2_max;
						System.out.println("Root 2: Jug 2 was empty hence Jug 2 filled");
						System.out.println("Root 2: Jug 1:"+j1_r2+"\tJug 2:"+j2_r2);
					}
				lim+=1;
			}
			if(fin1==0) {
				System.out.println("No solution within depth "+dep+" for root 2!");
			}
			return 0;
		}
		public static int ids(){
				System.out.println("\n\n\n***IDS***\nApplying IDS for both the jugs:\n");
				System.out.println("Both the jugs will be assumed to be filled and emptied at the same time with limit "+limit);
				j1_r1=j1;j1_r2=j1;
				j2_r1=j2;j2_r2=j2;
				int r1s=checkForR1();
				int r2s=checkForR2();
				if(r1s==1||r2s==1) {
					return 1;
				}
				else {
					return 0;
				}
			}
	}
class ids{
		public static void main(String args[]){
				Solutioni s=new Solutioni();
				s.solve();
			}
	}