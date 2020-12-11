/**
 * 
 */
package com.stkprojects.easycontacts.utils;

import java.io.File;
import java.io.IOException;

import com.stkprojects.easycontacts.common.Constants;

/**
 * @author vishwa
 *
 */
public class StoreUtil {

	public static String checkAndCreateStoreFiles(String filepath) {
		File file = new File(filepath);
		if (file.exists()) {
			return "Files are exists !";
		} else {
			try {
				String[] storeFilePaths = filepath.split("/");
				String directory = "";
				String storeFile = "";
				for(String path : storeFilePaths) {
					if(path.contains(".ec")) {
						storeFile=path;
					}else {
						directory = path.concat(Constants.FILE_SEPERATOR);
					}
				}
				File storeDirectory = new File(directory);
				storeDirectory.mkdirs();
				File createFile = new File (directory.concat(storeFile));
				createFile.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			return "Store files created !";
		}
	}

}
