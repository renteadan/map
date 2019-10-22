package com.company;

import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.Repository;

public class Main {

    public static void main(String[] args) {
        Repository<String,Student<String>> repo = new Repository<>();
        Student<String> st = new Student<String>("1","Dan", "Rentea","226","Secret");
        try {
            repo.save(st);
            System.out.println(repo.findOne("1").getFirstName());
        } catch (ValidationException e)
        {
            System.out.println(e.getMessage());
        }
	// write your code here
    }
}
