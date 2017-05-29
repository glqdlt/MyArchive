package org.glqdlt.home.utills;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PathFinder {

	final String imageFiles = "jpg , jpeg , bmp , gif , png";
	final String moveFiles = "avi , mp4 , mpeg , wav , mkv";
	final String zipFiles = "rar , zip , alz , 7z";

	int parentCount = 1;

	public void pathFind(String path) {

		File target = new File(path);
		int childCount = 1;

		for (File childFile : target.listFiles()) {
			System.out.println("count:[" + parentCount + "-" + childCount + "]");
			if (childFile.isFile()) {
				System.out.println("file name: " + childFile.getName());
				System.out.println("file absolute: " + childFile.getAbsolutePath());
				System.out.println("file extension: " + CutFileExtension(childFile.getName()));
				System.out.println("=============================");
				childCount++;
			} else if (childFile.isDirectory()) {
				System.out.println("dir name: " + childFile.getName());
				System.out.println("dir abolute: " + childFile.getAbsolutePath());
				System.out.println("=============================");
				try {
					pathFind(childFile.getAbsolutePath().toString());
					parentCount++;
				} catch (NullPointerException e) {
					System.out.println("Oops Null point..");
					System.out.println("dir name: " + childFile.getAbsolutePath());
					System.out.println("This. is . null");
				}
			}

		}

	}

	public List<String> SplitRegex(String str) {

		String[] strList = str.trim().replaceAll(" ", "").split(",");

		return Arrays.asList(strList);
	}

	public String CutFileExtension(String path) {
		Integer pin = path.lastIndexOf(".");
		return path.substring(pin + 1, path.length());
	}

	public static void main(String[] args) throws IOException {
		// String dPat = "D:/";
		PathFinder dd = new PathFinder();
		// dd.pathFind(dPat);
		for (String s : dd.SplitRegex(dd.imageFiles)) {
			System.out.println(s);
		}
		;

	}

}
