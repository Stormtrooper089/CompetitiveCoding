class GenericCheckJI<T> {
    public void print(Object o){
        System.out.println("In the generic class " + o);
    }

}
class GenericSon extends GenericCheckJI{
    public void print(String o){
        System.out.println("In the son class " +o);
    }

}
class GenericCheck{
    public static void main(String [] args){
        GenericCheckJI check = new GenericSon();
        check.print(5);
        check.print(check);
        check.print(null);
        check.print("g");


    }

}
