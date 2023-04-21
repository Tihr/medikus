package medikus.util;

import java.util.UUID;

public class RandomUtils {

	public static String generateUniqueIdentifier()
	{
		return UUID.randomUUID().toString();
	}
}
