package com.homework.silenteight;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static com.homework.silenteight.constants.Constants.FEMALE_NAMES_FILE_PATH;
import static com.homework.silenteight.constants.Constants.MALE_NAMES_FILE_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SilentEightApplicationTests {

	@Test
	void shouldFindFileWithMaleNames() {
		File file = new File(MALE_NAMES_FILE_PATH);
		assertEquals("male.txt", file.getName());
	}

	@Test
	void shouldFindFileWithFemaleNames() {
		File file = new File(FEMALE_NAMES_FILE_PATH);
		assertEquals("female.txt", file.getName());
	}

}
