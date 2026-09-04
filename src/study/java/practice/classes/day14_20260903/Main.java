package study.java.practice.classes.day14_20260903;

public class Main {
    public static void main(String[] args) {
        /*
         カプセル化された fieldA が用意されています。
         このコードに、ゲッターを記述して paiza と出力するコードを追加してください。。
        */
        SampleClass o1 = new SampleClass("paiza");

        System.out.println(o1.getFieldA());

        /*
         このコードに、セッターを記述して paizaA と出力するコードを追加してください。
        */
        o1.setFieldA("paizaA");
        System.out.println(o1.getFieldA());
    }
}

class SampleClass {
    private String fieldA;

    public SampleClass(String fieldA) {
        this.fieldA = fieldA;
    }

    public void setFieldA(String s) {
        fieldA = s;
    }

    //　この下にゲッターを記述する
    public String getFieldA() { return fieldA; }
}

