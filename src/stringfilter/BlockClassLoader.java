package stringfilter;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
//import java.util.Objects;
import java.util.stream.Collectors;

public final class BlockClassLoader {
	public static List<String> getClassesFromPackage(String packageName) {
		URL root = ClassLoader.getSystemResource(packageName.replace(".", "/"));
		File packageDir = new File(URLDecoder.decode(root.getFile(), StandardCharsets.UTF_8));

		File[] packageClassFiles = packageDir.listFiles((dir, fileName) -> fileName.contains(".class"));
		return Arrays.stream(packageClassFiles != null ? packageClassFiles : new File[0])//Objects.requireNonNull(packageClassFiles))
			.map(File::getName)
			.map(fileName -> fileName.replace(".class", ""))
			.filter(className -> !className.equals("Block"))
			.collect(Collectors.toList());
	}
}
