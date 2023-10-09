package com.sapiofan.aws.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.sapiofan.aws.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepo {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Person addPerson(Person person) {
        dynamoDBMapper.save(person);
        return person;
    }

    public Person findPerson(String personId) {
        return dynamoDBMapper.load(Person.class, personId);
    }

    public String removePerson(Person person) {
        dynamoDBMapper.delete(person);
        return "Person removed: " + person.getPersonId();
    }

    public String editPerson(Person person) {
        dynamoDBMapper.save(person, buildUpdate(person));
        return "Person updated: " + person.getPersonId();
    }

    private DynamoDBSaveExpression buildUpdate(Person person) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> map = new HashMap<>();
        map.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBSaveExpression.setExpected(map);
        return dynamoDBSaveExpression;
    }
}
