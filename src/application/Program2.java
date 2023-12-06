package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 2: department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new Id: " + newDepartment.getId());

				
		System.out.println("\n=== TEST 3: department delete ===");
		System.out.println("Enter Id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		System.out.println("\n=== TEST 4: department findById");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== TEST 5: department update ===");
		department = departmentDao.findById(7);
		department.setName("Notebooks");
		departmentDao.update(department);
		System.out.println("Update Completed!");
		
		sc.close();
	}

}
