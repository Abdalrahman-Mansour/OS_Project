package Algorithims;
import java.util.ArrayList;
public class FCFS extends Process_ATTributes {
    static ArrayList<Integer> gain=new ArrayList<>();
    FCFS() {
        super();
    }

    public static void get_calculation(ArrayList<Process_ATTributes> list) {
        int timef;
        int i = 0;
        list.get(i).setFinished_Time(list.get(i).getArrival_time() + list.get(i).getBurst_time());
        for (int j=0;j<list.get(0).getBurst_time();j++)
            gain.add(list.get(0).getPID());
        timef = list.get(i).getFinished_Time();
        for (i = 1; i < list.size(); i++) {
            if(timef>list.get(i).getArrival_time())
                list.get(i).setFinished_Time(timef + list.get(i).getBurst_time());
            else
                list.get(i).setFinished_Time(list.get(i).getArrival_time() + list.get(i).getBurst_time());
            timef = list.get(i).getFinished_Time();
            for (int j=0;j<list.get(i).getBurst_time();j++)
                gain.add(list.get(i).getPID());

        }
    }
    public static ArrayList<Integer> getGain(){
        return gain;
    }
}