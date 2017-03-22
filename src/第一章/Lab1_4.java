package µÚÒ»ÕÂ;

import java.util.Queue;

class Pet {
	private String type;

	public Pet(String type) {
		this.type = type;
	}

	public String getPetType() {
		return this.type;
	}
}

class Dog extends Pet {
	public Dog() {
		super("dog");
	}
}

class Cat extends Pet {
	public Cat() {
		super("cat");
	}
}

class PetEnterQueue {
	private Pet pet;
	private long count;

	public PetEnterQueue(Pet pet, long count) {
		this.pet = pet;
		this.count = count;
	}

	public Pet getPet() {
		return this.pet;

	}

	public long getCount() {
		return this.count;

	}

	public String getEnterType() {
		return this.pet.getPetType();
	}
}

public class Lab1_4 {
	private Queue <PetEnterQueue> dogQueue;
	private Queue <PetEnterQueue> catQueue;
	private long count;

	public Lab1_4() {
		this.dogQueue = dogQueue;
		this.catQueue = catQueue;
		this.count = 0;
	}

	public void add(Pet pet) {
		if (pet.getPetType().equals("dog")) {
			this.dogQueue.add(new PetEnterQueue(pet, this.count++));
		} else if (pet.getPetType().equals("cat")) {
			this.catQueue.add(new PetEnterQueue(pet, this.count++));
		} else {
			throw new RuntimeException("error,not dog or cat");
		}
	}

	public Pet pollAll() {
		if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
			if (this.dogQueue.peek().getCount() < this.catQueue.peek()
					.getCount()) {
				return this.dogQueue.poll().getPet();
			} else {
				return this.catQueue.poll().getPet();
			}
		} else if (!this.dogQueue.isEmpty()) {
			return this.dogQueue.poll().getPet();
		} else if (!this.catQueue.isEmpty()) {
			return this.catQueue.poll().getPet();
		} else {
			throw new RuntimeException("error,queue is empty");
		}
	}

	public Dog pollDog() {
		if (!this.dogQueue.isEmpty()) {
			return (Dog) this.dogQueue.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty");
		}
	}

	public Cat pollCat() {
		if (!this.catQueue.isEmpty()) {
			return (Cat) this.catQueue.poll().getPet();
		} else {
			throw new RuntimeException("Cat queue is empty");
		}
	}

	public boolean isEmpty() {
		return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
	}

	public boolean isDogQueueEmpty() {
		return this.dogQueue.isEmpty();
	}

	public boolean isCatQueueEmpty() {
		return this.catQueue.isEmpty();
	}
}
