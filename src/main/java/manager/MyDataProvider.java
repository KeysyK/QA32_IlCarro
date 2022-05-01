package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> validLoginData(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"arielle@mail.ru","Arielle1234$"});
        list.add(new Object[]{"lena@mail.ru", "Lena1234$"});
        list.add(new Object[]{"chris@gmail.com", "Chris1234$"});
        list.add(new Object[]{"poli@mail.ru","Poli1234$"});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validModelLogin(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("arielle@mail.ru").withPassword("Arielle1234$")});
        list.add(new Object[]{new User().withEmail("lena@mail.ru").withPassword("Lena1234$")});
        list.add(new Object[]{new User().withEmail("chris@gmail.com").withPassword("Chris1234$")});
        list.add(new Object[]{new User().withEmail("poli@mail.ru").withPassword("Poli1234$")});

        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> validLoginCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login.csv")));
        String line = reader.readLine();

        while(line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.listIterator();
    }
}
