import java.util.Scanner;

public class AirplaneSeating{

	static void fillArray(String[][] arr) {
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = "*";
            }//inner-loop
        }//outer-loop
    }//fillArray()

    static void seatingPlan(String[][] arr){

    	System.out.println();

    	System.out.print("\t\t");
    	for (char i='A';i<='F' ;i++ ) {
    		System.out.print(i+"\t");
		}//loop to display column number

		System.out.println();

		for (int i=0;i<arr.length ;i++ ) {
			System.out.print("\nRow  "+(i+1)+"\t\t");
			for (int j=0;j<arr[i].length ;j++ ) {
				System.out.print(arr[i][j]+"\t");
			}//inner-loop
			System.out.println();
		}//outer-loop

	}//seatingPlan()

	static int column(char seat){
		switch (seat){
			case 'a':
				return 0;
			case 'b':
				return 1;
			case 'c':
				return 2;
			case 'd':
				return 3;
			case 'e':
				return 4;
			case 'f':
				return 5;
			default:
				return -1;						
		}//switch

	}//column()

	static void allotSeat(String[][] arr,int row,int col){

		System.out.println();

		if(row>=1 && row<=2){

			for (int i=0;i<2 ;i++ ) {
				arr[row-1][col]="X";	
			}//loop

		}//if

		if(row>=3 && row<=8){

			for (int i=2;i<7 ;i++ ) {
				arr[row-1][col]="X";
			}//loop		

		}//if	

		if(row>=8 && row<=13){

			for (int i=7;i<13 ;i++ ) {
				arr[row-1][col]="X";	
			}//loop

		}//if			


	}//allotSeat()

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);

		int rows = 13;
		int cols = 6;
		int row=0;
		char seat='a';
		char choice = 'y';

		String[][] arr = new String[rows][cols];

			fillArray(arr);

			System.out.println("\n-Your seating plan is given below  : ");

			seatingPlan(arr);

		while(choice=='Y' || choice=='y'){

			System.out.print("\nEnter the ticket type\n\tF for first class\n\tE for economy class\n\tb for bussiness class)  :  ");
			char ticketType = read.next().charAt(0);

			if(ticketType=='f' || ticketType=='F'){
				System.out.print("\nEnter row number(between 1 and 2) :  ");
				row=read.nextInt();
				while(row<1 || row>2){
					System.out.print("\nInvalid value.For First-class enter between 1 and 2  :  ");
					row=read.nextInt();
				}//input validation for row
				System.out.print("\nEnter the seat name(between a and f):  ");
				seat = read.next().charAt(0);
				while(seat<'a' || seat>'f'){
					System.out.print("\nInvalid value.Enter between a and f  :  ");
					seat = read.next().charAt(0);
				}//input validation for column
				int col=column(seat);
				if(!(arr[row-1][col]).equals("*")){
					System.out.println("\n\n------You have already booked this seat.please choose another one------\n");
				}//if
				allotSeat(arr,row,col);
				seatingPlan(arr);
			}//if

			if(ticketType=='e' || ticketType=='E'){
				System.out.print("\nEnter row number(between 3 and 7) :  ");
				row=read.nextInt();
				while(row<3 || row>7){
					System.out.print("\nInvalid value.For Economy-class enter between 3 and 7  :  ");
					row=read.nextInt();
				}//input validation for row
				System.out.print("\nEnter the seat name(between a and f):  ");
				seat = read.next().charAt(0);
				while(seat<'a' || seat>'f'){
					System.out.print("\nInvalid value.Enter between a and f  :  ");
					seat = read.next().charAt(0);
				}//input validation for column
				int col=column(seat);
				if(!(arr[row-1][col]).equals("*")){
					System.out.println("\n\n------You have already booked this seat.please choose another one------\n");
				}//if
				allotSeat(arr,row,col);
				seatingPlan(arr);
			}//if

			if(ticketType=='b' || ticketType=='B'){
				System.out.print("\nEnter row number(between 8 and 13) :  ");
				row=read.nextInt();
				while(row<8 || row>13){
					System.out.print("\nInvalid value.For Bussiness-class enter between 8 and 13  :  ");
					row=read.nextInt();
				}//input validation for row
				System.out.print("\nEnter the seat name(between a and f):  ");
				seat = read.next().charAt(0);
				while(seat<'a' || seat>'f'){
					System.out.print("\nInvalid value.Enter between a and f  :  ");
					seat = read.next().charAt(0);
				}//input validation for column
				int col=column(seat);
				if(!(arr[row-1][col]).equals("*")){
					System.out.println("\n\n------You have already booked this seat.please choose another one------\n");
				}//if
				allotSeat(arr,row,col);
				seatingPlan(arr);
			}//if	

			System.out.print("\nDo you want to book the seat again ?\n-Enter Y for yes and N for no  : ");
			choice = read.next().charAt(0);
			while(!(choice=='Y'||choice=='y'||choice=='N'||choice=='n')){
				System.out.print("\n-Invalid choice.just enter either Y or N :");
				choice = read.next().charAt(0);
			}//input-validation for choice

		}//while			

	}//main

}//class