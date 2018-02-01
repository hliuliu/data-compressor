
import java.util.*;
import java.io.*;
import java.nio.file.*;


public class PathUtil {

	// The seperator of the local file system
	public static final String SEPARATOR = File.separator;

	public static String[] splitPath(String pathStr) {
		return pathStr.split(SEPARATOR);
	}

	public static String baseName(String [] sepPath) {
		return sepPath[sepPath.length-1];
	}

	public static String baseName(String pathStr) {
		return baseName(splitPath(pathStr));
	}

	// the name of the directory to be created to store the compressed information
	public static String getCompressedDataDirname(String path) {
		path = baseName(path);
		return String.format("%s.compressed.info", path);
	}

}

