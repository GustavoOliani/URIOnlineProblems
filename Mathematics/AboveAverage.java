package Mathematics;
import java.util.LinkedList;
import java.util.Scanner;

public class AboveAverage {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int numberOfTestCases, peopleInClass, grade, size;
        double average = 0;

        LinkedList<Integer> studentsList = new LinkedList<Integer>();

        numberOfTestCases = reader.nextInt();
        for(int i = 0; i < numberOfTestCases; i++){

            studentsList.clear();
            peopleInClass = reader.nextInt();
            
            for(int j = 0; j < peopleInClass; j++){
                grade = reader.nextInt();
                average += grade;
                if(studentsList.isEmpty()){
                    studentsList.add(grade);
                }else{
                    size = studentsList.size();
                    for (Integer note : studentsList) {
                        if(grade < note){
                            studentsList.add(studentsList.indexOf(note), grade);
                            break;
                        }
                    }
                    if(size == studentsList.size()){
                        studentsList.add(grade);
                    }
                }
            }
            float test;
            average = average/peopleInClass;
            for (Integer note : studentsList) {
                if(note >= average){
                    test = (peopleInClass - studentsList.indexOf(note))/ peopleInClass;
                    test = (1 - test) * 100;
                    System.out.printf("%.3f", test);
                    System.out.println("%");
                    break;
                }
            }
        }
        reader.close();
    }
}
