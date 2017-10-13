package com.example.model;

import lombok.Data;

@Data
public class Book {
  private Integer id;
  private String isbn;
  private String title;
  private String description;
  private String authorFirstName;
  private String authorLastName;
  private String genre;
  private double price;

}
