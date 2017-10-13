package com.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

  private int id;
  private String userName;
  private String firstName;
  private String lastName;
  private Date activeOn;

}
