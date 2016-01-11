package topic_3_3;

/**
 * - Coupling refers to how much one class knows about other.
 * - Good OO systems are loosely coupled.
 */

/**
 * To check:
 * - What is the problem with systems tightly coupled?
 * - What can be done to solve that problem?
 */
public class TestCoupling {
}

class Human {
    Remote remote = new RemoteControl();
    
    public void changeChannel() {
//        remote.currentChannel = 180; //tightly coupled approach, not desired
        remote.nextChannel(); //loosely coupled, this is what we want.
    }
}

interface Remote {
    int getCurrentChannel();
    int nextChannel();
}

class RemoteControl implements Remote {
    int currentChannel;
    
    public int getCurrentChannel() {
        return currentChannel;
    }
    
    public int nextChannel() {
        return ++currentChannel;
    }
    
    public void scanChannels() {
        System.out.println("Scanning...");
    }
}