package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		int res1 = 0, res2 = 0;
		while(res1 != 3) {
			System.out.println("\n=========================================");
			System.out.println("Accessing the database: Which table do you want to modify? \n1 -> Seller\n2 -> Department\n3 -> Exit");
			System.out.print("Your answer: ");
			res1 = sc.nextInt();
			System.out.println();
			
			switch(res1) {
			case 1:
				System.out.println("========================================="); 
				System.out.println("\nChoose an action:\n1 -> Find seller by Id\n2 -> Find seller by Department\n3 -> Find all seller");
				System.out.print("4 -> Seller insert\n5 -> Seller update\n6 -> Seller delete\nYour answer: ");
				res2 = sc.nextInt();
				System.out.println();
				switch(res2) {
				case 1:
					System.out.print("Enter an Id for find seller: ");
					int id1 = sc.nextInt();
					Seller seller = sellerDao.findById(id1);
					System.out.println();
					System.out.println(seller);
					break;
					
				case 2:
					System.out.print("Department's Name: ");
					String name1 = sc.next();
					System.out.print("\nDepartment's Id: ");
					int id2 = sc.nextInt();
					Department department = new Department(id2, name1);
					List<Seller> list1 = sellerDao.findByDepartment(department);
					for(Seller obj : list1) {
						System.out.println(obj);
					}
					break;
					
				case 3:
					System.out.println("\nAll sellers in the database: ");
					List<Seller> list2 = sellerDao.findAll();
					for(Seller obj : list2) {
						System.out.println(obj);
					}
					break;
					
				case 4:
					System.out.print("Seller's name: ");
					String name2 = sc.next();
					System.out.print("Seller's email: ");
					String name3 = sc.next();
					System.out.print("Seller's base salary: ");
					double salary1 = sc.nextDouble();
					System.out.print("Seller's id department: ");
					int id3 = sc.nextInt();
					Seller newSeller = new Seller(null, name2, name3, new Date(), salary1, new Department(id3, null));
					sellerDao.insert(newSeller);
					System.out.println("\nInserted! New id = " + newSeller.getId());
					break;
					
				case 5:
					System.out.print("Enter seller id for update: ");
					int id4 = sc.nextInt();
					Seller sellerUpdate = sellerDao.findById(id4);
					System.out.print("\nEnter new seller's name for update: ");
					String name5 = sc.next();
					sellerUpdate.setName(name5);
					System.out.print("\nEnter new seller's email for update: ");
					String email1 = sc.next();
					sellerUpdate.setEmail(email1);
					sellerDao.update(sellerUpdate);
					System.out.println("\nUpdate completed");
					break;
					
				case 6:
					System.out.print("Enter id for delete: ");
					int id = sc.nextInt();
					sellerDao.deleteById(id);
					System.out.println("\nDelete completed");
					break;
				}
				break;
				
			case 2:
				System.out.println("========================================="); 
				System.out.println("\nChoose an action:\n1 -> Find department by Id\n2 -> Find all department");
				System.out.print("3 -> Department insert\n4 -> Department update\n5 -> Department delete\nYour answer: ");
				int res3 = sc.nextInt();
				System.out.println();
				switch(res3) {
				case 1:
					System.out.print("Enter an Id for find department: ");
					int id5 = sc.nextInt();
					Department dep = departmentDao.findById(id5);
					System.out.println();
					System.out.println(dep);
					break;
					
				case 2:
					System.out.println("\nAll departments in the database: ");
					List<Department> list3 = departmentDao.findAll();
					for(Department obj : list3) {
						System.out.println(obj);
					}
					break;
					
				case 3:
					System.out.print("Department's name: ");
					String name6 = sc.next();
					Department newDepartment = new Department(null, name6);
					departmentDao.insert(newDepartment);
					System.out.println("\nInserted! New id = " + newDepartment.getId());
					break;
					
				case 4:
					System.out.print("Enter department id for update: ");
					int id6 = sc.nextInt();
					Department departmentUpdate = departmentDao.findById(id6);
					System.out.print("\nEnter new department's name for update: ");
					String name7 = sc.next();
					departmentUpdate.setName(name7);
					departmentDao.update(departmentUpdate);
					System.out.println("\nUpdate completed");
					break;
					
				case 5:
					System.out.print("Enter id's department for delete: ");
					int id7 = sc.nextInt();
					departmentDao.deleteById(id7);
					System.out.println("\nDelete completed");
					break;
				}
				break;
				
			case 3:
				System.out.println("Exiting\n=======================");
				break;
			}
		}
		
		sc.close();

	}

}
