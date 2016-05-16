package org.fetchData;

import java.util.List;

public interface PersonDAO {

	public List<Person> readById(String id);
	
	public List<Person> getAll();
}
