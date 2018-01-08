package com.hss.di.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Department {
	private int id;

	private String[] person;

	private Person[] person_arr;

	private List<Person> person_list;

	private Set<Person> person_set;

	private Map<String, Object> person_map;

	private Properties pp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getPerson() {
		return person;
	}

	public void setPerson(String[] person) {
		this.person = person;
	}

	public Person[] getPerson_arr() {
		return person_arr;
	}

	public void setPerson_arr(Person[] person_arr) {
		this.person_arr = person_arr;
	}

	public List<Person> getPerson_list() {
		return person_list;
	}

	public void setPerson_list(List<Person> person_list) {
		this.person_list = person_list;
	}

	public Set<Person> getPerson_set() {
		return person_set;
	}

	public void setPerson_set(Set<Person> person_set) {
		this.person_set = person_set;
	}

	public Properties getPp() {
		return pp;
	}

	public void setPp(Properties pp) {
		this.pp = pp;
	}

	public Map<String, Object> getPerson_map() {
		return person_map;
	}

	public void setPerson_map(Map<String, Object> person_map) {
		this.person_map = person_map;
	}

}
