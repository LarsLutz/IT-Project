package server;

public class NotifyObject {

    MonitorObject monitorObject = new MonitorObject();

    public void doWait(){
        synchronized(monitorObject){
            try{
                monitorObject.wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void doNotify(){
        synchronized(monitorObject){
            monitorObject.notifyAll();
        }
    }
}