package com.example.SpringAmigoscode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository  extends JpaRepository<Customer,Integer>
{

}
