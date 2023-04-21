package com.bassure.hibernate.ormapp;

import com.bassure.hibernate.model.Employee;
import com.bassure.hibernate.practices.Book;
import com.bassure.hibernate.practices.BookCopies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrmApp {

    static EntityManager em = null;
    static EntityTransaction tx = null;
    static EntityManagerFactory emf = null;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("orm-app");

        Employee ww = new Employee(0, "ram", "ram@mail.com", 4567893489L);
//        viewEmployees();
//        addEmployee(ww);
//        viewEmployees();
        viewBooks();
    }

    public static void viewEmployees() {
        em = emf.createEntityManager();

        List<Employee> empl = em.createQuery("SELECT e from Employee e", Employee.class).getResultList();

        empl = empl
                .stream()
                .filter((e) -> e.getEmployee() == 101)
                .collect(Collectors.toList());

        for (Employee employee : empl) {
            System.out.println(employee);
        }
    }

    public static void viewBooks() {
        em = emf.createEntityManager();

        List<Book> bo = em.createQuery("SELECT b from Book b where b.title > :tt", Book.class)
                .setParameter("tt", "Harry potter")
                .getResultList();
//        List<BookCopies> bocop = em.createQuery("SELECT bc from BookCopies bc", BookCopies.class).getResultList();

        bo.forEach(x-> System.out.println(x));
//        bo = bo.stream().map((x) -> x).collect(Collectors.toList());
//        System.out.println(bo);

        System.out.println("-".repeat(100));
//        bocop = bocop.stream().map((x) -> x).collect(Collectors.toList());
//        bocop.forEach(e -> System.out.println(e));
    }

    public static void addEmployee(Employee ww) {
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(ww);
            tx.commit();
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
}
