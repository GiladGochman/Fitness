
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class workout {
    public static MainFrame a = new MainFrame();
    public static final String DATA_FILE = "data.txt";
    public static Data data = workout.readDataFromFile("data.txt");

    public static void main(String[] args) {
        if (data == null) {
            data = new Data();
        }
    }

    public static Data readDataFromFile(String file) {
        File f = new File(file);
        if (f.exists()) {
            ObjectInputStream inStream = null;
            try {
                inStream = new ObjectInputStream(new FileInputStream(f));
                Data data = (Data)inStream.readObject();
                return data;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                if (inStream != null) {
                    try {
                        inStream.close();
                    }
                    catch (Exception exception) {}
                }
            }
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void saveDataToFile(Data data, String fileName) {
        ObjectOutputStream outStream = null;
        try {
            try {
                outStream = new ObjectOutputStream(new FileOutputStream(fileName));
                outStream.writeObject(data);
                return;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                if (outStream == null) return;
                try {
                    outStream.close();
                    return;
                }
                catch (Exception exception) {}
                return;
            }
            catch (IOException e) {
                e.printStackTrace();
                if (outStream == null) return;
                try {
                    outStream.close();
                    return;
                }
                catch (Exception exception) {}
                return;
            }
        }
        finally {
            if (outStream != null) {
                try {
                    outStream.close();
                }
                catch (Exception exception) {}
            }
        }
    }
}

