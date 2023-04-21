
import application.lms.model.jpaModel.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLms {

    BufferedReader userChoice = new BufferedReader(new InputStreamReader(System.in));
    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms");
    private static EntityManager em = null;
    private List<Member> member = null;

    @BeforeAll
    public static void persistenceObjTest() {
        em = emf.createEntityManager();
        Assert.assertNotNull(em);
    }

//    @AfterAll
//    public static void persistenceObjTest1() {
//        em = emf.createEntityManager();
//        Assert.assertNull(em);
//    }
    
    @Test
    public void viewMembersTest() {
        em = emf.createEntityManager();
        member = em.createQuery("SELECT m FROM Member m").getResultList();

        for (Member mem : member) {
            Assert.assertNotNull(mem);
        }
        em.close();
    }

    @Test
    public void viewMemberTest(int id) throws IOException {
        boolean isAval = false;
        em = emf.createEntityManager();

        for (Member m : member) {
            if (m.getMemberId() == id) {
                Assert.assertEquals(101, id);
                isAval = true;
                displayMemberTest(m);
            }
        }
        if (!isAval) {
            System.out.print("Enter the another Member id or E/e to exit : ");
            String newid = userChoice.readLine().toLowerCase();
            if ("e".equalsIgnoreCase(newid)) {
                Assert.assertEquals("e", newid);
            } else {
                Assert.assertEquals("101", newid);
                viewMemberTest(Integer.parseInt(newid));
            }
        }
    }

    @Test
    public void displayMemberTest(Member m) {
        Assert.assertEquals(new Member(101, "Dhinakaran", 23, "male", 6374138887L), m);
    }

    @Test
    @DisplayName(value = "Check ")
    public void addMemberTest() throws IOException {
        Member me = null;
        em = emf.createEntityManager();
        try {
            System.out.print("Enter the Name : ");
            String name = userChoice.readLine();
            System.out.print("Enter the Age : ");
            int age = Integer.parseInt(userChoice.readLine());
            System.out.print("Enter the Gender : ");
            String gender = userChoice.readLine();
            System.out.print("Enter the Moblie No : ");
            long number = Long.parseLong(userChoice.readLine());
            me = new Member(0, name, age, gender, number);
        } catch (NumberFormatException | IOException nfe) {
            System.out.println("Input Mismatch Error, Please enter currect input");
        }
        try {
            em.getTransaction().begin();
            em.persist(me);
            em.getTransaction().commit();
            System.out.println("\n" + "New Member added Successfully" + "\n");
            System.out.println("press 0 to main menu or enter 1 to add another Member");
            String userchoice = userChoice.readLine();
            if (userchoice.equals("0")) {
//                memberOption();
            } else {
                addMemberTest();
            }
        } catch (IOException e) {
            if (Objects.nonNull(em.getTransaction()) && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(em)) {
                try {
                    em.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
//
//    @Test
//    public void removeMemberTest(int id) throws IOException {
//        em = emf.createEntityManager();
//
//        Member member = em.find(Member.class, id);
//
//        em.getTransaction().begin();
//        if (Objects.nonNull(member) && member.getMemberId() == id && member.getMeberStatus().equals("Available")) {
//            Member c = em.find(Member.class, id);
//            c.setMeberStatus("Removed");
//            System.out.println("Member is Removed");
//        } else {
//            System.out.println("There is no member to delete");
//        }
//        em.getTransaction().commit();
//    }
}
