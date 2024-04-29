import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EmployeeBackup {

    public static void main(String[] args) {
        String sourceDirectory = "path/to/source/directory"; // Directory containing employee information
        String destinationDirectory = "path/to/destination/directory"; // Directory in Darkhan server

        transferData(sourceDirectory, destinationDirectory);
    }

    private static void transferData(String sourceDir, String destinationDir) {
        File source = new File(sourceDir);
        File destination = new File(destinationDir);

        // Check if source directory exists
        if (!source.exists() || !source.isDirectory()) {
            System.out.println("Source directory doesn't exist or is not a directory.");
            return;
        }

        // Check if destination directory exists, create if not
        if (!destination.exists()) {
            destination.mkdirs();
        }

        // Get list of files in source directory
        File[] files = source.listFiles();

        // Transfer each file to destination directory
        if (files != null) {
            for (File file : files) {
                try {
                    FileInputStream inputStream = new FileInputStream(file);
                    FileOutputStream outputStream = new FileOutputStream(new File(destination, file.getName()));

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, length);
                    }

                    // Close streams
                    inputStream.close();
                    outputStream.close();

                    System.out.println("File " + file.getName() + " transferred successfully.");
                } catch (IOException e) {
                    System.out.println("Error transferring file: " + e.getMessage());
                }
            }
        }
    }
}

