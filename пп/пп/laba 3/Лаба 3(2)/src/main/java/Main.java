import java.util.regex.Pattern;

// Program to validate IPv4 address in Java
class Main
{
    private static final String IPV4_REGEX =
            "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";

    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

    public static boolean isValidInet4Address(String ip)
    {
        if (ip == null) {
            return false;
        }

        if (!IPv4_PATTERN.matcher(ip).matches()) {
            return false;
        }

        String[] parts = ip.split("\\.");

        // verify that each of the four subgroups of IPv4 addresses is legal
        try {
            for (String segment: parts)
            {
                // x.0.x.x is accepted but x.01.x.x is not
                if (Integer.parseInt(segment) > 255 ||
                        (segment.length() > 1 && segment.startsWith("0"))) {
                    return false;
                }
            }
        } catch(NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        // an IPv4 address

        StringBuilder INET4ADDRESS = new StringBuilder("1728728");

        INET4ADDRESS.insert(0, '$');
// a = “12--345”
        INET4ADDRESS.insert(1, "{");
// a = “12--3-45”
        INET4ADDRESS.insert(5, ".");
        INET4ADDRESS.insert(7, ".");
        INET4ADDRESS.insert(9, ".");

        INET4ADDRESS.append('}');


        // Validate an IPv4 address
        if (isValidInet4Address(String.valueOf(INET4ADDRESS))) {
            System.out.print("The IP address " + INET4ADDRESS + " is valid");
        }
        else {
            System.out.print("The IP address " + INET4ADDRESS + " is valid");
        }
    }
    }