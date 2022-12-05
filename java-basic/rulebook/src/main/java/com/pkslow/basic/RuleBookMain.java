package com.pkslow.basic;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class RuleBookMain {
    public static void main(String[] args) {
        RuleBook ruleBook = RuleBookBuilder.create()
                .addRule(rule -> rule.withNoSpecifiedFactType()
                        .then(f -> System.out.println("Hello "))
                        .then(f -> System.out.println("Pkslow")))
                .build();

        ruleBook.run(new FactMap());
    }
}