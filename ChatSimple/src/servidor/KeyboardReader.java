package servidor;

import java.util.Scanner;

public class KeyboardReader {

    Scanner input;

    public KeyboardReader() {
        input = new Scanner(System.in);
    }

    public int readInt() {
        int num = 0;
        boolean error = false;
        do {
            error = false;
            try {
                num = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return num;
    }

    public int readInt(int minValue, int maxValue) {
        int num = 0;
        boolean error = false;
        do {
            try {
                error = false;
                num = Integer.parseInt(input.nextLine());
                if (num < minValue || num > maxValue) {
                    error = true;
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return num;
    }

    public float readFloat() {
        float num = 0;
        boolean error = false;
        do {
            try {
                error = false;
                num = Float.parseFloat(input.nextLine());
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return num;
    }

    public float readFloat(float min, float max) {
        float num = 0;
        boolean error = false;
        do {
            try {
                error = false;
                num = Float.parseFloat(input.nextLine());
                if (num < min || num > max) {
                    error = true;
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return num;
    }

    public char readChar() {
        char c = '\0';
        boolean error = false;
        do {
            try {
                error = false;
                c = input.nextLine().charAt(0);
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return c;
    }

    public char readChar(char[] chars) {
        char c = '\0';
        boolean error = false;
        do {
            try {
                error = false;
                c = input.nextLine().charAt(0);
                // We can do it in many different ways:
                // Option 1
                boolean exists = false;
                for (char elem : chars) {
                    if (elem == c) {
                        exists = true;
                        break;
                    }
                }
                // Option 2
                /*
				 * for(char elem: chars) { if (elem == c) { error = false;
				 * break; } else error = true; }
                 */
                // Option 3
                /*
				 * for(int i=0; i<chars.length; i++) { if (chars[i] == c) {
				 * error = false; break; } else error = true; }
                 */
                if (!exists) {
                    error = true;
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return c;
    }

    public String readString() {
        String text = new String();
        boolean error = false;
        do {
            try {
                error = false;
                text = input.nextLine();
                if (text.length() == 0) {
                    error = true;
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return text;
    }

    public String readString(int maxLength) {
        String text = new String();
        boolean error = false;
        do {
            try {
                error = false;
                text = input.nextLine();
                if (text.length() < 1 || text.length() > maxLength) {
                    error = true;
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return text;
    }

    public boolean readBoolean(String message) {
        boolean result = false;
        boolean error = false;
        do {
            try {
                error = false;
                System.out.print(message + ": ");
                char response = input.nextLine().charAt(0);
                if (response == 'Y' || response == 'y') {
                    result = true;
                } else if (response == 'N' || response == 'n') {
                    result = false;
                } else {
                    error = true;
                }
            } catch (Exception e) {
                error = true;
                System.out.println("Error: " + e.getMessage());
            }
        } while (error);
        return result;
    }
}
