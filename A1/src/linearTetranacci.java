import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//Declare class Tetrancci

public class linearTetranacci

{     

       // Linear Approach

       public static int linearTetranacci(int number)

       {

             //Declare local variables

             int first = 0, second = 0, third = 0,

                    fourth = 1, next = 0;

             //use for loop to iterate up

             //to the input parameter

             for(int i=0;i<=number;i++)

             {

                    //If number is less than 2

                    //set next value is 0

                    if(i<=2)

                    {

                           next = 0;

                    }

                    //if number is 3

                    else if(i==3)

                    {

                           //set next to 1

                           next = 1;

                    }

                    //Otherwise

                    else

                    {

                           next = first + second + third + fourth;

                           first = second;

                           second = third;

                           third = fourth;

                           fourth = next;

                    }

             }

             //return value

             return next;

       }

       //main method

public static void main(String args[]) {

List<String> outputList = new ArrayList<String>();

long startTime = System.currentTimeMillis();

long endTime = System.currentTimeMillis();

for (int i = 5; i <= 100; i=i+5){



endTime = System.currentTimeMillis();

outputList.add("i = " + i + ", Value = " + linearTetranacci(i)

    			+ ", Time Taken = " + (endTime - startTime)+"\n");

startTime = endTime;

	}

writeFile(outputList);

}

private static void writeFile(List<String> stringList) {

BufferedWriter bw = null;

FileWriter fw = null;

try {

fw = new FileWriter("/Users/raffialanbezirjian/Linear.txt");

bw = new BufferedWriter(fw);

for (String line : stringList) {

bw.write(line);

bw.write("\n");

}

System.out.println(" File Writing Done");

} catch (IOException e) {

e.printStackTrace();

} finally {

try {

if (bw != null)

bw.close();

if (fw != null)

fw.close();

} catch (IOException ex) {

ex.printStackTrace();

    }

   }

  }

}

