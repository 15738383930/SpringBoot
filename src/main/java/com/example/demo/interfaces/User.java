package com.example.demo.interfaces;

public @interface User {
	String[] name1() default {"Hello","name"};
}
