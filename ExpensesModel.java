package com.striim.ec;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ExpensesModel {

    private String description;
    private String currencyType;
    private Double amount;
    private LocalDate date;

}
