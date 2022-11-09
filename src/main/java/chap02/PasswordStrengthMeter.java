package chap02;

public class PasswordStrengthMeter {
	public PasswordStrength meter(String s) {
		if (s == null || s.isEmpty()) {
			return PasswordStrength.INVALID;
		}

		int metCounts = getMetCriteriaCounts(s);
		return switch (metCounts) {
			case 2 -> PasswordStrength.NORMAL;
			case 3 -> PasswordStrength.STRONG;
			default -> PasswordStrength.WEAK;
		};
	}

	private static int getMetCriteriaCounts(String s) {
		int metCounts = 0;
		if (s.length() >= 8) {
			metCounts++;
		}
		if (meetsContainingNumberCriteria(s)) {
			metCounts++;
		}
		if (meetsContainingUppercaseCriteria(s)) {
			metCounts++;
		}
		return metCounts;
	}

	private static boolean meetsContainingNumberCriteria(String s) {
		for (char ch : s.toCharArray()) {
			if (ch >= '0' && ch <= '9') {
				return true;
			}
		}
		return false;
	}

	private static boolean meetsContainingUppercaseCriteria(String s) {
		for (char ch : s.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}
		return false;
	}
}
