package Algorithims;

import java.util.ArrayList;
import java.util.Collections;

public class SRJF extends Process_ATTributes {
 static  ArrayList<Integer> gain =new ArrayList<>();
    SRJF(){
        super();
    }

    public static ArrayList<Process_ATTributes> get_calculation (ArrayList<Process_ATTributes>  list ){
        int time = list.get(0).getArrival_time();
        int finish[]= new int[list.size()];
        int Burst[]= new int[list.size()];
        int k =0;
        for(int j=0;j<list.size();j++)
        Burst[j]=list.get(j).getBurst_time();

        for(int i=0;i<list.size();i++) {
            if(i!=list.size()-1) {
                if (list.get(i).getBurst_time() == 0)
                    continue;
            }
            else
            if (list.get(i).getBurst_time() == 0 && k==list.size())
                continue;
            else if (list.get(i).getBurst_time() == 0){
                i=-1;
                continue;
            }
            if ( time < list.get(i).getArrival_time()){
                if(check(list,time,i)){
                        i=-1;
                    continue;
                }
                i--;
                time+=(list.get(i+1).getArrival_time()-time);
                continue;
            }
            for (int j=0;j<list.size();j++){
                if(list.get(j).getBurst_time()<list.get(i).getBurst_time()
                        && time >= list.get(j).getArrival_time()
                        && list.get(j).getBurst_time()!=0) {
                    i = j;
                }
                else if (time >= list.get(j).getArrival_time()
                            && list.get(j).getBurst_time() == list.get(i).getBurst_time()
                            && list.get(j).getBurst_time() != 0 && list.get(i).getPID() > list.get(j).getPID()) {
                    i = j;
                }
                }

            list.get(i).setBurst_time(list.get(i).getBurst_time() - 1);
             if(list.get(i).getBurst_time()==0)
                    k++;
            time++;
            finish[i] = time;
            gain.add(list.get(i).getPID());

            if (i == list.size()-1 && k!=list.size())
                i=-1;

        }
        for (int i=0;i<list.size();i++) {
            list.get(i).setFinished_Time(finish[i]);
            list.get(i).setBurst_time(Burst[i]);
        }
            return list;
    }
    public static ArrayList<Integer> get_gain(){
        return gain;
    }
    public static boolean check(ArrayList<Process_ATTributes> list, int t,int j){
        for(int i=0;i<j;i++)
            if(t>=list.get(i).getArrival_time()&&list.get(i).getBurst_time()!=0)
                return true ;
        return false;
    }
}