package Algorithims;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class EP extends Process_ATTributes {
    static ArrayList<Integer> Gain=new ArrayList<>();
    EP(){
        super();
    }
    public static void get_calculation(ArrayList<Process_ATTributes> list){
    Random r = new Random();
    int rand=r.nextInt(2);
    System.out.println(rand);
    int time = list.get(0).getArrival_time();
    int i =0;
    int k=0;
    int finish[]=new int[list.size()];
    int BU[]=new int[list.size()];
    int Prio[]=new int[list.size()];
    for (int j=0;j<list.size();j++) {
        BU[j] = list.get(j).getBurst_time();
        Prio[j]=list.get(j).getInterval_time();
    }
    for (i=0;i<list.size();i++){
        if(i!=list.size()-1) {
            if (list.get(i).getBurst_time() == 0)
                continue;
        }
        else
        if (list.get(i).getBurst_time() == 0 &&k==list.size())
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

        for(int j=0;j<list.size();j++){
          if(time>=list.get(j).getArrival_time()&&
          list.get(i).getInterval_time()>list.get(j).getInterval_time() &&
          list.get(j).getBurst_time()!=0){
              list.get(i).setInterval_time(list.get(i).getInterval_time()-rand);
              i=j;}
        else if (time>=list.get(j).getArrival_time()&&
                      list.get(i).getInterval_time()==list.get(j).getInterval_time() &&
                      list.get(j).getBurst_time()!=0 && list.get(i).getPID() > list.get(j).getPID()){
                  list.get(i).setInterval_time(list.get(i).getInterval_time()-rand);
                  i=j;
          }
        }
        time++;
        for(int j=0;j<list.size();j++){
        if (j==i)
            continue;
        if(time>=list.get(j).getArrival_time())
            list.get(j).setInterval_time(list.get(j).getInterval_time()-rand);
        }

        finish[i]=time;
        Gain.add(list.get(i).getPID());
      list.get(i).setBurst_time(list.get(i).getBurst_time()-1);
      if(list.get(i).getBurst_time()==0)
          k++;
      if(i==list.size()-1 && k!=list.size())
          i=-1;
    }
    for(i=0; i < list.size();i++) {
            list.get(i).setFinished_Time(finish[i]);
            list.get(i).setBurst_time(BU[i]);
            list.get(i).setInterval_time(Prio[i]);
        }


    }
    public static boolean check(ArrayList<Process_ATTributes> list, int t,int j){
        for(int i=0;i<j;i++)
            if(t>=list.get(i).getArrival_time()&&list.get(i).getBurst_time()!=0)
                return true ;
        return false;
    }
    public static ArrayList<Integer> getGain(){
        return Gain;
    }
}
