package com.dreamtale.kangaroo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class Test {
    @Id
    private String testId;

    private String testItem;

    private String testMessage;

}
