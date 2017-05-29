package org.glqdlt.home.utills;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class PathFinder {

	final String imageFiles = "jpg , jpeg , bmp , gif , png";
	final String moveFiles = "avi , mp4 , mpeg , wav , mkv";
	final String zipFiles = "rar , zip , alz , 7z";

	int parentCount = 1;

	public void pathFind(String path) {

		File target = new File(path);
		int childCount = 1;
		int imgCheck = 0;

		String childName = "";
		String childAbsolutePath = "";
		String[] fileInformation;

		for (File childFile : target.listFiles()) {
			boolean isLoop = false;
			boolean isZip = false;

			childName = childFile.getName();
			childAbsolutePath = childFile.getAbsolutePath();

			System.out.println("count:[" + parentCount + "-" + childCount + "]");
			System.out.println("length: "+target.listFiles().length);
			System.out.println("imgCheck: " + imgCheck);

			if (childCount == target.listFiles().length) {
				if (imgCheck >= (target.listFiles().length / 2)) {
					System.out.println("cccccccc");
					isZip = true;
				}
			}

			if (childFile.isFile()) {
				System.out.println("file name: " + childName);
				System.out.println("file absolute: " + childAbsolutePath);

				fileInformation = ChildExtension(childName);
				System.out.println("file pureName: " + fileInformation[0]);
				System.out.println("file extension: " + fileInformation[1]);
				System.out.println("=============================");

				if (CheckFilesNameInteger(fileInformation[0])) {
					imgCheck++;
				}
				childCount++;
			} else if (childFile.isDirectory()) {
				System.out.println("dir name: " + childName);
				System.out.println("dir abolute: " + childAbsolutePath);
				System.out.println("=============================");
				isLoop = true;
			}

			if (isZip) {
				System.out.println("Callmake");
				System.out.println(target.getAbsolutePath());
				System.out.println(target.getParentFile().getAbsolutePath());
				MakeZipForJava7(target.getAbsolutePath(), target.getParentFile().getAbsolutePath());
			}

			if (isLoop) {

				try {
					pathFind(childAbsolutePath);
					parentCount++;
				} catch (NullPointerException e) {
					System.out.println("Oops Null point..");
					System.out.println("dir name: " + childAbsolutePath);
					System.out.println("This. is . null");
				}

			}

		}

	}

	public void MakeZipFOrApacheCommon(String dir) throws ZipException, IOException {

		FileInputStream fis = null;

		ZipArchiveOutputStream zos = null;

		FileOutputStream fos = new FileOutputStream(new File("d:/hahaha.zip"));
		zos = new ZipArchiveOutputStream(fos);

		try {
			final File[] srcFiles = new File(dir).listFiles();

			if (srcFiles == null || srcFiles.length == 0) {
				throw new NullPointerException("zip source file(s) is empty (or null).");
			}

			zos.setEncoding(Charset.defaultCharset().name());

			for (int i = 0; i < srcFiles.length; i++) {

				ZipArchiveEntry zipEntry = new ZipArchiveEntry((srcFiles[i]).getName());
				zipEntry.setTime(0);

				zos.putArchiveEntry(zipEntry);
				if (!srcFiles[i].isDirectory()) {
					IOUtils.copy(new FileInputStream(srcFiles[i]), zos);
				}
				zos.closeArchiveEntry();
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (zos != null) {
				zos.close();
			}

		}
	}

	public void MakeZipForJava7(String dir, String zipPath) {

		File Path = new File(dir);

		if (!zipPath.substring(zipPath.length() - 1, zipPath.length()).equals("/")) {
			zipPath = zipPath + "/";
		}
		zipPath = zipPath + RandomStringUtils.randomNumeric(50) + ".zip";

		byte[] buf = new byte[1024];

		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath));

			for (File child : Path.listFiles()) {

				FileInputStream in = new FileInputStream(child);

				// Path 를 넣으면 폴더와 포함되서 압축이 되어진다.
				// out.putNextEntry(new ZipEntry(child.getAbsolutePath()));
				// 아래처럼 GetName으로 경로 없이 넣어 버리면 파일들만 압축이 된다.

				if (!child.isDirectory()) {

					ZipEntry zipE = new ZipEntry(child.getName());
					zipE.setTime(0);
					out.putNextEntry(zipE);
					int len;
					while ((len = in.read(buf)) > 0) {

						out.write(buf, 0, len);

					}
					out.closeEntry();
				}
				in.close();

			}
			out.close();

			MoveZipFileSha(zipPath);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void MoveZipFileSha(String zipPath) throws Exception {
		String shaZip = DigestUtils.FileHashSHA256(zipPath);
		File zip = new File(zipPath);
		if (zip.exists()) {
			zip.renameTo(new File(zip.getParentFile().getAbsolutePath() + "/" + shaZip + ".zip"));
		}
	}

	public boolean CheckFilesNameInteger(String str) {

		final String intRegex = "^[0-9]+$";
		return str.matches(intRegex);

	}

	public List<String> SplitRegex(String str) {

		String[] strList = str.trim().replaceAll(" ", "").split(",");
		return Arrays.asList(strList);
	}

	public String[] ChildExtension(String path) {
		Integer pin = path.lastIndexOf(".");
		String[] strList = { path.substring(0, pin), path.substring(pin + 1, path.length()) };

		return strList;
	}

	public static void main(String[] args) throws IOException {
		PathFinder dd = new PathFinder();

		String dPat = "D:/test";
		dd.pathFind(dPat);

	}
}
