package com.skilldistillery.babychanger.entities;

public enum Rating {
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
	
	
	
	
	Rating(int value){
		this.value = value;
	}
	private int value;
	
	public int getValue() {
		return value;
	}
}
