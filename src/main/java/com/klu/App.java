package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load Spring Container
        @SuppressWarnings("resource")
		ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Course Bean from Spring
        Course course = context.getBean("course", Course.class);

        // Take runtime input
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Academic Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        // Create Student object manually
        Student student = new Student(id, name, year);

        // Setter Injection manually
        student.setCourse(course);
        student.setEmail(email);
        student.setPhoneNumber(phone);

        // Display
        student.display();

        sc.close();
    }
}
