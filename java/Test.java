class A extends Thread{
    public void m1(){
        for(int i = 0; i<5; i++) System.out.println("m1 of A : "+i +" "+Thread.currentThread());
    }
    // public void m2(){
    //     for(int i = 0; i<5; i++) System.out.println("m2 of A : "+i +" "+Thread.currentThread());
    // }

    @Override
    public void run(){
        m1();
        // m2();
    }
}

class B extends Thread{
    public void m1(){
        int x = 1/0;
        for(int i = 0; i<5; i++) System.out.println("m1 of B : "+i +" "+Thread.currentThread());
    }
    public void m2(){
        for(int i = 0; i<5; i++) System.out.println("m2 of B : "+i +" "+Thread.currentThread());
    }
    @Override
    public void run(){
        m1();
        m2();
    }
}

public class Test {

     public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
     }
}