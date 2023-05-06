public class test {
    
    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("basketball");
        boolean john = tries.contains("basketball");
        System.out.println(john);
        System.out.println(tries.autocomplete("bas"));
    }
}