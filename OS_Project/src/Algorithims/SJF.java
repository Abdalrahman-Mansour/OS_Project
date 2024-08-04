package Algorithims;

import java.util.ArrayList;

public class SJF extends Process_ATTributes{
    static ArrayList<Integer> gain = new ArrayList<>();
    SJF(){
        super();
    }
    public static ArrayList<Process_ATTributes> get_Calculations(ArrayList<Process_ATTributes> list){
        int time =list.get(0).getArrival_time();
        int i=0;
        int finish[]=new int[list.size()];
        int BU[]=new int[list.size()];
        for (int j =0 ; j <list.size();j++) {
            BU[j]=list.get(j).getBurst_time();
        }
        int k=0;

        for(i=0;i<list.size();i++){
            if(i!=list.size()-1) {
                if (list.get(i).getBurst_time() == 0)
                    continue;
            }
           else {
                    if (list.get(i).getBurst_time() == 0 && k == list.size())
                        continue;
                    else if (list.get(i).getBurst_time() == 0) {
                        i = -1;
                        continue;
                    }
                }

            if ( time < list.get(i).getArrival_time()){
                if(check(list,time)){
                        i=-1;
                    continue;
                }
                i=-1;
                time++;
                continue;
            }
            for(int j=0;j<list.size();j++) {
                if (time >= list.get(j).getArrival_time()
                        && list.get(j).getBurst_time() < list.get(i).getBurst_time()
                        && list.get(j).getBurst_time() != 0){
                    i = j;
                   }
                else if (time >= list.get(j).getArrival_time()
                            && list.get(j).getBurst_time() == list.get(i).getBurst_time()
                            && list.get(j).getBurst_time() != 0 && list.get(i).getPID() > list.get(j).getPID()){
                            i=j;
                }
                }




           time+=list.get(i).getBurst_time();
           finish[i]=time;
           k+=1;
           list.get(i).setBurst_time(0);
           for (int j=0;j<BU[i];j++)
               gain.add(list.get(i).getPID());

            if(i==list.size()-1 && k!=list.size())
                i=-1;
        }
        for( i=0; i < list.size();i++) {
            list.get(i).setFinished_Time(finish[i]);
            list.get(i).setBurst_time(BU[i]);
        }


        return list;
    }
    public static boolean check(ArrayList<Process_ATTributes> list, int t){
        for(int i=0;i<list.size();i++)
            if(t>=list.get(i).getArrival_time()&&list.get(i).getBurst_time()!=0)
                return true ;
        return false;
    }
    public static ArrayList<Integer> getGain() {
        return gain;
    }
}
