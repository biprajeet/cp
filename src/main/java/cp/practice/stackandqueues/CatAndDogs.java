package cp.practice.stackandqueues;

import java.util.ArrayList;
import java.util.List;

class Animal {

	String name;
	int order;

	boolean getGreaterOrder(Animal a) {
		return this.order > a.order;
	}

	public Animal(String name) {
		this.name = name;
	}

}

class Cats extends Animal {

	public Cats(String name) {
		super(name);
	}
}

class Dogs extends Animal {

	public Dogs(String name) {
		super(name);
	}
}

public class CatAndDogs {

	List<Cats> cats;
	List<Dogs> dogs;
	int order;

	public CatAndDogs() {
		cats = new ArrayList<>();
		dogs = new ArrayList<>();
		order = 0;
	}

	void pushAnimal(Animal a) {
		a.order = order;

		if (a instanceof Cats)
			cats.add((Cats) a);
		else
			dogs.add((Dogs) a);
	}

	Animal dequeueLast() {

		if (cats.isEmpty() && dogs.isEmpty())
			return null;
		if (cats.isEmpty())
			return dequeueDogs();
		if (dogs.isEmpty())
			return dequeueCats();

		if (cats.get(cats.size() - 1).getGreaterOrder(dogs.get(dogs.size() - 1))) {
			return dequeueDogs();
		} else
			return dequeueCats();
	}

	Cats dequeueCats() {
		return cats.remove(cats.size() - 1);
	}

	Dogs dequeueDogs() {
		return dogs.remove(dogs.size() - 1);
	}

}
