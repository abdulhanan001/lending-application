package com.project.installmentsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Parent {
   @Id
   @GeneratedValue
   private long id;

   private String sender;

   private String receiver;

   private double totalAmount;

   @OneToMany(mappedBy = "parent")
   @JsonIgnore
   private List<Child> children;

   @Transient
   private double totalPaidAmount;

   public double getTotalPaidAmount() {
      return getChildren().stream().mapToDouble(Child::getPaidAmount).sum();
   }
}
