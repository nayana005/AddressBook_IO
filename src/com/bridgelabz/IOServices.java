package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IOServices {
	private final String FILE_PATH = "C:\\Users\\nayan\\OneDrive\\Desktop\\JavaProjects\\IO-AddressBook\\src\\com\\bridgelabz\\PersonDetails.txt";

	public boolean writeData() throws IOException {
		int i=0;
		StringBuffer buffer = new StringBuffer();
		for (ArrayList<Contact> addressBook : AddressBook.addressBookList.values()) {
			String addressBookName = String.valueOf(AddressBook.currentAddressBook.get(i++));
			buffer.append(addressBookName);
			AddressBook.currentAddressBook.forEach(empData -> {
				String empDataString = empData.toString().concat("\n");
				buffer.append(empDataString);
			});
		}

		Path path = Files.write(Paths.get(FILE_PATH),buffer.toString().getBytes());
		return path != null ? true : false;
	}


	public void readData() throws IOException {
		Files.lines(new File(FILE_PATH).toPath()).forEach(System.out::println);
	}
}

