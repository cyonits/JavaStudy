import java.lang.reflect.Field;

public class PrivateClass {
    private int field_1;
    private int field_2;
    private int field_3;
    public PrivateClass(){
        this.field_1 = 1;
        this.field_2 = 2;
        this.field_3 = 3;
    }

    public void noIllegalAccessExceptionTest(PrivateClass privateClass) throws IllegalAccessException {
        Field[] fields = privateClass.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.get(privateClass);
        }
    }
}
