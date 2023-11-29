package applicationjava;

// Java program to read from file "friendsContact.txt"
// and display the contacts
 
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class DisplayFriends {

    public static void main(String data[]) {

        try {

            String nameNumberString;
            String name;
            String searchName = "Cleidy"; // Cambia esto por el nombre que deseas buscar
            long number;
            int index;

            // Using file pointer creating the file.
            File file = new File("C:\\Users\\marco\\Documents\\NetBeansProjects\\ApplicationJava\\friendsContact.txt");

            if (!file.exists()) {
                // Create a new file if not exists.
                file.createNewFile();
            }

            // Opening file in reading and write mode.
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Traversing the file
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // splitting the string to get name and
                // number
                String[] lineSplit = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // Check if the current contact matches the search name
                if (name.equals(searchName)) {
                    // Print the contact data
                    System.out.println(
                            "Friend Name: " + name + "\n"
                                    + "Contact Number: " + number + "\n");

                    found = true; // Indicate that the contact was found
                    break; // No need to continue searching
                }
            }

            // Close the file after reading
            raf.close();

            if (!found) {
                System.out.println("Contact with name '" + searchName + "' not found.");
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        } catch (NumberFormatException nef) {
            System.out.println(nef);
        }
    }
}
