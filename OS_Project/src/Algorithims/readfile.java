package Algorithims;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.util.*;

public class readfile {
    private File x;
    private PrintWriter PW ;
    private static int PID=0 ;
    private int ARival;
    private int Burst;
    private int Priority;
    private int r;
    private int Ded;
    private  Random k = new Random();
    private Process_ATTributes L;
    private ArrayList<Process_ATTributes> list = new ArrayList<>();
 public void openfile(){
      try {
          x = new File("Process.txt");
      }
      catch (Exception e){
         System.out.println(e);
      }
    }
public ArrayList<Process_ATTributes> readfile() throws FileNotFoundException {
      if(!x.exists()) {
          try {
              x.createNewFile();
          }

          catch (IOException e) {
              e.printStackTrace();
          }
      }
      PW = new PrintWriter(x);
    r=k.nextInt(10);
    while (r<=2)
        r=k.nextInt(10);
    for(int i=0;i<r;i++){
        ARival = k.nextInt(15);
        Burst = k.nextInt(10);
        Priority=k.nextInt(r);
        Ded=k.nextInt(50);
        if(Priority==0)
            Priority=1;
        if(Burst==0)
            Burst=1;
        Ded=k.nextInt(50);
        while(Ded<(Burst+ARival))
            Ded=k.nextInt(50);

        PW.println(String.valueOf(PID)+ " " + String.valueOf(ARival) +
                " " +String.valueOf(Burst) + " " + String.valueOf(Priority) + " " +
                String.valueOf(1) + " " +String.valueOf(Ded));

        L= new Process_ATTributes(PID,ARival,Priority,Ded,1,Burst);
        PID++;
        list.add(L);
    }
    Collections.sort(list, new Comparator<Process_ATTributes>() {
        @Override
        public int compare (Process_ATTributes p1, Process_ATTributes p2)  {
            if(p1.getArrival_time()==p2.getArrival_time())
                return Integer.valueOf(p1.getPID()).compareTo(p2.getPID());
            return  Integer.valueOf(p1.getArrival_time()).compareTo(p2.getArrival_time());
        }
    });
    return list;
}
public void closefile(){
    PW.close();
}
}
