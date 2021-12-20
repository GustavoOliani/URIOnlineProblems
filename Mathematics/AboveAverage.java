package Mathematics;

import java.util.LinkedList;
import java.util.Scanner;

public class AboveAverage {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int numberOfTestCases, peopleInClass, grade;
        double average;

        LinkedList<Integer> studentsList = new LinkedList<Integer>();

        numberOfTestCases = reader.nextInt();
        for(int testeCase = 0; testeCase < numberOfTestCases; testeCase++){
            average = 0;
            studentsList.clear();
            peopleInClass = reader.nextInt();
            
            for(int person = 0; person < peopleInClass; person++){
                grade = reader.nextInt();
                average += ( (double) grade / peopleInClass);
                fillAndSort(studentsList, grade);
            }
            aboveAverage(studentsList, average, peopleInClass);
            
        }
        reader.close();
    }
    // falta aprimorar ainda
    public static void fillAndSort(LinkedList<Integer> studentsList, int grade){

        if(studentsList.isEmpty()){
            studentsList.add(grade);
        }else{
            for (Integer note : studentsList) {
                if(grade < note){
                    studentsList.add(studentsList.indexOf(note), grade);
                    break;
                }
            }
        }
    }

    public static void aboveAverage(LinkedList<Integer> studentsList, double average, int peopleInClass){
        double peopleAboveAverage;

        for (Integer note : studentsList) {
            if(note > average){
                peopleAboveAverage = 100.0 * (peopleInClass - studentsList.indexOf(note)) / peopleInClass;
                System.out.printf("%.3f", peopleAboveAverage);
                System.out.println("%");
                break;
            }
        }
    }
}