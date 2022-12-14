package domr3szy2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        DomReadR3SZY2 reader = new DomReadR3SZY2();
        DomWriteR3SZY2 writer = new DomWriteR3SZY2();
        DOMModifyR3SZY2 modify = new DOMModifyR3SZY2();

        try {
            writer.write("usersR3SZY2.xml");
            reader.parse(new File("usersR3SZY2.xml"));
            modify.parse("carsR3SZY2.xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}