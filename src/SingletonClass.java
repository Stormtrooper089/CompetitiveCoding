import java.io.Serializable;

public class SingletonClass implements Serializable {

    private static SingletonClass  singleton = null;
    private void SingletonClass(){

    }

    public static  SingletonClass getInstance(){
        if(singleton == null){
            synchronized (SingletonClass.class){
                if(singleton == null){
                    return  new SingletonClass();
                }
            }
        }
        return singleton;
    }

    protected Object readResolve(){
        return getInstance();
    }

}
