package org.example;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        //User user = new User();
        //user.setEmail("email.com");
        //user.setUserName("igor");
        //user.setPassword("123445");

        //session.persist(user);
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();


    }
}