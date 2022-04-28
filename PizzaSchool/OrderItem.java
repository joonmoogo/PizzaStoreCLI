package PizzaSchool;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderItem {
            /*
        Author: Jun muk o
        E-mail: junemuk@hknu.ac.kr
        Course: Java Programming
        Assignment: Programming Assignment 1
        Due date: 05/20/2021
        File: SpecialtyPizzaMenu.java
        Purpose: Java application that implements an online specialty pizza shop
        Compiler/IDE: Java SE Development Kit 8u181/IntelliJ IDEA
        Operating system: MS Windows 10
        Reference(s): Java 8 API - Oracle Documentation
        (http://docs.oracle.com/javase/8/docs/api/);
        (Include ALL additional references (Web page, etc.) here.)
        */
    String[] menu = {"0","Meat Lovers","Vegetarian","Hawaiian","Philly Steak","BBQ Chicken","메뉴 나가기"};
    String[] size ={"0","Personal","Medium","Large","Extra Large"};
    double[] price ={0,10.0,14.5,19.0,23.5};


    int numOfOrder = 0;
    Scanner sc = new Scanner(System.in);
    ArrayList orderedMenu = new ArrayList();
    ArrayList orderedSize = new ArrayList();
    ArrayList orderedCount = new ArrayList();

    String name;
    String card ;
    String cardNumber;
    String ExpirationDate;
    double Total=0;




    public void displayPizzaMenu(){

        while(true) {
            System.out.println("2017245060_오준묵");
            System.out.println("\n**********************\n");
            System.out.println("Specialty Pizza Menu\n");
            for (int i = 1; i <= 6; i++) {
                System.out.println(i + ") " + menu[i]);
            }
            System.out.print("\n" + "Your choice? (1-6) ");
            orderedMenu.add(sc.nextInt());
            if(orderedMenu.contains(6)){
                break;

            }
            else{
                System.out.println("");
            }


            System.out.println("\n**********************\n");
            System.out.println("Available Sizes and Prices\n");
            for (int i = 1; i <= 4; i++) {
                System.out.println(i + ") " + " " + size[i] + " " + price[i]);
            }
            System.out.print("\n" + "Your choice? (1-4) ");
            orderedSize.add(sc.nextInt());

            System.out.println("\n**********************\n");
            System.out.print("How many " + size[(int)orderedSize.get(numOfOrder)] +" "+ menu[(int)orderedMenu.get(numOfOrder)]+"? ");
            orderedCount.add(sc.nextInt());


            System.out.println("\n**********************\n");
            System.out.println("Your current order total is " + price[(int)orderedSize.get(numOfOrder)] * (int)orderedCount.get(numOfOrder));

            numOfOrder++;


        }
        for(int i=0;i<numOfOrder;i++){
            Total=Total+ price[(int)orderedSize.get(i)] * (int)orderedCount.get(i);
        }
        displaySummary();


    }

    public void displaySummary(){
        System.out.println("Order Summary: \n");
        System.out.println("Type    size    quantity    price\n");
        System.out.println("----------------------------------\n");

        for (int i=0;i<numOfOrder;i++){
            System.out.println(menu[(int)orderedMenu.get(i)]+"    "+size[(int)orderedSize.get(i)]+"    " +orderedCount.get(i)+"     $"+price[(int)orderedSize.get(i)] * (int)orderedCount.get(i));
        }


        System.out.println("\nOrder Total: $ "+Total);
        System.out.println("\n**********************\n");
        System.out.println("Thank you for visiting Josie's Pizza of West Chester!");
        System.out.println("Come back soon!");
        System.out.println("\n**********************\n");

    }
    public void displayPayment(){

        System.out.println("How do you wish to pay for your order?\n");
        System.out.print("(Enter 1 for cash or 2 for credit.)");
        int cashOrCredit = sc.nextInt();
        if(cashOrCredit==1){

            displaySummary();

        }
        else if(cashOrCredit==2){
            System.out.println("\nPlease enter your payment information:\n");
            System.out.print("Card holder name: ");
            name = sc.next();
            System.out.print("Credit Card type (e.g., MasterCard): ");
            card = sc.next();
            System.out.print("Credit Card number (e.g., 5201345098756420): ");
            cardNumber = sc.next();
            System.out.print("Expiration date (e.g., 10/2016): ");
            ExpirationDate = sc.next();

            displayPaymentSummary();
        }
    }

    public void displayPaymentSummary(){
        System.out.println("\n**********************\n\n\n");
        System.out.println("Credit payment summary\n");
        System.out.println("Customer name:  "+name);
        System.out.println("Payment amount:  $  "+Total);
        System.out.println("Card number:  "+card+"  "+vanish(cardNumber));
        System.out.println("Exp date:  "+ExpirationDate);
        System.out.println("\n\n**********************\n\n");
        displaySummary();

    }
    public String vanish(String cdNumber){
        char[] chk = cdNumber.toCharArray();
        for(int i=0;i<chk.length -4;i++){
            chk[i] = '*';
        }
        String vanishedNumber = new String(chk);
        return vanishedNumber;
    }

    }


