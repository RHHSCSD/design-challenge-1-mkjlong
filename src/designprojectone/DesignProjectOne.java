/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.Scanner;
/***************************************************
*
*  Program: TECH FAIR COST PROGRAM
*  Author: Markus Ong
*  Date: March 7 2024
*  Description: A program to calculate the cost for a tech fair
****************************************************/

/***
 * 
 * SEE GOOGLE DOCUMENT SUBMISSION FOR IPO TABLE, FLOWCHART, PSEUDOCODE AND TEST CASE CHART
 * 
 */

public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // --- CONSTANTS --- //
        // use doubles because when adjusting prices you might want to use cents.
        final double ARDUINO_COST_BASE = 10; // price without discount
        final double ARDUINO_COST_DISCOUNT = 9; // price with discount
        final int ARDUINO_DISCOUNT_THRESHOLD = 15; //number of students needed to apply discount

        final double PI_COST_BASE = 15;
        final double PI_COST_DISCOUNT = 12;
        final int PI_DISCOUNT_THRESHOLD = 20; //number of students needed to apply discount

        final double VR_COST = 20;

        final double BASE_COST = 50;
        final double BASE_COST_DISCOUNT = 47.5;
        final double BASE_COST_THRESHOLD = 100;

        Scanner keyboard = new Scanner(System.in);
        
        
        
        // --- INPUT --- //
        
        //Read in the amount of arduinos, raspberry pis, and VR projects
        System.out.print("Number of arduino projects : ");
        int arduinos = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.print("Number of raspberry PI projects : ");
        int PIs = keyboard.nextInt();
        keyboard.nextLine();
        
        System.out.print("Number of VR projects : ");
        int VRs = keyboard.nextInt();
        keyboard.nextLine();
        
        
        
        // --- PROCESSING --- //
        
        //calculate amount of students
        int numStudents = arduinos + PIs + VRs;
        
        //catch errors
        if(arduinos < 0 || PIs < 0 || VRs < 0){ //if any of the projects have a negative number of students
            System.out.println("\nPlease have a positive amount of students in each project");
            return;
        }
        if(numStudents <= 0){
            System.out.println("\nPlease have at least 1 student attend the fair");
            return;
        }
        
        //initialize cost variables
        double arduinoCost;
        double PICost;
        double baseCost;
        
        
        //discount arduinos if over 15
        if(arduinos > ARDUINO_DISCOUNT_THRESHOLD){
            arduinoCost = ARDUINO_COST_DISCOUNT;
        }else{
            arduinoCost = ARDUINO_COST_BASE;
        }
        
        //discount PIS if over 20
        if(PIs > PI_DISCOUNT_THRESHOLD){
            PICost = PI_COST_DISCOUNT;
        }else{
            PICost = PI_COST_BASE; 
        }
        
        //VRCost has no discount
        
        
        
        //discount base price if there are over 100 students
        if(numStudents > BASE_COST_THRESHOLD){
            baseCost = BASE_COST_DISCOUNT;
        }else{
            baseCost = BASE_COST;
        }
        
        
        //total up the cost for each kit
        double totalArduinoCost = arduinos * arduinoCost;
        double totalPICost = PIs * PICost;
        double totalVRCost = VRs * VR_COST;
        
        double totalBaseCost = numStudents * baseCost;
        
        //Calculate total cost and cost per person
        double totalCost = totalBaseCost + totalArduinoCost + totalPICost + totalVRCost;
        
        //divide by numStudents to find average cost
        //will not have runtime error because numStudents will never be 0.
        double costPerPerson = totalCost / numStudents;
        
        
        
        // --- OUTPUT --- //
        
        // test outputs
        
        /*
        System.out.println("\nTotal arduino cost: $" + totalArduinoCost);
        System.out.println("Total PI cost: $" + totalPICost);
        System.out.println("Total VR cost: $" + totalVRCost);
        System.out.println("\nNumber of students: " + numStudents);
        System.out.println("Total Base cost: $" + totalBaseCost);
        */
        
        // Nessesary outputs
        
        System.out.println("\nThe total cost for the tech fair is $" + totalCost + ".");
        System.out.println("Each student will need to pay $" + costPerPerson + ".");
        
        
        keyboard.close();
    }
    
}
