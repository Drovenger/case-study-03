package test;

import main.java.util.DBHandle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBHandleTest {

    @Test
    void getConnection() {
        System.out.println(DBHandle.getConnection());
    }
}