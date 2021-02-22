package com.homework.silenteight;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SilentEightApplicationTests {

	@Test
	void shouldFindFileWithMaleNames() {
		File file = new File("src/main/resources/genderNames/male.txt");
		assertEquals("male.txt", file.getName());
	}

	@Test
	void shouldFindFileWithFemaleNames() {
		File file = new File("src/main/resources/genderNames/female.txt");
		assertEquals("female.txt", file.getName());
	}

}
