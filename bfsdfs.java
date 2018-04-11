package precodes;
import java.util.*;
class Solution{
		static int j1,j2,j1_max,j2_max,goal,j1_r1,j1_r2,j2_r1,j2_r2;
		public static void solve(){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the capacity of Jug 1:");
			j1_max=sc.nextInt();
			System.out.println("Enter the capacity of Jug 2:");
			j2_max=sc.nextInt();
			System.out.println("Enter the goal capacity:");
			goal=sc.nextInt();
			j1=0;
			j2=0;
			if((j1==goal)||(j2==goal)){
				System.out.println("Jug 1:"+j1+"\tJug 2:"+j2);
				System.out.println("Solution achieved");	
			}
			else{
				bfs();
				dfs();
			}
		}
		public static void checkForR1() {
			int fin1=0;
			System.out.println("\n\nRoot 1: We assume that Jug 1 will be always filled and Jug 2 will be emptied!\n");
			while(fin1!=1){
				if((j1_r1==goal)||(j2_r1==goal)){
					System.out.println("Root 1: Solution achieved");
					fin1=1;	
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
			}
		}
		public static void checkForR2() {
			int fin1=0;
			System.out.println("\n\nRoot 2: We assume that Jug 2 will be always filled and Jug 1 will be emptied!\n");
			while(fin1!=1){
				if((j1_r2==goal)||(j2_r2==goal)){
					System.out.println("Root 2: Solution achieved");
					fin1=1;	
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
			}
		}
		public static void bfs(){
				System.out.println("\n\n\n***BFS***\nApplying BFS for both the jugs:\n");
				System.out.println("Both the jugs will be assumed to be filled and emptied at the same time!");
				j1_r1=j1;j1_r2=j1;
				j2_r1=j2;j2_r2=j2;
				checkForR1();
				checkForR2();
			}
		public static void dfs(){
				int fin=0;
				System.out.println("\n\n\n***DFS***\nApplying DFS for the first Jug:\n");
				System.out.println("We assume that Jug 1 will be always filled and Jug 2 will be emptied!\n");
				while(fin!=1){
					if((j1==goal)||(j2==goal)){
						System.out.println("Solution achieved");
						fin=1;	
					}
					else if((j1>0) && (j2<j2_max)){
							fillj2();
						}
					else if((j1>0) && (j2==j2_max)){
							emptyj2();
						}
					else if(j1==0){
							j1=j1_max;
							System.out.println("Jug 1 was empty hence Jug 1 filled");
							System.out.println("Jug 1:"+j1+"\tJug 2:"+j2);
						}
					if(goal>(j1_max>j2_max?j1_max:j2_max)){
							System.out.println("Goal is not feasible in this case!");
							break;
						}
				}
			}
		static void fillj2(){
				int fin=0,tr=0;
				if(j1>j2_max-j2){
						tr=j2_max-j2;
					}
				else{
						tr=j1;
					}
				while(fin!=1) {	
					j2+=1;
					j1-=1;
					if((j2==j2_max)||(j1==0)) { 
						fin=1;
					}
				}
				System.out.println("Jug 1 transferred "+tr+" into Jug 2");
				System.out.println("Jug 1:"+j1+"\tJug 2:"+j2);
			}
		static void emptyj2(){
				j2=0;
				System.out.println("Jug 2 was filled hence Jug 2 was emptied!");
				System.out.println("Jug 1:"+j1+"\tJug 2:"+j2);
			}
	}
class bfsdfs{
		public static void main(String args[]){
				Solution s=new Solution();
				s.solve();
			}
	}