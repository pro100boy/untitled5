import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("INSERT INTO 'user' ('name', 'age', 'isAdmin', 'createdDate') VALUES");
       // (4, 'Paul Sidorov', 28, b'0', '2016-10-15 19:30:01'),
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("c:\\new.txt")))
        {
            while (bufferedReader.ready())
            {
                User usr = new User();
                usr.setName(bufferedReader.readLine());
                int ag = (int) (Math.random() * 100);
                usr.setAge(ag < 18 ? ag+20 : ag);
                usr.setIsAdmin((int) (Math.random() * 100) % 2 == 0 ? true : false);
                usr.setCreatedDate(new Timestamp(new Date().getTime()));
                System.out.println("('"+usr.getName()+"',"+usr.getAge()+",b'"+usr.getIsAdmin()+"','"+usr.getCreatedDate()+"'),");
                //System.out.println(usr);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
