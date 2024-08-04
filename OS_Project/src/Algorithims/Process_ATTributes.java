package Algorithims;

import java.util.ArrayList;

public class Process_ATTributes  {
    private int PID ;
    private int Arrival_time;
    private int burst_time;
    private int rebeat;
    private int interval_time ;
    private int deadline ;
    private int TA;
    private int Finished_Time;
    private double WTA;
    static double WTAavg=0;
    private int wait;
    private static double TAavg=0;
    private static double Waitavg=0;
    private static ArrayList<Process_ATTributes> list = new ArrayList<>();
    public int getTA() {
        return TA;
    }
    public void setTA(int tA) {
        TA = tA;
    }
    public int getFinished_Time() {
        return Finished_Time;
    }
    public void setFinished_Time(int finished_Time) {
        Finished_Time = finished_Time;
    }
    public double getWTA() {
        return WTA;
    }
    public void setWTA(double wTA) {
        WTA = wTA;
    }
    public int getWait() {
        return wait;
    }
    public void setWait(int wait) {
        this.wait = wait;
    }
    public Process_ATTributes(int PID, int Arrival_time, int interval_time, int deadline, int rebeat, int burst_time){
        this.PID=PID;
        this.burst_time=burst_time;
        this.deadline=deadline;
        this.Arrival_time=Arrival_time;
        this.rebeat=rebeat;
        this.interval_time=interval_time;
        list.add(this);

    }
    Process_ATTributes(){}

    public int getPID() {
        return PID;
    }


    public void setPID(int pID) {
        PID = pID;
    }


    public int getArrival_time() {
        return Arrival_time;
    }


    public void setArrival_time(int arrival_time) {
        Arrival_time = arrival_time;
    }


    public int getBurst_time() {
        return burst_time;
    }


    public void setBurst_time(int burst_time) {
        this.burst_time = burst_time;
    }


    public int getRebeat() {
        return rebeat;
    }


    public void setRebeat(int rebeat) {
        this.rebeat = rebeat;
    }


    public int getInterval_time() {
        return interval_time;
    }


    public void setInterval_time(int interval_time) {
        this.interval_time = interval_time;
    }


    public int getDeadline() {
        return deadline;
    }


    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }
    public static void Calculation(ArrayList<Process_ATTributes> Process) {
        for(int i=0; i< Process.size();i++) {
            Process.get(i).setTA(Process.get(i).getFinished_Time()-Process.get(i).getArrival_time());
            if(Process.get(i).getTA() > Process.get(i).getBurst_time() )
            Process.get(i).setWait(Process.get(i).getTA()-Process.get(i).getBurst_time());
            else
                Process.get(i).setWait(0);
            Process.get(i).setWTA((double) Process.get(i).getTA()/Process.get(i).getBurst_time());
            Waitavg+=Process.get(i).getWait();
            TAavg+=Process.get(i).getTA();
            WTAavg+=Process.get(i).getWTA();
        }
        Waitavg/=Process.size();
        TAavg/=Process.size();
        WTAavg/=Process.size();
    }
    public double get_Waitavg() {
        return Waitavg;
    }
    public double get_Tatavg() {
        return TAavg;    }
    public ArrayList<Process_ATTributes> getList() {
        return list;
    }
    public double get_WTavg() {
        return WTAavg;    }
}
