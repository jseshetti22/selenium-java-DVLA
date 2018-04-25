package com.automationFramework;

import com.service.impl.FileInfo;
import com.service.impl.FileResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class asserts the file information in the target directory and 
 * asserts the supported file types
 *
 */

public class FileResourceTest {
	
	@Test
	public void testAllFiles() throws Exception {
		String pathToFolder = "resources";
		FileResource resource = new FileResource(pathToFolder);
		List<FileInfo> allFileInfo = resource.getAllFiles();
		assertEquals(allFileInfo.size() , 4);
	}
	
	@Test
	public void testSupportedFiles()  throws Exception {
		String pathToFolder = "resources";
		FileResource resource = new FileResource(pathToFolder);
		List<String> supportedExts = new ArrayList<String>();
		supportedExts.add("xlsx");
		supportedExts.add("csv");
		List<FileInfo> supportedFiles = resource.getSupportedFiles(supportedExts);
		assertEquals( supportedFiles.size() , 3);
		List<String> expectedFiles = new ArrayList<String>();
		expectedFiles.add("taxCode.csv");
		expectedFiles.add("VehicleData.xlsx");
		expectedFiles.add("Employee.xlsx");

		List<String> fileNames =  new ArrayList<String>();
		for(FileInfo f: supportedFiles) {
			fileNames.add(f.getName());
		}
		assertTrue(fileNames.containsAll(expectedFiles));
	}
}
