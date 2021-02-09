package com.seriveImpl;

import java.util.Scanner;

import org.hibernate.Session;

import com.model.Employee;
import com.serivce.Operation;
import com.utility.HibernateUtil;

public class OperationI implements Operation {

	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void addData() {

		System.out.print("How many employee you want to add : ");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			Employee emp = new Employee();
			System.out.print("Enter Name : ");
			emp.setEname(sc.next());
			System.out.print("Enter Designation : ");
			emp.setDesg(sc.next());
			System.out.print("Enter Salary : ");
			emp.setSal(sc.nextDouble());
			session.save(emp);
			session.beginTransaction().commit();
		}
		System.out.println("Employee Addedd successfully..!");

	}

	@Override
	public void viewData() {

		System.out.print("Enter Employee Id: ");
		int id = sc.nextInt();
		System.out.println("---------------------");
		Employee empl = session.get(Employee.class, id);
		System.out.println("Employee Id : " + empl.getEid());
		System.out.println("Name : " + empl.getEname());
		System.out.println("Designation : " + empl.getDesg());
		System.out.println("Salary : " + empl.getSal());
		System.out.println("---------------------");
	}

}
