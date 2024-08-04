package Algorithims;
import java.util.ArrayList;
public class RR extends Process_ATTributes {
    public static  ArrayList<Integer> gain = new ArrayList<>();
    RR(){
        super();
    }

    public static ArrayList<Process_ATTributes> get_calculation(ArrayList<Process_ATTributes>  list , int t){
        int i= 0;
        int k=0;
        int time = list.get(0).getArrival_time();
        int finish[]=new int[list.size()];
        int BU[]=new int[list.size()];
        for (int j =0 ; j <list.size();j++) {
            BU[j]=list.get(j).getBurst_time();
        }
        for (i=0; i < list.size();i++) {
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
                if (time < list.get(i).getArrival_time() ){
                  if(check(list,time,i)){
                      i=-1;
                  continue;
              }

                i=-1;
                time++;
                continue;
               }
            if (list.get(i).getBurst_time()<=t) {
                time +=list.get(i).getBurst_time();
                finish[i]=time;
                for(int j=0;j<list.get(i).getBurst_time();j++)
                    gain.add( list.get(i).getPID());
                list.get(i).setBurst_time(0);
                k+=1;
            }
            else {
                time +=t;
                finish[i]=time;
                list.get(i).setBurst_time(list.get(i).getBurst_time()-t);

                for(int j=0;j<t;j++)
                    gain.add( list.get(i).getPID());
            }
            if(i==list.size()-1&&k!=list.size())
                i=-1;
        }

        for(i=0; i < list.size();i++) {
            list.get(i).setFinished_Time(finish[i]);
            list.get(i).setBurst_time(BU[i]);
        }

        return list;
    }
    public static boolean check(ArrayList<Process_ATTributes> list, int t,int j){
        for(int i=0;i<j;i++)
            if(t>list.get(i).getArrival_time()&&list.get(i).getBurst_time()!=0)
                return true ;
        return false;
    }
    public static ArrayList<Integer> getGain(){
        return gain ;
    }
}