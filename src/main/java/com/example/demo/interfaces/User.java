package com.example.demo.interfaces;

public @interface User {
	
	String[] name() default {"Hello","name"};
}
