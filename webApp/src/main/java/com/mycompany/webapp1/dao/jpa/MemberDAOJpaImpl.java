package com.mycompany.webapp1.dao.jpa;

import com.mycompany.webapp1.jpaModel.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MemberDAOJpaImpl {

    static EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("lms");
    static EntityManager em = null;
    static EntityTransaction tx = null;

    public MemberDAOJpaImpl() {
        super();
    }
    
    public List<Member> viewMembers() {
        em = emf.createEntityManager();
        List<Member> members = em.createQuery("SELECT m FROM Member as m").getResultList();
        return members;
    }

    public Member viewMember(int id) throws IOException {
        em = emf.createEntityManager();
        List<Member> member = em.createQuery("SELECT m FROM Member m").getResultList();

        for (Member m : member) {
            if (m.getMemberId() == id) {
                return new Member(m.getMemberId(), m.getName(), m.getAge(), m.getGender(), m.getNumber());
            }
        }
        return null;
    }

    public void addMember(Member m) throws IOException {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(m);
            tx.commit();
            System.out.println("\n" + "New Member added Successfully" + "\n");
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

    public void removeMember(int id) throws IOException {
        em = emf.createEntityManager();

        Member member = em.find(Member.class, id);

        em.getTransaction().begin();
        if (Objects.nonNull(member) && member.getMemberId() == id && member.getMemberStatus().equals("Available")) {
            Member c = em.find(Member.class, id);
            c.setMemberStatus("Removed");
            System.out.println("Member is Removed");
        } else {
            System.out.println("There is no member to delete");
        }
        em.getTransaction().commit();
    }
}
