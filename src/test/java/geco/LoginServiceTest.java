package geco;

import  org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LoginServiceTest {

   private static final String ANEM = "ANEM";
   private static final String ABIL = "ABIL";
   private LoginService aloginservice;

    @Before

    public void setUp() throws Exception
    {


            String[] machaine = new String[1];
            machaine[0] = "ANEM";
            aloginservice = new LoginService(machaine);

    }

    @org.junit.Test

    public void loginExists() throws Exception
    {

        boolean mybool = aloginservice.loginExists(ANEM);
        Assert.assertTrue(mybool);
        mybool = aloginservice.loginExists(ABIL);
        Assert.assertFalse(mybool);
    }

    public void addLogin() throws Exception
    {
        aloginservice.addLogin("BBB");
        aloginservice.addLogin("BBB");
        List<String> allLogins = aloginservice.findAllLogins();
        Assert.assertEquals(3, allLogins.size());

    }


    public void findAllLoginsStartingWith() throws Exception {

        List<String> allLogins = aloginservice.findAllLoginsStartingWith("B");
        Assert.assertEquals(1,allLogins.size());
        aloginservice.addLogin("BBB");
        allLogins = aloginservice.findAllLoginsStartingWith("B");
        Assert.assertEquals(2,allLogins.size());
        allLogins = aloginservice.findAllLoginsStartingWith("A");
        Assert.assertEquals(0,allLogins.size());
    }

    public void findAllLogin() throws Exception {
        List<String> allLogins = aloginservice.findAllLogins();
        Assert.assertEquals(1,allLogins.size());
        aloginservice.addLogin("BBB");
        allLogins = aloginservice.findAllLogins();
        Assert.assertEquals(2,allLogins.size());
    }

}