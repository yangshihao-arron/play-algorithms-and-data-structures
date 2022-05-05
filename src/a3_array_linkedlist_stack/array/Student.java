package a3_array_linkedlist_stack.array;

public class Student implements Comparable<Student>{
    private String name;
    private int score;
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Student another){

//        if(this.score < another.score)
//            return -1;
//        else if(this.score == another.score)
//            return 0;
//        return 1;

        //return this.score - another.score; //递增排序
        return another.score - this.score; //递减
    }
    @Override
    public boolean equals(Object student){
        if(this == student) return true;
        if(student == null) return false;
        if(this.getClass() != student.getClass()) return false;
        Student another = (Student)student;
        return this.score == another.score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {

        Array<Student> arr = new Array<>();
        Student student1 = new Student("alice",100);
        Student student2 = new Student("bob",66);
        Student student3 = new Student("Charlie",88);
        Student student4 = new Student("Charlie",88);

        arr.addLast(student1);
        arr.addLast(student2);
        arr.addLast(student3);
        System.out.println(arr);
        arr.removeElement(student4);
        System.out.println(arr);
    }
}
