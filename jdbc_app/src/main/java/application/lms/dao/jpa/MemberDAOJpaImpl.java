package application.lms.dao.jpa;

import application.lms.LMSApplication;
import application.lms.dao.MemberInfoDAO;
import application.lms.model.jpaModel.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MemberDAOJpaImpl implements MemberInfoDAO {

    BufferedReader userChoice = LMSApplication.SELECT_CHOICE;
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lms");
    static EntityManager em = null;
    static EntityTransaction tx = null;

    @Override
    public void memberOption() throws IOException {
        while (true) {
            try {
                System.out.println("------------------------------");
                System.out.println("|   Library Members Details  |");
                System.out.println("------------------------------");

                System.out.println("1. View Members");
                System.out.println("2. View Member");
                System.out.println("3. Add Member");
                System.out.println("4. Remove Member");
                System.out.println("5. Exit to BookMenu");

                System.out.print("\n" + "Select Operation : ");

                String select = userChoice.readLine();
                switch (select) {
                    case "1":
                        System.out.println("View Members");
                        System.out.println("-----------");
                        viewMembers();
                        break;
                    case "2":
                        System.out.println("View Member");
                        System.out.println("-----------");
                        System.out.print("Enter the MemberID : ");
                        try {
                            viewMember(Integer.parseInt(userChoice.readLine()));
                        } catch (NumberFormatException nfe) {
                            System.out.println("\n" + "Please enter correct input" + "\n");
                        }
                        break;
                    case "3":
                        System.out.println("Add Member");
                        System.out.println("----------");
                        addMember();
                        break;
                    case "4":
                        System.out.println("Remove Member");
                        System.out.println("-------------");
                        System.out.print("Enter the Member-ID : ");
                        removeMember(Integer.parseInt(userChoice.readLine()));
                        break;
                    case "5":
                        LMSApplication.options();
                        break;
                    default:
                        System.out.println("Please Read The Menuscript and Enter again!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void viewMembers() {
        em = emf.createEntityManager();
        List<Member> member = em.createQuery("SELECT m FROM Member m").getResultList();

        System.out.println("-".repeat(83));
        System.out.println(String.format("%-17s%-15s%-15s%-12s%-19s%-12s", "MemberId", "Name", "Age", "Gender", "Mobile", "MemberStatus"));
        System.out.println("-".repeat(83));
        member.forEach(x -> System.out.println(String.format("%-17s%-15s%-15s%-12s%-19s%-12s", x.getMemberId(), x.getName(), x.getAge(), x.getGender(), x.getNumber(), x.getMeberStatus())));
        System.out.println("-".repeat(83));
    }

    @Override
    public void viewMember(int id) throws IOException {
        boolean isAval = false;
        em = emf.createEntityManager();
        List<Member> member = em.createQuery("SELECT m FROM Member m").getResultList();

        for (Member m : member) {
            if (m.getMemberId() == id) {
                isAval = true;
                displayMember(m);
            }
        }
        if (!isAval) {
            System.out.print("Enter the another Member id or E/e to exit : ");
            String newid = userChoice.readLine();
            if ("e".equalsIgnoreCase(newid)) {
                memberOption();
            } else {
                viewMember(Integer.parseInt(newid));
            }
        }
    }

    public void displayMember(Member m) {
        System.out.println("\n" + "*".repeat(42));
        System.out.println("This is the details of the Member you need");
        System.out.println("*".repeat(42));
        System.out.println("Member Id : " + m.getMemberId());
        System.out.println("Name      : " + m.getName());
        System.out.println("Age       : " + m.getAge());
        System.out.println("Gender    : " + m.getGender());
        System.out.println("*".repeat(42) + "\n");
    }

    @Override
    public void addMember() throws IOException {
        Member me = null;
        em = emf.createEntityManager();
        tx = em.getTransaction();
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
            tx.begin();
            em.persist(me);
            tx.commit();
            System.out.println("\n" + "New Member added Successfully" + "\n");
            System.out.println("press 0 to main menu or enter 1 to add another Member");
            String userchoice = userChoice.readLine();
            if (userchoice.equals("0")) {
                memberOption();
            } else {
                addMember();
            }
        } catch (Exception e) {
            if (Objects.nonNull(tx) && tx.isActive()) {
                tx.rollback();
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

    @Override
    public void removeMember(int id) throws IOException {
        em = emf.createEntityManager();

        Member member = em.find(Member.class, id);

        em.getTransaction().begin();
        if (Objects.nonNull(member) && member.getMemberId() == id && member.getMeberStatus().equals("Available")) {
            Member c = em.find(Member.class, id);
            c.setMeberStatus("Removed");
            System.out.println("Member is Removed");
        } else {
            System.out.println("There is no member to delete");
        }
        em.getTransaction().commit();
    }
}
