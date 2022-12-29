package com.spring.mvc2;

import com.spring.mvc2.Validation.CheckEmail;
import jakarta.validation.constraints.*;

import java.util.HashMap;
import java.util.Map;

public class Employee {
    @Size(min = 2, message = "name must be to symbols")//длинна сколько символов
    private String name;
    //@NotEmpty(message = "surname is required valid")//проверяет, чтобы поле было заполнено
    // @NotNull
    @NotBlank(message = "surname is required valid")//проверяет, чтобы поле было заполнено и не было пробелов
    private String surname;
    @Min(value = 500, message = "must greeter min 499")
    @Max(value = 1000, message = "must greeter max 999")
    private int salary;
    private String department;
    private Map<String, String> departments;
    private String CarBrand;
    private Map<String, String> cars;
    private String[] languages;
    private Map<String, String> languagesList;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}-\\d{2}", message = "Please use pattern XXX-XX-XX-XX")//значение должно соответствовать определённому регуляр выражению
    private String phoneNumber;
    @CheckEmail(value = "xyz", message = "email must ends with xyz.com")
    private String emailAddress;


    public Employee() {//более лёгкие способы
        departments = new HashMap<>();
        departments.put("IT", "Inform Tech");
        departments.put("HR", "Human Resources");
        departments.put("Sales", "Sale");
        cars = new HashMap<>();
        cars.put("CarBrand", "Reno");
        cars.put("BMW", "BMW");
        cars.put("Shoda", "Karoq");
        languagesList = new HashMap<>();
        languagesList.put("English", "EN");
        languagesList.put("Deatch", "DE");
        languagesList.put("French", "FR");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String, String> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(Map<String, String> languagesList) {
        this.languagesList = languagesList;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getCars() {
        return cars;
    }

    public void setCars(Map<String, String> cars) {
        this.cars = cars;
    }

    public String getCarBrand() {
        return CarBrand;
    }

    public void setCarBrand(String carBrand) {
        CarBrand = carBrand;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
