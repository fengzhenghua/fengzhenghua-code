package com.devil.design;

public class AnimalTest {
	
	public static void main(String[] args) {
		AnimalFactory animalFactory = new AnimalFactory();
		AnimalDFactoryInterface animal = animalFactory.getAnimal("Cat");
		animal.getAnimal();
	}
	
}
